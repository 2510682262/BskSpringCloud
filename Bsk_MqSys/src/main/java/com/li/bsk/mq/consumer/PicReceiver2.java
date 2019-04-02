package com.li.bsk.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class PicReceiver2 {

    @RabbitHandler
    public void process(String msg){
        System.out.println ("TopicReceiver2：" + msg);
    }
}
