package com.zga.msg.producer.sender;

import org.springframework.amqp.core.AmqpTemplate;

public class AliSmsSendMessage {

    private AmqpTemplate amqpTemplate;

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    public void sendMsg(AliSmsSendMessage aliSmsSendMessage){
        amqpTemplate.convertAndSend(aliSmsSendMessage);
    }

}
