package com.zga.hala.pay.controller;

import com.zga.common.pay.dto.OrderRequest;
import com.zga.common.pay.dto.OrderResponse;
import com.zga.common.pay.service.IPayService;
import com.zga.common.utils.LogUtil;
import com.zga.hala.pay.biz.OrderInfo;
import com.zga.sdk.unionAcp.AcpService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 14:58
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    IPayService payService;

    @Autowired
    AcpService acpService;

    @RequestMapping("/zhifu")
    public void request(@RequestBody OrderInfo orderInfo, HttpServletResponse response) throws IOException {
        OrderRequest orderRequest = new OrderRequest();
        BeanUtils.copyProperties(orderInfo,orderRequest);
        OrderResponse orderResponse = payService.request(orderRequest);
        String html = acpService.createAutoFormHtml(orderResponse.getResultUrl(), orderResponse.getFormInputMap(),"utf-8");
        response.getWriter().write(html);
    }

    @RequestMapping("/acpBackCallback")
    public void unionPayAcpCallBack(HttpServletRequest req, HttpServletResponse resp){
        LogUtil.writeLog("BackRcvResponse接收后台通知开始");
        // 获取银联通知服务器发送的后台通知参数
        Map<String, String> reqParam = getAllRequestParamStream(req);
        payService.unionPayAcpCallBack(reqParam);
    }


    /**
     * 获取请求参数中所有的信息。
     * 非struts可以改用此方法获取，好处是可以过滤掉request.getParameter方法过滤不掉的url中的参数。
     * struts可能对某些content-type会提前读取参数导致从inputstream读不到信息，所以可能用不了这个方法。理论应该可以调整struts配置使不影响，但请自己去研究。
     * 调用本方法之前不能调用req.getParameter("key");这种方法，否则会导致request取不到输入流。
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParamStream(
            final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        try {
            String notifyStr = new String(IOUtils.toByteArray(request.getInputStream()),"utf-8");
            LogUtil.writeLog("收到通知报文：" + notifyStr);
            String[] kvs= notifyStr.split("&");
            for(String kv : kvs){
                String[] tmp = kv.split("=");
                if(tmp.length >= 2){
                    String key = tmp[0];
                    String value = URLDecoder.decode(tmp[1],"utf-8");
                    res.put(key, value);
                }
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.writeLog("getAllRequestParamStream.UnsupportedEncodingException error: " + e.getClass() + ":" + e.getMessage());
        } catch (IOException e) {
            LogUtil.writeLog("getAllRequestParamStream.IOException error: " + e.getClass() + ":" + e.getMessage());
        }
        return res;
    }
}
