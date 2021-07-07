package com.epam.training.task5;

import com.epam.training.task5.model.Currency;
import com.epam.training.task5.model.User;
import com.epam.training.task5.service.ExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        String path = "src/main/resources/ExchangeData.txt";

        User userAnna = new User("Anna", "Petrova");
        User userArtem = new User("Artem", "Ivanov");
        User userVitaly = new User("Vitaly", "Balnikov");

        BigDecimal moneyAnna = new BigDecimal("20");
        BigDecimal moneyArtem = new BigDecimal("1");
        BigDecimal moneyVitaly = new BigDecimal("100");

        ExchangeService exchangeService1 = new ExchangeService(userAnna, Currency.EUR, moneyAnna, path);
        ExchangeService exchangeService2 = new ExchangeService(userArtem, Currency.USD, moneyArtem, path);
        ExchangeService exchangeService3 = new ExchangeService(userVitaly, Currency.RUB, moneyVitaly, path);


        List<ExchangeService> exchangers = new ArrayList<>();
        exchangers.add(exchangeService1);
        exchangers.add(exchangeService2);
        exchangers.add(exchangeService3);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            executor.invokeAll(exchangers);
        } catch (InterruptedException e) {
            LOGGER.error("is interrupt");
        }
        executor.shutdown();
    }
}
