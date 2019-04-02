package com.li.bsk.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue")
public class Receiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println ("测试一：" + msg);
    }
}
