package com.zga.msg.consumer.listener;

import com.aliyuncs.exceptions.ClientException;
import com.zga.msg.beans.AliSmsMessage;
import com.zga.msg.consumer.service.MessageService;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: java类作用描述
 * @Author: kevin.chen
 * @CreateDate: 2018/2/23 11:40
 * @Version: 1.0
 */
public class AliSmsConsumer implements MessageListener {

    @Autowired
    MessageService messageService;

    @Override
    public void onMessage(Message message) {
        try {
            if (null != message.getBody()) {
                AliSmsMessage aliSmsMessage = SerializationUtils.deserialize(message.getBody());
                messageService.sendMessage(aliSmsMessage);
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
