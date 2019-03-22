package com.leoli.serviceribbon.services;

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

    public Object getInfor(String id, HttpHeaders headers){

        HttpEntity httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity responseEntity = this.restTemplate.exchange("http://OLD-CLASSMATE/api/v1/get/schoolfellow/"+id, HttpMethod.GET, httpEntity, Object.class);
        return responseEntity.getBody();
    }

}
