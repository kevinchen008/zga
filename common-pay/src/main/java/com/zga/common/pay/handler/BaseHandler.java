package com.zga.common.pay.handler;

import com.zga.common.pay.dto.BaseResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-01-31 12:10
 */
public abstract class BaseHandler<Req, Res extends BaseResponse> {

    public abstract boolean check(Req req);

    public abstract Res handler(Req req);

    public Res execute(Req req) {
        int repeatTimes = 3;
        if (check(req)) {
            while (repeatTimes-- > 0) {
                try {
                    return handler(req);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            throw new RuntimeException("Handler 执行失败");
        } else {
            return null;
        }
    }

}
