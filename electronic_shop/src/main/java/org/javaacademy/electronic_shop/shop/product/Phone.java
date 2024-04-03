package org.javaacademy.electronic_shop.shop.product;

import lombok.NonNull;

public class Phone extends ElectronicGood {
    public Phone(@NonNull Integer price) {
        super("Motorola", price);
    }
}
