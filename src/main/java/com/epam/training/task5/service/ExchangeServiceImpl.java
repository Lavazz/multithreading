package com.epam.training.task5.service;

import com.epam.training.task5.dao.ExchangeDao;
import com.epam.training.task5.dao.ExchangeDaoImpl;
import com.epam.training.task5.model.Account;
import com.epam.training.task5.model.Currency;
import com.epam.training.task5.model.User;
import com.epam.training.task5.operation.ExchangingOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeDao exchangeDao;
    private final User user;
    private final Currency currency;
    private final BigDecimal money;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    public ExchangeServiceImpl(User user, Currency currency, BigDecimal money, String path) {
        exchangeDao = new ExchangeDaoImpl(path);
        this.user = user;
        this.currency = currency;
        this.money = money;

    }

    @Override
    public String call() {
        boolean canBuy = ThreadLocalRandom.current().nextBoolean();
        BigDecimal exchangeMoney;
        if (canBuy) {
            exchangeMoney = ExchangingOperation.buyCurrency(money, currency);
            LOGGER.info("{} buy {} {}", user.getFirstName(), exchangeMoney, currency);
        } else {
            exchangeMoney = ExchangingOperation.sellCurrency(money, currency);
            LOGGER.info("{} sell {} {}", user.getFirstName(), money, currency);
        }
        Account account = new Account(user, currency, exchangeMoney);
        exchangeDao.saveAccount(account);

        return exchangeMoney.toString();
    }
}
