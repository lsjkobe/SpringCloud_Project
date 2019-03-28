package com.leoli.oc_stream_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OcStreamLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcStreamLogApplication.class, args);
    }

}
