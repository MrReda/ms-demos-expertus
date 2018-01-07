package com.expertus.demo.customer.query.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.expertus.demo.customer.query"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "EXPERTUS ACCOUNT REST API",
                "This is the new api for Expertus",
                "API account V1",
                "Terms of services",
                new Contact("MrReda", "https://github.com/MrReda/ms-demos-expertus", "bencheikh.mohamed.reda@gmail.com"),
                "License of API", "API license Apache 2.0");
    }

}
