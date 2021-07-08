package com.epam.training.task5.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRate {

    private Currency currency;
    private BigDecimal rate;

}
