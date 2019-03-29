package com.leoli.oc_stream_log.receiver;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import com.leoli.oc_stream_log.stream.messaging.ReceiveLog;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(value = ReceiveLog.class)
public class LogReceiver2 {
    @StreamListener(value = ReceiveLog.INPUT, condition = "headers['version']=='1.0'")
    public void input(Message message, @Header("version") String version){
        System.err.println("消息接收1:" + message.getPayload()+version);
    }

    @StreamListener(value = ReceiveLog.INPUT, condition = "headers['version']=='2.0'")
    public void input2(Message message, @Header("version") String version){
        System.err.println("消息接收2:" + message.getPayload()+version);
    }
}
