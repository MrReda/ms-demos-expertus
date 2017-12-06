package com.expertus.demo.eureka.server;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
//@EnableEurekaServer
public class ExpertusEurekaServerApplication {

    public static void main(String[] args){
        SpringApplication.run(ExpertusEurekaServerApplication.class,args);
    }

}
