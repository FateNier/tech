package com.tech.platform.techplatform.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.tech.platform.techplatform.rabbitmq.contants.ConfigurationConstants.TECH_PLATFORM_SIMPLE_QUEUE;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue Queue(){
        return new Queue(TECH_PLATFORM_SIMPLE_QUEUE);
    }
}
