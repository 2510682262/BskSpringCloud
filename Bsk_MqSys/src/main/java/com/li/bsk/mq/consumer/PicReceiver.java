package com.li.bsk.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class PicReceiver {

    @RabbitHandler
    public void process(String msg){ System.out.println ("TopicReceiver1：" + msg); }
}
