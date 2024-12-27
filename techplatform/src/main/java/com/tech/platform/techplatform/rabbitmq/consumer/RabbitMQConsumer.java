package com.tech.platform.techplatform.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.tech.platform.techplatform.rabbitmq.contants.ConfigurationConstants.TECH_PLATFORM_SIMPLE_QUEUE;

@Component
public class RabbitMQConsumer {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitListener(queues = TECH_PLATFORM_SIMPLE_QUEUE)
    public void receiveMessage(String message) {
        logger.info("queue {} received registration message: {}", TECH_PLATFORM_SIMPLE_QUEUE, message);
    }
}
