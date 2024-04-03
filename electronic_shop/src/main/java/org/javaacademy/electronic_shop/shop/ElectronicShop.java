package org.javaacademy.electronic_shop.shop;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.electronic_shop.shop.product.ElectronicGood;
import org.javaacademy.electronic_shop.shop.product.Phone;
import org.javaacademy.electronic_shop.shop.product.Tv;
import org.javaacademy.tax.TaxService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElectronicShop {

    private Map<Class<? extends ElectronicGood>, List<ElectronicGood>> goods = new HashMap<>();
    private final TaxService taxService;

    @PostConstruct
    public void init() {
        buy(Phone.class, 1);
        buy(Phone.class, 1);
        log.info(sell(Phone.class).toString());
        log.info(sell(Phone.class).toString());
    }

    public ElectronicGood sell(Class<? extends ElectronicGood> electronicClass) {
        if (goods.containsKey(electronicClass)) {
            List<ElectronicGood> electronicGoods = goods.get(electronicClass);
            if (electronicGoods.size() == 0) {
                throw new RuntimeException("Товара нет на складе");
            }
            ElectronicGood electronicGood = electronicGoods.remove(0);
            BigDecimal tax = taxService.calculateTax(new BigDecimal(electronicGood.getPrice()));
            taxService.payTax("MVIDEO", tax);
            return electronicGood;
        }
        throw new RuntimeException("Товаров такой категории нет на складе");
    }

    public void buy(Class<? extends ElectronicGood> electronicClass, Integer count) {
        List<ElectronicGood> categoryGoods = goods.getOrDefault(electronicClass, new ArrayList<>());
        if (electronicClass == Phone.class) {
            List<Phone> phones = Stream.generate(() -> new Phone(5_000)).limit(count).toList();
            categoryGoods.addAll(phones);
        } else if (electronicClass == Tv.class) {
            List<Tv> tvs = Stream.generate(() -> new Tv(10_000)).limit(count).toList();
            categoryGoods.addAll(tvs);
        }
        goods.put(electronicClass, categoryGoods);
    }

}
