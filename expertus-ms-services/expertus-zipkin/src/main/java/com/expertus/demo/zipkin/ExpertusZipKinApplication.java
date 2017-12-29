package com.expertus.demo.zipkin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ExpertusZipKinApplication {

            public static void main(String[] args){
                SpringApplication.run(ExpertusZipKinApplication.class,args);
            }

}
