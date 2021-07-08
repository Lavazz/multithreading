package com.epam.training.task5.operation;

import com.epam.training.task5.exception.LittleCashException;
import com.epam.training.task5.model.Currency;
import com.epam.training.task5.service.ExchangeServiceImpl;
import com.epam.training.task5.util.RateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangingOperation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    public static synchronized BigDecimal buyCurrency(BigDecimal money, Currency currency) {
        BigDecimal rate = RateData.getExchangeRate(currency);
        if (money.compareTo(rate) < 0) {
            LOGGER.error("Minimum sum of money should by mo than rate");
            throw new LittleCashException("Minimum sum of money should by mo than rate");
        }
        return money.divide(rate, 2, RoundingMode.HALF_UP);
    }

    public static synchronized BigDecimal sellCurrency(BigDecimal money, Currency currency) {
        BigDecimal rate = RateData.getExchangeRate(currency);
        if (money.compareTo(rate) < 0) {
            LOGGER.error("Minimum sum of money should by mo than rate");
            throw new LittleCashException("Minimum sum of money should by mo than rate");
        }

        return money.multiply(rate);
    }
}
