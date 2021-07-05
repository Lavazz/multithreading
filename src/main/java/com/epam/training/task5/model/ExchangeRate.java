package com.epam.training.task5.model;

import java.math.BigDecimal;

public class ExchangeRate {

    private Currency currency;
    private BigDecimal rate;

    public ExchangeRate() {
    }

    public ExchangeRate(Currency currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
