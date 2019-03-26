package com.leoli.rabbitmqservice.controller;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/send/sample/{msg}")
    public Object sendSample(@PathVariable("msg") String msg) {
        return rabbitTemplate.convertSendAndReceive("ocExchange","log", msg);
    }
//
//    @GetMapping(value = "/send/sample/{msg}")
//    public Object sendTest(@PathVariable("msg") String msg) {
//        return rabbitTemplate..convertSendAndReceive("oclog", msg);
//    }
}
