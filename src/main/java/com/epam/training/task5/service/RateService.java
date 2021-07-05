package com.epam.training.task5.service;

import java.math.BigDecimal;

public enum RateService {

    EUR(3.2),
    USD(2.6),
    BYN(1);

    private BigDecimal rate;

    RateService(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate(){
        return rate;
    }


}
