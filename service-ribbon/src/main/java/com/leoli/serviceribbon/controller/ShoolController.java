package com.leoli.serviceribbon.controller;

import com.leoli.serviceribbon.services.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ShoolController {

    @Autowired
    Info info;

    @GetMapping("/api/v1/get/schoolfellow/{id}")
    @ResponseBody
    public Object getInfo(@PathVariable String id, HttpServletRequest request){
        String auth = request.getHeader("authorization");
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authorization", auth);
        return info.getInfor(id, requestHeaders);
    }
}
