package com.expertus.demo.account.query;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExpertusAccountQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpertusAccountQueryApplication.class, args);
    }

}
