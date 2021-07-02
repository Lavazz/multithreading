package com.epam.training.task2draft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.Math.sqrt;

public class CalculationSquareRoot implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationSquareRoot.class);
    public static final int POW = 2;
    private List<Integer> list;

    public CalculationSquareRoot(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            squareRoot();
        }

    }


    private void squareRoot() {
        synchronized (list) {
            int squareRoot;
            int sum = 0;
            for (int number : list) {
                sum += Math.pow(number, POW);
            }
            squareRoot = (int) sqrt(sum);
            LOGGER.info("squareRoot=" + squareRoot);
        }
    }
}
