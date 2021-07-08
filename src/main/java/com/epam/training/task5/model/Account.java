package com.epam.training.task5.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private int accountIdentifier;
    private User user;
    private Currency currency;
    private BigDecimal money;


    public Account(User user, Currency currency, BigDecimal money) {
        this.user = user;
        this.currency = currency;
        this.money = money;
    }

}
