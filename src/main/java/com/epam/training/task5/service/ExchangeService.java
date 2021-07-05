package com.epam.training.task5.service;

import com.epam.training.task5.dao.AccountDao;
import com.epam.training.task5.model.Account;
import com.epam.training.task5.model.Currency;
import com.epam.training.task5.model.User;

import java.math.BigDecimal;

public class ExchangeService {

    private AccountDao accountDao;
    private User user;
    private Currency currency;
    private

    public ExchangeService(AccountDao accountDao, User user, Currency currency) {
        this.accountDao = accountDao;
        this.user = user;
        this.currency = currency;
    }


    public BigDecimal changeCurrency(BigDecimal money) {
        Account account = new Account(user, currency, money);
        accountDao.saveAccount(account);

        return null;

    }
}
