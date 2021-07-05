package com.epam.training.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Printing implements Runnable {

    public static final String SUM = "sum";
    public static final String SQUARE_ROOT = "squareRoot";
    public static final String UNKNOWEN_OPERATION = "result=-1";
    private final List<Integer> list;
    private final String operation;
    private final Calculation calculation;
    private static final Logger LOGGER = LoggerFactory.getLogger(Printing.class);

    public Printing(List<Integer> list, String operation, Calculation calculation) {
        this.list = list;
        this.operation = operation;
        this.calculation = calculation;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            print(operation);
        }
    }

    private void print(String operation) {
        synchronized (list) {
            list.notify();
            if (operation.equalsIgnoreCase(SUM)) {
                LOGGER.info("sum=" + calculation.sum());
            } else if (operation.equalsIgnoreCase(SQUARE_ROOT)) {
                LOGGER.info("squareRoot=" + calculation.calculateSquareRoot());
            } else {
                LOGGER.info(UNKNOWEN_OPERATION);
            }
            try {
                list.wait();
            } catch (InterruptedException e) {
                LOGGER.error("interrupt");
            }
        }
    }

}
