package com.epam.training.task2;

import java.util.ArrayList;
import java.util.List;

public class Runner2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        WritingNumber writingNumber = new WritingNumber(list);
        Calculation calculation = new Calculation(list);
        Printing summing = new Printing(list, "sum", calculation);
        Printing squareRoot = new Printing(list, "squareRoot", calculation);

        Thread writingThread = new Thread(writingNumber);
        Thread summingThread = new Thread(summing);
        Thread squareRootThread = new Thread(squareRoot);
        writingThread.start();
        summingThread.start();
        squareRootThread.start();

    }
}
