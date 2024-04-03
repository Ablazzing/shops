package org.javaacademy.coffee.shop;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.tax.TaxService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoffeeShop {
    private static final Integer ONE_CUP_COFFEE_GRAMS = 30;
    private static final Integer BUY_SIZE = 10_000;
    private static final String COFFEE_SHOP_NAME = "Y YIRY";
    private Integer coffeeWeightGrams = 0;
    private final TaxService taxService;

    @PostConstruct
    public void init() {
        buyCoffee();
        log.info(sellCoffee(CoffeeType.CAPPUCCINO).toString());
        log.info(sellCoffee(CoffeeType.CAPPUCCINO).toString());
    }

    public Coffee sellCoffee(CoffeeType order) {
        if (coffeeWeightGrams < ONE_CUP_COFFEE_GRAMS) {
            throw new RuntimeException("Нету кофе на складе!");
        }
        BigDecimal taxCount = taxService.calculateTax(new BigDecimal(order.getPrice()));
        taxService.payTax(COFFEE_SHOP_NAME, taxCount);
        coffeeWeightGrams -= ONE_CUP_COFFEE_GRAMS;
        return new Coffee(order);
    }

    public void buyCoffee() {
        coffeeWeightGrams += BUY_SIZE;
    }
}
