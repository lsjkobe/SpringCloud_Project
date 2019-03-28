package com.leoli.stream_producer.services;

import com.leoli.stream_producer.StreamProducerApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
// Copyright (c) 1998-2019 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2019-XX-XX, leo.li, creation
// ============================================================================


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamProducerApplication.class)
@Transactional
@Rollback
public class SendLogServiceTest {
//
//    @Autowired
//    SendLogService sendLogService;

//    @Test
//    public void send(){
//        this.sendLogService.send("nihaoya");
//    }
}