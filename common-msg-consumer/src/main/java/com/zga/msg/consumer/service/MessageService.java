package com.zga.msg.consumer.service;

import com.zga.msg.consumer.common.BaseMessage;
import com.zga.msg.consumer.handler.BaseHandler;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2018-02-01 16:05
 */

@Service
public class MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private ApplicationContext context;


    public void sendQueue(String exchange_key, String queue_key, Object object) {
        // convertAndSend 将Java对象转换为消息发送至匹配key的交换机中Exchange
        amqpTemplate.convertAndSend(exchange_key, queue_key, object);
    }

    public void sendMessage(BaseMessage baseMessage){
        makeHandler(getHandlerListByType(BaseHandler.class),baseMessage);
    }

    public void makeHandler(List<BaseHandler> handlers, BaseMessage baseMessage){
        for(BaseHandler handler:handlers){
            handler.execute(baseMessage);
        }
        throw new RuntimeException("no handler error.");
    }

    /**
     * 根据注解获取handler
     * @param c
     * @return
     */
    private List<BaseHandler> getHandlerListByType(Class c) {
        //TODO - low: cache it
        Map<String, Object> mr = context.getBeansWithAnnotation(c);
        List<BaseHandler> result = new ArrayList<>();
        for(String key : mr.keySet()) {
            result.add((BaseHandler)mr.get(key));
        }
        return result;
    }
}
