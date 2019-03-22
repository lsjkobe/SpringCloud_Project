package com.leoli.feign_service.controller;


import com.leoli.feign_service.services.SchoolService;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @GetMapping("/api/v1/get/schoolfellow/{id}")
    public Object getInfo(@PathVariable String id){
        return schoolService.getInfo(id);
    }
}
