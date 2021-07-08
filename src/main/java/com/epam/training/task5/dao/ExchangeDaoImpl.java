package com.epam.training.task5.dao;

import com.epam.training.task5.model.Account;
import com.epam.training.task5.service.ExchangeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ExchangeDaoImpl implements ExchangeDao {
    private final String path;
    private static final String partOfContent = "%n User: %s %s  change: %s to: %s";
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeServiceImpl.class);


    public ExchangeDaoImpl(String path) {
        this.path = path;
    }

    public void saveAccount(Account account) {

        String content =  String.format(partOfContent, account.getUser().getFirstName(), account.getUser().getLastName(), account.getMoney().toString(), account.getCurrency());

        try {
        Files.write(
                Paths.get(path),
                content.getBytes(),
                CREATE, APPEND);
        } catch (IOException e) {
           LOGGER.error("operation of {} doesn't save", account.getUser());
        }

    }
}
