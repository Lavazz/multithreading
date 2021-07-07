package com.epam.training.task5.operation;

import com.epam.training.task5.exception.LittleCashException;
import com.epam.training.task5.model.Currency;
import com.epam.training.task5.service.ExchangeService;
import com.epam.training.task5.service.RateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangingOperation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeService.class);

    public static BigDecimal sellCurrency(BigDecimal money, Currency currency) {
        BigDecimal rate = RateService.getExchangeRate(currency);
        if (money.compareTo(rate) < 0) {
            LOGGER.error("Minimum sum of money should by mo than rate");
            throw new LittleCashException("Minimum sum of money should by mo than rate");
        }
        return money.divide(rate, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal buyCurrency(BigDecimal money, Currency currency) {
        BigDecimal rateService = RateService.getExchangeRate(currency);
        BigDecimal rate = new BigDecimal(rateService.toString());
        return money.multiply(rate);
    }
}
