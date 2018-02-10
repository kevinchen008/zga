package com.zga.msg.producer.bean;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-02-01 17:42
 */
public class AliSmsMessage {
    private String accessId;
    private String accessKey;
    private String mnsEndpoint;
    private String smsTemplateCode;
    private Map params;
    private String signName;
    private String[] mobileArray;

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getMnsEndpoint() {
        return mnsEndpoint;
    }

    public void setMnsEndpoint(String mnsEndpoint) {
        this.mnsEndpoint = mnsEndpoint;
    }

    public String getSmsTemplateCode() {
        return smsTemplateCode;
    }

    public void setSmsTemplateCode(String smsTemplateCode) {
        this.smsTemplateCode = smsTemplateCode;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String[] getMobileArray() {
        return mobileArray;
    }

    public void setMobileArray(String[] mobileArray) {
        this.mobileArray = mobileArray;
    }
}
