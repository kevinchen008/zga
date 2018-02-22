package com.zga.msg.producer.sender;

import com.zga.msg.beans.AliSmsMessage;
import org.springframework.amqp.core.AmqpTemplate;

public class AliSmsSendMessage {

    private AmqpTemplate amqpTemplate;

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    public void sendMsg(AliSmsMessage aliSmsMessage){
        amqpTemplate.convertAndSend(aliSmsMessage);
    }

}
