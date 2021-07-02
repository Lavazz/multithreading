package com.epam.training.task2draft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Summing  implements Runnable {

    private List<Integer> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(Summing.class);

    public Summing(List<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        sum();
    }

    private int sum() {
        synchronized (list) {
            int sum = 0;
            for (int number : list) {
                sum += number;
                LOGGER.info("sum=" + sum);
            }
            return sum;
        }
    }
}
