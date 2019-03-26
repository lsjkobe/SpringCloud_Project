package com.leoli.oc_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OcLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcLogApplication.class, args);
    }

}
