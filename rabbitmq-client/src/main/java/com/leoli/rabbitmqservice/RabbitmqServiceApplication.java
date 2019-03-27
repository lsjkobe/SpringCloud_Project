package com.leoli.rabbitmqservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitmqServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceApplication.class, args);
    }

}
