package com.zga.msg.consumer.common;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-02-01 16:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface SmsHandler {
}
