package com.epam.training.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.Math.random;

public class WritingNumber implements Runnable {

    private List<Integer> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(Calculation.class);

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
            list.notify();
            int randomNumber = (int) (random() * 1000);
            list.add(randomNumber);
            LOGGER.info("random number=" + randomNumber);
            try {
               list.wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
