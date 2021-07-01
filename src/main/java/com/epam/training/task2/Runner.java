package com.epam.training.task2;

public class Runner {

    public static void main(String[] args) {

    CalculationRunnable calculationRunnable=new CalculationRunnable();
    Thread thread=new Thread(calculationRunnable);
    thread.start();

    }
}
