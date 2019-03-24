package com.leoli.serviceribbon.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Info {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public Object getInfor(String id, HttpHeaders headers){

        HttpEntity httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity responseEntity = this.restTemplate.exchange("http://OLD-CLASSMATE/api/v1/get/schoolfellow/"+id, HttpMethod.GET, httpEntity, Object.class);
        return responseEntity.getBody();
    }

    public String helloFallback(String id, HttpHeaders headers) {
        return "error";
    }

}
