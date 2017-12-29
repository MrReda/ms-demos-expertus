package com.expertus.demo.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ExpertusGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpertusGatewayApplication.class, args);
    }


    @Bean
    public AlwaysSampler defaultSampler(){return new AlwaysSampler();}
}
