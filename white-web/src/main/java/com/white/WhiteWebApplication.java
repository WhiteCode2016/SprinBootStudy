package com.white;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class WhiteWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhiteWebApplication.class, args);
    }

}
