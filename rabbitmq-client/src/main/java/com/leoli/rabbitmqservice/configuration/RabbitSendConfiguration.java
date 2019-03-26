package com.leoli.rabbitmqservice.configuration;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import org.springframework.amqp.core.*;
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
    public Queue queue() {
        return new Queue("ocLog");
    }

    @Bean
    public Exchange directExchange() {
        return new DirectExchange("ocExchange");
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("log").noargs();
    }

}
