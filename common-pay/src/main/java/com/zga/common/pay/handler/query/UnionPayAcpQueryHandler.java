package com.zga.common.pay.handler.query;

import com.zga.common.pay.dto.OrderQueryRequest;
import com.zga.common.pay.dto.OrderResponse;
import com.zga.common.pay.handler.BaseHandler;
import com.zga.common.pay.handler.QueryHandler;
import com.zga.common.pay.service.Channel;
import com.zga.common.utils.LogUtil;
import com.zga.config.UnionPayAcpsdkProperties;
import com.zga.sdk.unionAcp.AcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 16:09
 */
@Component
@QueryHandler
public class UnionPayAcpQueryHandler extends BaseHandler<OrderQueryRequest,OrderResponse> {

    @Autowired
    UnionPayAcpsdkProperties unionPayAcpsdkProperties;

    @Autowired
    AcpService acpService;

    @Override
    public boolean check(OrderQueryRequest orderRequest) {
        if(orderRequest.getChannel()!=null && orderRequest.getChannel().equals(Channel.unionpay_acp_query)){
            return true;
        }
        return false;
    }

    @Override
    public OrderResponse handler(OrderQueryRequest orderRequest) {
        String orderId ="";
        String txnTime ="";

        Map<String, String> data = new HashMap<String, String>();

        /***银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改***/
        data.put("version", unionPayAcpsdkProperties.getVersion());                 //版本号
        data.put("encoding", unionPayAcpsdkProperties.getEncoding());               //字符集编码 可以使用UTF-8,GBK两种方式
        data.put("signMethod", unionPayAcpsdkProperties.getSignMethod()); //签名方法
        data.put("txnType", "00");                             //交易类型 00-默认
        data.put("txnSubType", "00");                          //交易子类型  默认00
        data.put("bizType", "000201");                         //业务类型 B2C网关支付，手机wap支付

        /***商户接入参数***/
        data.put("merId", "777290058110048");                  //商户号码，请改成自己申请的商户号或者open上注册得来的777商户号测试
        data.put("accessType", "0");                           //接入类型，商户接入固定填0，不需修改

        /***要调通交易以下字段必须修改***/
        data.put("orderId", orderId);                 //****商户订单号，每次发交易测试需修改为被查询的交易的订单号
        data.put("txnTime", txnTime);                 //****订单发送时间，每次发交易测试需修改为被查询的交易的订单发送时间

        /**请求参数设置完毕，以下对请求参数进行签名并发送http post请求，接收同步应答报文------------->**/

        Map<String, String> reqData = acpService.sign(data,unionPayAcpsdkProperties.getEncoding());//报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。

        String url = unionPayAcpsdkProperties.getSingleQueryUrl();// 交易请求url从配置文件读取对应属性文件acp_sdk.properties中的 acpsdk.singleQueryUrl
        //这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过
        Map<String, String> rspData = acpService.post(reqData,url,unionPayAcpsdkProperties.getEncoding());

        /**对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考------------->**/
        //应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
        if(!rspData.isEmpty()){
            if(acpService.validate(rspData, unionPayAcpsdkProperties.getEncoding())){
                LogUtil.writeLog("验证签名成功");
                if("00".equals(rspData.get("respCode"))){//如果查询交易成功
                    //处理被查询交易的应答码逻辑
                    String origRespCode = rspData.get("origRespCode");
                    if("00".equals(origRespCode)){
                        //交易成功，更新商户订单状态
                        //TODO
                    }else if("03".equals(origRespCode) ||
                            "04".equals(origRespCode) ||
                            "05".equals(origRespCode)){
                        //需再次发起交易状态查询交易
                        //TODO
                    }else{
                        //其他应答码为失败请排查原因
                        //TODO
                    }
                }else{//查询交易本身失败，或者未查到原交易，检查查询交易报文要素
                    //TODO
                }
            }else{
                LogUtil.writeErrorLog("验证签名失败");
                //TODO 检查验证签名失败的原因
            }
        }else{
            //未返回正确的http状态
            LogUtil.writeErrorLog("未获取到返回报文或返回http状态码非200");
        }
        return null;
    }

    @Override
    public OrderResponse execute(OrderQueryRequest orderRequest) {
        return super.execute(orderRequest);
    }
}
