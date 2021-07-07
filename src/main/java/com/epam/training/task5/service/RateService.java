package com.epam.training.task5.service;

import com.epam.training.task5.model.Currency;

import java.math.BigDecimal;

public class RateService {

    public static BigDecimal getExchangeRate(Currency currency) {
        switch (currency) {
            case EUR:
                return new BigDecimal("3.2");
            case USD:
                return new BigDecimal("2.6");
            case RUB:
                return new BigDecimal("0.034");
            default:
                return new BigDecimal("-1");
        }
    }

}
