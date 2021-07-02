package com.epam.training.task2draft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.Math.random;

public class WritingNumber implements Runnable {

    private List<Integer> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationSquareRoot.class);

    public WritingNumber(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            writeList();
        }
        System.out.println(list);
    }

    private void writeList() {
        synchronized (list) {
            int randomNumber = (int) (random() * 1000);
            list.add(randomNumber);
            LOGGER.info("random=" + randomNumber);
        }
    }
}
