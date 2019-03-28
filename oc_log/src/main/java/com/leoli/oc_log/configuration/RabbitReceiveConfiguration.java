package com.leoli.oc_log.configuration;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitReceiveConfiguration {
    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;
    @Autowired
    private CachingConnectionFactory connectionFactory;

//    @Autowired
//    MessagingMessageListenerAdapter messageListenerAdapter;

    @Bean(name = "multiListenerContainer")
    public SimpleRabbitListenerContainerFactory multiListenerContainer(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factoryConfigurer.configure(factory,connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        //AcknowledgeMode.AUTO 根据状态自动确认
        // AcknowledgeMode.NONE 不确认，消费者拿到后消息队伍就没有了，不管后面有没有抛出exception
        // AcknowledgeMode.MANUAL 手动确认，消费者确认无误后，可以via a channel aware listener
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setConcurrentConsumers(20);
        factory.setMaxConcurrentConsumers(20);
        factory.setPrefetchCount(5);
        return factory;
    }
}
