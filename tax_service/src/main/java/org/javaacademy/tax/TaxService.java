package org.javaacademy.tax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TaxService {
    @Value("${tax.name}")
    private String name;
    private Map<String, BigDecimal> taxByCompanies = new HashMap<>();
    public static final BigDecimal TAX_FARE = new BigDecimal("0.2");


    public void payTax(String companyName, BigDecimal taxCount) {
        BigDecimal taxesBefore = taxByCompanies.getOrDefault(companyName, BigDecimal.ZERO);
        taxByCompanies.put(companyName, taxesBefore.add(taxCount));
        log.info("Уплочено в такую то налоговую {} такими компаниями {}", name, taxByCompanies);
    }

    public BigDecimal calculateTax(BigDecimal income) {
        return TaxService.TAX_FARE.multiply(income);
    }
}
