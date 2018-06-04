package com.white;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/1
 */
@SpringBootApplication
@EnableTransactionManagement
public class WhiteImplApplication {
    public static void main(String[] args) {
        SpringApplication.run(WhiteImplApplication.class, args);
    }
}
