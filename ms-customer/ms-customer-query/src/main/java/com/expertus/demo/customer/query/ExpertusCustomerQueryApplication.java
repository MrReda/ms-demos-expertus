package com.expertus.demo.customer.query;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExpertusCustomerQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpertusCustomerQueryApplication.class, args);
    }
}
