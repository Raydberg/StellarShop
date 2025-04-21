package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MsvcGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MsvcGatewayApplication.class)
				//Indicar que use el aplication.yml
                .properties("spring.config.name=application")
                .run(args);
    }
}