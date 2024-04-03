package org.javaacademy.electronic_shop.shop.product;

import lombok.NonNull;

public class Tv extends ElectronicGood {
    public Tv(@NonNull Integer price) {
        super("LG", price);
    }
}
