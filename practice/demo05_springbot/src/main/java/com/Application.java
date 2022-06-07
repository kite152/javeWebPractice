package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //将该类标注为springboot启动类
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
