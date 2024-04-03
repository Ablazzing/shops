package org.javaacademy.tax;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.javaacademy.tax")
public class TaxConfig {

    @PostConstruct
    public void init() {
        System.out.println("___________________________________________");
        System.out.println("КОНФИГ ПОДНЯЛИ");
        System.out.println("___________________________________________");
    }
}
