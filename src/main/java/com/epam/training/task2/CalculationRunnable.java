package com.epam.training.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class CalculationRunnable implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationRunnable.class);
    public static final int POW = 2;
    List<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            writeList();
            sum();
            squareRoot();
        }
    }

    private void writeList() {
        int randomNumber = (int) (random() * 1000);
        list.add(randomNumber);

    }

    private synchronized int sum() {
        int sum = 0;
        for (int number : list) {
            sum += number;
            LOGGER.info("sum=" + sum);
        }
        return sum;
    }

    private synchronized int squareRoot() {
        int squareRoot = 0;
        int sum = 0;
        for (int number : list) {
            sum += Math.pow(number, POW);
        }
        squareRoot = (int) sqrt(sum);
        LOGGER.info("squareRoot=" + squareRoot);
        return squareRoot;
    }

}
