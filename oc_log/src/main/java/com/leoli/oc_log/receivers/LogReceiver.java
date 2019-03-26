package com.leoli.oc_log.receivers;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import com.leoli.oc_log.configuration.PropertyConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogReceiver {

    @Autowired
    PropertyConfiguration property;

    @RabbitListener(queues = "{property.getQueue()}")
    public void process(String log){
        System.out.println("Receiver:" + log+":"+property.getExchange()+":"+property.getKey()+":"+property.getQueue());
    }
}
