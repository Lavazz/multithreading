package com.epam.training.task5.operation;

import com.epam.training.task5.model.Currency;
import com.epam.training.task5.service.RateService;

import java.math.BigDecimal;

public class ExchangingOperation {

    public BigDecimal exchange(BigDecimal money, Currency currency){
      BigDecimal  rate= RateService.valueOf(currency.toString());
        return money.multiply(rate);
    }
}
