package com.li.bsk.mq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("mq/send")
    public String send(){
        String contentr = "Date：" + new Date ();
        amqpTemplate.convertAndSend ("queue",contentr);
        return contentr;
    }

    @GetMapping("mq/multiSend")
    public String multiSend(){
        StringBuffer times = new StringBuffer ();
        for(int i = 0; i< 10; i++){
            long time = System.nanoTime ();
            amqpTemplate.convertAndSend ("queue",
                    "第" + i + "次发送的时间：" + time);
            times.append (time+"<br>");
        }
        return times.toString ();
    }

    @GetMapping("mq/topicSend")
    public String topicSend(){
        String context = "my topic 1";
        System.out.println ("发送者说：" + context);
        this.amqpTemplate.convertAndSend ("exchange","topic.message",context);
        return context;
    }

    @GetMapping("mq/topicSend2")
    public String topicSend2(){
        String context = "my topic 2";
        System.out.println ("发送者说：" + context);
        this.amqpTemplate.convertAndSend ("exchange","topic.messages",context);
        return context;
    }

}
