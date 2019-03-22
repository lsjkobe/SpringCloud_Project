package com.leoli.feign_service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(serviceId = "test")
public interface FileService {
    @PostMapping(value = "/api/v1/upload/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object fileUpload(@RequestParam("file") MultipartFile file);
}
