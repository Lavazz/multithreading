package com.epam.training.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Printing implements Runnable {

    private List<Integer> list;
    private String operation;
    private Calculation calculation;
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
            if (operation.equalsIgnoreCase("sum")) {
                LOGGER.info("sum=" + calculation.sum());
            } else if (operation.equalsIgnoreCase("squareRoot")) {
                LOGGER.info("squareRoot=" + calculation.calculateSquareRoot());
            } else {
                LOGGER.info("result=-1");
            }
            try {
                list.wait();
            } catch (InterruptedException e) {
            }
        }
    }

}
