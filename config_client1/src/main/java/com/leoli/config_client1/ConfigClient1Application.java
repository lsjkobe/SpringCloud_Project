package com.leoli.config_client1;

import com.leoli.config_client1.configuration.OCConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient1Application.class, args);
    }

    @Autowired
    OCConfig ocConfig;


    @RequestMapping(value = "/info")
    public String hi() {
        return ocConfig.getUsername()+":"+ocConfig.getPassword();
    }
}
