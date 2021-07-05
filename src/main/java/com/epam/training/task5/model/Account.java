package com.epam.training.task5.model;

import java.math.BigDecimal;

public class Account {

    private int accountIdentifier;
    private User user;
    private Currency currency;
    private BigDecimal money;

    public Account() {
    }

    public Account(User user, Currency currency, BigDecimal money) {
        this.user = user;
        this.currency = currency;
        this.money = money;
    }

    public int getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(int accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
