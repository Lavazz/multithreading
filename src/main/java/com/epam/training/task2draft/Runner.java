package com.epam.training.task2draft;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        WritingNumber writingNumber = new WritingNumber(list);
        CalculationSquareRoot squareRoot = new CalculationSquareRoot(list);
        Summing summing = new Summing(list);

        Thread writingThread = new Thread(writingNumber);
        Thread summingThread = new Thread(summing);
        Thread squareRootThread = new Thread(squareRoot);
        writingThread.start();
        summingThread.start();
        squareRootThread.start();

    }
}
