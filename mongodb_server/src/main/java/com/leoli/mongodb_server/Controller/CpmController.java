package com.leoli.mongodb_server.Controller;

import com.leoli.mongodb_server.Service.CpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CpmController {

    @Autowired
    CpmService cpmService;

    @GetMapping("/api/save")
    public Object save(){
        cpmService.save();
        return "";
    }
}
