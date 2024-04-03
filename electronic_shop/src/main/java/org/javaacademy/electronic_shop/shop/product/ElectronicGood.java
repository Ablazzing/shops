package org.javaacademy.electronic_shop.shop.product;


import lombok.Data;
import lombok.NonNull;

@Data
public abstract class ElectronicGood {
    @NonNull
    private String name;
    @NonNull
    public Integer price;
}
