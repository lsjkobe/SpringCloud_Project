package com.leoli.stream_producer.services;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import com.leoli.stream_producer.stream.messaging.SendLog;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@EnableBinding(SendLog.class)
public class SendLogService {

    @Autowired
    SendLog sendLog;

    public void send(String msg){
        Map<String, Object> logInfo = new HashMap<>();
        logInfo.put("level", Level.DEBUG.name());
        logInfo.put("info", msg);
        this.sendLog.output().send(MessageBuilder.withPayload(logInfo).setHeader("version","1.0").build());
        this.sendLog.output().send(MessageBuilder.withPayload(logInfo).setHeader("version","2.0").build());
    }
}
