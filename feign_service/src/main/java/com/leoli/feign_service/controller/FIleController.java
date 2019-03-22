package com.leoli.feign_service.controller;

import com.leoli.feign_service.services.FileService;
import com.leoli.feign_service.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FIleController {
    @Autowired
    SchoolService schoolService;

    @PostMapping(value = "/api/v1/upload/file")
    public Object fileUpload(@RequestPart("file") MultipartFile file){
        Object o = schoolService.fileUpload(file);
        return o;
    }

}
