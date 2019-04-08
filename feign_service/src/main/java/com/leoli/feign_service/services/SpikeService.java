package com.leoli.feign_service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MY-LOCK")
public interface SpikeService {
    @GetMapping(value = "/api/get/spike/{id}")
    Object spike(@PathVariable("id") String id);
}
