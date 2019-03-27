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
    @Bean(name = "multiListenerContainer")
    public SimpleRabbitListenerContainerFactory multiListenerContainer(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factoryConfigurer.configure(factory,connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
        factory.setConcurrentConsumers(20);
        factory.setMaxConcurrentConsumers(20);
        factory.setPrefetchCount(5);
        return factory;
    }
//
//    @Bean
//    public Queue queue() {
//        return new Queue("ocLog");
//
//    }
//
//    @Bean
//    public Exchange directExchange() {
//        return new DirectExchange("ocExchange");
//    }
//
//    @Bean
//    public Binding directBinding() {
//        return BindingBuilder.bind(queue()).to(directExchange()).with("log").noargs();
//    }
}
