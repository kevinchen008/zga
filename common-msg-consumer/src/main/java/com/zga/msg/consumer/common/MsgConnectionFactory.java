package com.zga.msg.consumer.common;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-02-01 13:41
 */
public interface MsgConnectionFactory {
     void connect();
     void destory();
}
