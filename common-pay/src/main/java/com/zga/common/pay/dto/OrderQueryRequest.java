package com.zga.common.pay.dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 16:45
 */
public class OrderQueryRequest extends BaseRequest {
    private String orderNo;

    private Date orderCdate;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderCdate() {
        return orderCdate;
    }

    public void setOrderCdate(Date orderCdate) {
        this.orderCdate = orderCdate;
    }
}
