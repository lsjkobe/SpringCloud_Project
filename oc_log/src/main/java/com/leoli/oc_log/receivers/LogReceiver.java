package com.leoli.oc_log.receivers;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import com.leoli.oc_log.configuration.PropertyConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class LogReceiver {
    private Logger LOGGER = LogManager.getLogger(LogReceiver.class);

    @Autowired
    PropertyConfiguration property;

    @RabbitListener(queues = "ocLog")
    public void process(String log) throws Exception {
        this.log(null, log);
//        throw new Exception("123");
    }

    @RabbitListener(queues = "ocLog1" , containerFactory = "multiListenerContainer")
    public void receiveLog(ConcurrentHashMap log){
        String level = (String) log.get("logLevel");
        String msg = (String) log.get("logMsg");
        this.log(level, msg);
    }

    @RabbitListener(queues = "ocTopicLogQueue", containerFactory = "multiListenerContainer")
    public void receiveTocipLog(ConcurrentHashMap log) throws Exception {

        String level = (String) log.get("logLevel");
        String msg = (String) log.get("logMsg");
        this.log(level, msg);
    }

    private void log(String level, String msg){
        LOGGER.log(Level.toLevel(level), msg);
    }
}
