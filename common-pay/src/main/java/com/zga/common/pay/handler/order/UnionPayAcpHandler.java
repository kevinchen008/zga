package com.zga.common.pay.handler.order;

import com.zga.common.pay.dto.OrderRequest;
import com.zga.common.pay.dto.OrderResponse;
import com.zga.common.pay.handler.BaseHandler;
import com.zga.common.pay.handler.RequestHandler;
import com.zga.common.pay.service.Channel;
import com.zga.common.utils.DateUtils;
import com.zga.config.UnionPayAcpsdkProperties;
import com.zga.sdk.unionAcp.AcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 13:16
 */
@Component
@RequestHandler
public class UnionPayAcpHandler extends BaseHandler<OrderRequest,OrderResponse> {
    
    @Autowired
    UnionPayAcpsdkProperties unionPayAcpsdkProperties;

    @Autowired
    AcpService acpService;
    
    @Override
    public boolean check(OrderRequest orderRequest) {
        if(orderRequest.getChannel()!=null && orderRequest.getChannel().equals(Channel.unionpay_acp)){
           return true;
        }
        return false;
    }

    @Override
    public OrderResponse handler(OrderRequest orderRequest) {
        //前台页面传过来的
        String txnAmt = orderRequest.getAmount()+"";
        String orderId = orderRequest.getOrderNo();

        Map<String, String> requestData = new HashMap<String, String>();

        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        requestData.put("version", unionPayAcpsdkProperties.getVersion());   			  //版本号，全渠道默认值
        requestData.put("encoding", unionPayAcpsdkProperties.getEncoding()); 			  //字符集编码，可以使用UTF-8,GBK两种方式
        requestData.put("signMethod", unionPayAcpsdkProperties.getSignMethod()); //签名方法
        requestData.put("txnType", unionPayAcpsdkProperties.getTxnType());               			  //交易类型 ，01：消费
        requestData.put("txnSubType", unionPayAcpsdkProperties.getTxnSubType());            			  //交易子类型， 01：自助消费
        requestData.put("bizType", unionPayAcpsdkProperties.getBizType());           			  //业务类型，B2C网关支付，手机wap支付
        requestData.put("channelType", unionPayAcpsdkProperties.getChannelType());           			  //渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板  08：手机

        /***商户接入参数***/
        requestData.put("merId", unionPayAcpsdkProperties.getMerId());    	          			  //商户号码，请改成自己申请的正式商户号或者open上注册得来的777测试商户号
        requestData.put("accessType", unionPayAcpsdkProperties.getAccessType());             			  //接入类型，0：直连商户
        requestData.put("orderId",orderId);             //商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
        requestData.put("txnTime", DateUtils.formatDate(new Date(),"yyyyMMddHHmmss"));        //订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
        requestData.put("currencyCode", unionPayAcpsdkProperties.getCurrencyCode());         			  //交易币种（境内商户一般是156 人民币）
        requestData.put("txnAmt", txnAmt);             			      //交易金额，单位分，不要带小数点
        //requestData.put("reqReserved", "透传字段");        		      //请求方保留域，如需使用请启用即可；透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节。出现&={}[]符号时可能导致查询接口应答报文解析失败，建议尽量只传字母数字并使用|分割，或者可以最外层做一次base64编码(base64编码之后出现的等号不会导致解析失败可以不用管)。

        //前台通知地址 （需设置为外网能访问 http https均可），支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
        requestData.put("frontUrl", unionPayAcpsdkProperties.getFrontUrl());
        //后台通知地址（需设置为【外网】能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
        requestData.put("backUrl", unionPayAcpsdkProperties.getBackUrl());
        // 订单超时时间。
        requestData.put("payTimeout", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime() + 15 * 60 * 1000));
        /**请求参数设置完毕，以下对请求参数进行签名并生成html表单，将表单写入浏览器跳转打开银联页面**/

        Map<String, String> submitFromData = acpService.sign(requestData,unionPayAcpsdkProperties.getEncoding());  //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String requestFrontUrl = unionPayAcpsdkProperties.getFrontTransUrl();  //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
        Date dateEnd =null;
        try {
            dateEnd = DateUtils.parseDate(requestData.get("payTimeout"),"yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        OrderResponse orderResponse = new OrderResponse(true, submitFromData,requestFrontUrl,dateEnd,"");
        return orderResponse;
    }

    @Override
    public OrderResponse execute(OrderRequest orderRequest) {
        return super.execute(orderRequest);
    }
}
