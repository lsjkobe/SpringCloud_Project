package com.leoli.oc_stream_log.stream.messaging;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiveLog {
    /**
     * Input channel name.
     */
    String INPUT = "logInput";

    /**
     * @return input channel.
     */
    @Input(ReceiveLog.INPUT)
    SubscribableChannel input();
}
