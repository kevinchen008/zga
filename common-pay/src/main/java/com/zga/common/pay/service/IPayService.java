package com.zga.common.pay.service;

import com.zga.common.pay.dto.OrderRequest;
import com.zga.common.pay.dto.OrderResponse;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 14:18
 */
public interface IPayService {
    public OrderResponse request(OrderRequest orderRequest);
    public void unionPayAcpCallBack(Map<String, String> map);
}
