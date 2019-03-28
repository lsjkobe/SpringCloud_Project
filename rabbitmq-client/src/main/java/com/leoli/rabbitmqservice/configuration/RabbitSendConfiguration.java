package com.leoli.rabbitmqservice.configuration;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitSendConfiguration {
    //    @Autowired
//    CachingConnectionFactory cachingConnectionFactory;
//
//    /**
//     * 单一消费者
//     * @return
//     */
//    @Bean(name = "singleListenerContainer")
//    public SimpleRabbitListenerContainerFactory listenerContainer() {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(cachingConnectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setConcurrentConsumers(1);
//        factory.setMaxConcurrentConsumers(1);
//        factory.setPrefetchCount(1);
//        factory.setTxSize(1);
//        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        return factory;
//    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @Autowired
    PropertyConfiguration property;
    @Bean
    public Queue queue() {
        return new Queue(property.getQueue());
    }

    @Bean
    public Exchange directExchange() {
        return new DirectExchange(property.getExchange());
    }

    @Bean
    public Binding directLogBinding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(property.getKey()).noargs();
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutLog");//配置广播路由器
    }

    @Bean
    public Queue fanoutLogQueue() {
        return new Queue("ocLog1");
    }

//    @Bean
//    public Binding fanoutLogBinding1() {
//        return BindingBuilder.bind(queue()).to(fanoutExchange());
//    }

    @Bean
    public Binding fanoutLogBinding2() {
        return BindingBuilder.bind(fanoutLogQueue()).to(fanoutExchange());
    }

//    topic exchange
    @Bean
    public Queue topicLogQueue(){
        return new Queue("ocTopicLogQueue");
    }

    @Bean
    public Exchange topicLogExchange(){
        return new TopicExchange("ocTopicLogExchange");
    }

    @Bean
    public Binding topicLogBinding() {
        return BindingBuilder.bind(topicLogQueue()).to(topicLogExchange()).with("log.#").noargs();
    }
}
