package org.javaacademy.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
//        CoffeeShop coffeeShop = context.getBean(CoffeeShop.class);
//        coffeeShop.sellCoffee();
    }
}
