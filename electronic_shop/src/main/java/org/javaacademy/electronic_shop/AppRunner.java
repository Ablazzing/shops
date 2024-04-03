package org.javaacademy.electronic_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);

    }
}
