package com.leoli.stream_producer.stream.messaging;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SendLog {

    /**
     * Name of the output channel.
     */
    String OUTPUT = "logOutput";

    /**
     * @return output channel
     */
    @Output(SendLog.OUTPUT)
    MessageChannel output();

}
