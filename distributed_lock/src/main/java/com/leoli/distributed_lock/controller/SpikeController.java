package com.leoli.distributed_lock.controller;

import com.leoli.distributed_lock.services.SpikeService;
import com.leoli.distributed_lock.utils.concurrent.ConcurrentTestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpikeController {

    @Autowired
    SpikeService spikeService;

    @GetMapping("/api/get/spike/{id}")
    public Object spike(@PathVariable("id") String id){
        ConcurrentTestUtil.test(id, s-> spikeService.spike(id), 500);
//        spikeService.spike(id);
        return true;
    }
}
