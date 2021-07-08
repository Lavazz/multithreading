package com.epam.training.task2;

import java.util.List;

import static java.lang.Math.sqrt;

public class Calculation {

    public static final int POW = 2;
    private final List<Integer> list;

    public Calculation(List<Integer> list) {
        this.list = list;
    }

    protected int sum() {
        synchronized (list) {
            int sum = 0;
            for (int number : list) {
                sum += number;
            }
            return sum;
        }
    }

    protected int calculateSquareRoot() {
        synchronized (list) {
            int squareRoot;
            int sum = 0;
            for (int number : list) {
                sum += Math.pow(number, POW);
            }
            squareRoot = (int) sqrt(sum);
            return squareRoot;
        }
    }
}
