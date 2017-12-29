package com.expertus.demo.account.query.configuration;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.expertus.demo.account.query.configuration")
public class ZipkinConfiguration {

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
