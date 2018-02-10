package com.zga.common.pay.service;

import com.zga.common.pay.dto.BaseResponse;
import com.zga.common.pay.dto.OrderRequest;
import com.zga.common.pay.dto.OrderResponse;
import com.zga.common.pay.handler.BaseHandler;
import com.zga.common.pay.handler.RequestHandler;
import com.zga.common.utils.LogUtil;
import com.zga.sdk.unionAcp.AcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 14:20
 */
@Component
public class PayServiceImpl implements IPayService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private AcpService acpService;

    @Override
    public OrderResponse request(OrderRequest orderRequest) {
       return (OrderResponse) makeRequest(getHandlerListByType(RequestHandler.class),orderRequest);
    }

    @Override
    public void unionPayAcpCallBack(Map<String, String> map) {
        //重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
        if (!acpService.validate(map, "utf-8")) {
            LogUtil.writeLog("验证签名结果[失败].");
            //验签失败，需解决验签问题

        } else {
            LogUtil.writeLog("验证签名结果[成功].");
            //【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态

            String orderId =map.get("orderId"); //获取后台通知的数据，其他字段也可用类似方式获取
            String respCode = map.get("respCode");
            //判断respCode=00、A6后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。

        }
    }

    public BaseResponse makeRequest(List<BaseHandler> orderRequestHandler, OrderRequest orderRequest){
        for(BaseHandler handler :orderRequestHandler){
           BaseResponse result =  handler.execute(orderRequest);
           if(result!=null){
               return result;
           }
        }
        throw new RuntimeException("No handle found!");
    }

    /**
     * 根据注解获取handler
     * @param c
     * @return
     */
    private List<BaseHandler> getHandlerListByType(Class c) {
        //TODO - low: cache it
        Map<String, Object> mr = context.getBeansWithAnnotation(c);
        List<BaseHandler> result = new ArrayList<>();
        for(String key : mr.keySet()) {
            result.add((BaseHandler)mr.get(key));
        }
        return result;
    }

}
