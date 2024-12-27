package com.tech.platform.techplatform.rabbitmq.controller;

import com.tech.platform.techplatform.rabbitmq.model.MQModel;
import com.tech.platform.techplatform.rabbitmq.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @PostMapping("/produce")
    public boolean produceMessage(@RequestBody MQModel mqmodel){
        rabbitMQProducer.sendMessage(mqmodel);
        return true;
    }

}
