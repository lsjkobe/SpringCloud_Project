package com.leoli.feign_service.controller;

import com.leoli.feign_service.services.SpikeService;
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
        return spikeService.spike(id);
    }
}
