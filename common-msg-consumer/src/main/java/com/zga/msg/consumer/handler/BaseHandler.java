package com.zga.msg.consumer.handler;

import com.aliyuncs.exceptions.ClientException;
import com.zga.msg.common.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-02-01 16:41
 */
public abstract class BaseHandler {
    abstract boolean check(BaseMessage message);

    abstract void handle(BaseMessage message) throws ClientException;

    public void execute(BaseMessage baseMessage) throws ClientException {
        if (check(baseMessage)) {
            handle(baseMessage);
        }
    }
}
