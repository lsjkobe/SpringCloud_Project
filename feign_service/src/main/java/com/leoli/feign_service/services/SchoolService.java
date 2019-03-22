package com.leoli.feign_service.services;

import com.leoli.feign_service.fallback.HystrixFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "OLD-CLASSMATE", fallback = HystrixFallback.class )
@Service
public interface SchoolService {
    @GetMapping(value = "/api/v1/get/schoolfellow/{id}")
//    @Headers({"Authorization: bear 123456"})
//    @RequestLine("GET /api/v1/get/schoolfellow/{id}")
    Object getInfo(@PathVariable("id") String id);

    @PostMapping(value = "/api/v1/upload/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object fileUpload(@RequestPart("file") MultipartFile file);

}
