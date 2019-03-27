package com.leoli.rabbitmqservice.controller;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import com.leoli.rabbitmqservice.configuration.PropertyConfiguration;
import org.apache.logging.log4j.Level;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    PropertyConfiguration property;

    @GetMapping(value = "/send/sample/{msg}")
    public Object sendSample(@PathVariable("msg") String msg) {
        return rabbitTemplate.convertSendAndReceive(property.getExchange(),property.getKey(), msg);
    }
//
    @GetMapping(value = "/send/fanout/{msg}")
    public Object sendLog(@PathVariable("msg") String msg) {
        ConcurrentHashMap<String , Object> map = new ConcurrentHashMap<>();
        map.put("logMsg", msg);
        map.put("logLevel", Level.INFO.name());
        return rabbitTemplate.convertSendAndReceive("fanoutLog","", map);
    }
}
