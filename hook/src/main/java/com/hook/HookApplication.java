package com.hook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = "com.hook.Mappers")
@EnableScheduling
public class HookApplication {

    public static void main(String[] args) {
        SpringApplication.run(HookApplication.class, args);
    }

}
