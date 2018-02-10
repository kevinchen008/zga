package com.zga.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-23 10:22
 */
@Configuration
public class UnionPayAcpsdkProperties {
    //商户ID
    @Value("pay.unionPay.acpsdk.merId")
    private String merId;
    //版本号，全渠道默认值
    @Value("pay.unionPay.acpsdk.version")
    private String version;
    //字符集编码，可以使用UTF-8,GBK两种方式
    @Value("pay.unionPay.acpsdk.encoding")
    private String encoding;
    //签名方法
    @Value("pay.unionPay.acpsdk.signMethod")
    private String signMethod;
    //交易类型 ，01：消费
    @Value("pay.unionPay.acpsdk.txnType")
    private String txnType;
    //交易子类型， 01：自助消费
    @Value("pay.unionPay.acpsdk.txnSubType")
    private String txnSubType;
    //业务类型，B2C网关支付，手机wap支付
    @Value("pay.unionPay.acpsdk.bizType")
    private String bizType;
    //渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板  08：手机
    @Value("pay.unionPay.acpsdk.channelType")
    private String channelType;
    //接入类型，0：直连商户
    @Value("pay.unionPay.acpsdk.accessType")
    private String accessType;
    //交易币种（境内商户一般是156 人民币）
    @Value("pay.unionPay.acpsdk.currencyCode")
    private String currencyCode;
    //前台通知地址 （需设置为外网能访问 http https均可），支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
    //如果想要实现过几秒中自动跳转回商户页面权限，需联系银联业务申请开通自动返回商户权限
    //异步通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
    @Value("pay.unionPay.acpsdk.frontUrl")
    private String frontUrl;
    //后台通知地址（需设置为【外网】能访问 http https均可），支付成功后银联会自动将异步通知报文post到商户上送的该地址，失败的交易银联不会发送后台通知
    //后台通知参数详见open.unionpay.com帮助中心 下载  产品接口规范  网关支付产品接口规范 消费交易 商户通知
    //注意:1.需设置为外网能访问，否则收不到通知    2.http https均可  3.收单后台通知后需要10秒内返回http200或302状态码
    //    4.如果银联通知服务器发送通知后10秒内未收到返回状态码或者应答码非http200，那么银联会间隔一段时间再次发送。总共发送5次，每次的间隔时间为0,1,2,4分钟。
    //    5.后台通知地址如果上送了带有？的参数，例如：http://abc/web?a=b&c=d 在后台通知处理程序验证签名之前需要编写逻辑将这些字段去掉再验签，否则将会验签失败
    @Value("pay.unionPay.acpsdk.backUrl")
    private String backUrl;
    //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
    @Value("pay.unionPay.acpsdk.frontTransUrl")
    private String frontTransUrl;
    //获取查询银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.singleQueryUrl
    @Value("pay.unionPay.acpsdk.singleQueryUrl")
    private String singleQueryUrl;
    /** 签名证书路径. */
    @Value("pay.unionPay.acpsdk.signCertPath")
    private String signCertPath;
    /** 签名证书密码. */
    @Value("pay.unionPay.acpsdk.signCertPwd")
    private String signCertPwd;
    /** 签名证书类型. */
    @Value("pay.unionPay.acpsdk.signCertType")
    private String signCertType;
    /** 中级证书路径  */
    @Value("pay.unionPay.acpsdk.middleCertPath")
    private String middleCertPath;
    /** 根证书路径  */
    @Value("pay.unionPay.acpsdk.rootCertPath")
    private String rootCertPath;
    /** 加密公钥证书路径. */
    @Value("pay.unionPay.acpsdk.encryptCertPath")
    private String encryptCertPath;

    public String getEncryptCertPath() {
        return encryptCertPath;
    }

    public void setEncryptCertPath(String encryptCertPath) {
        this.encryptCertPath = encryptCertPath;
    }

    public String getMiddleCertPath() {
        return middleCertPath;
    }

    public void setMiddleCertPath(String middleCertPath) {
        this.middleCertPath = middleCertPath;
    }

    public String getRootCertPath() {
        return rootCertPath;
    }

    public void setRootCertPath(String rootCertPath) {
        this.rootCertPath = rootCertPath;
    }

    public String getSignCertPath() {
        return signCertPath;
    }

    public void setSignCertPath(String signCertPath) {
        this.signCertPath = signCertPath;
    }

    public String getSignCertPwd() {
        return signCertPwd;
    }

    public void setSignCertPwd(String signCertPwd) {
        this.signCertPwd = signCertPwd;
    }

    public String getSignCertType() {
        return signCertType;
    }

    public void setSignCertType(String signCertType) {
        this.signCertType = signCertType;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getFrontTransUrl() {
        return frontTransUrl;
    }

    public void setFrontTransUrl(String frontTransUrl) {
        this.frontTransUrl = frontTransUrl;
    }

    public String getSingleQueryUrl() {
        return singleQueryUrl;
    }

    public void setSingleQueryUrl(String singleQueryUrl) {
        this.singleQueryUrl = singleQueryUrl;
    }
}
