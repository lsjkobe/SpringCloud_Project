package com.leoli.feign_service.fallback;

import com.leoli.feign_service.services.SchoolService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HystrixFallback implements SchoolService {
    @Override
    public Object getInfo(String id) {
        return "sorry";
    }

    @Override
    public Object fileUpload(MultipartFile file) {
        return "";
    }
}
