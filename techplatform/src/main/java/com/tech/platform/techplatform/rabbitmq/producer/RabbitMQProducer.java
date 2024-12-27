package com.tech.platform.techplatform.rabbitmq.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.platform.techplatform.rabbitmq.model.MQModel;
import com.tech.platform.techplatform.rabbitmq.model.user.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.tech.platform.techplatform.rabbitmq.contants.ConfigurationConstants.TECH_PLATFORM_EXCHANGE_KEY;
import static com.tech.platform.techplatform.rabbitmq.contants.ConfigurationConstants.TECH_PLATFORM_ROUTE_KEY;

@Component
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean sendMessage(MQModel mqModel) {
        boolean sendResult = false;
        UserModel um = mqModel.getContent();
        String message = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            message = objectMapper.writeValueAsString(um);
            //rabbitTemplate.convertSendAndReceive(message);
            rabbitTemplate.convertSendAndReceive(TECH_PLATFORM_EXCHANGE_KEY,TECH_PLATFORM_ROUTE_KEY, message);
            sendResult = true;
        } catch(Exception ignored){

        }
        return sendResult;
    }

}
