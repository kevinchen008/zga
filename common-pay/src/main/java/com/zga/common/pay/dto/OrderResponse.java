package com.zga.common.pay.dto;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 13:15
 */
public class OrderResponse implements  BaseResponse {

    private boolean result;

    private Map<String,String> formInputMap;

    private String resultUrl;

    private Date timeEnd;

    private String errorMsg;

    public OrderResponse() {
    }

    public OrderResponse(boolean result, Map<String, String> formInputMap, String resultUrl, Date timeEnd, String errorMsg) {
        this.result = result;
        this.formInputMap = formInputMap;
        this.resultUrl = resultUrl;
        this.timeEnd = timeEnd;
        this.errorMsg = errorMsg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Map<String, String> getFormInputMap() {
        return formInputMap;
    }

    public void setFormInputMap(Map<String, String> formInputMap) {
        this.formInputMap = formInputMap;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
