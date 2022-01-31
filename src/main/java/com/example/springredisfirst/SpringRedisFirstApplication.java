package com.example.springredisfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
@DependsOn("jedisConnectionFactory")
public class SpringRedisFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisFirstApplication.class, args);
    }

}
