package com.zga.common.pay.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 12:33
 */
public class OrderRequest extends BaseRequest {
    //订单号
    private String orderNo;
    //交易金额（分为单位）
    private double amount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
