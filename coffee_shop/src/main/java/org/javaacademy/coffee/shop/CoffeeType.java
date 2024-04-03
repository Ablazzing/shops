package org.javaacademy.coffee.shop;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum CoffeeType {
    LATTE(200, "Латте"),
    CAPPUCCINO(150, "Капучино"),
    AMERICANO(70, "Американо");

    Integer price;
    String name;
}
