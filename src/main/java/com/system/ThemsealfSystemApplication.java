package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.system.mapper")
@SpringBootApplication
public class ThemsealfSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemsealfSystemApplication.class, args);
    }

}
