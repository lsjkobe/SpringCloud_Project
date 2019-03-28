package com.leoli.stream_producer.controller;// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================

import com.leoli.stream_producer.services.SendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    SendLogService sendLogService;

    @GetMapping("/send/message/{msg}")
    public Object sendLog(@PathVariable("msg") String msg){
        sendLogService.send(msg);
        return "";
    }

    @GetMapping("/send/message2/{msg}")
    public Object sendLog2(@PathVariable("msg") String msg){
        sendLogService.send(msg);
        return "";
    }
}
