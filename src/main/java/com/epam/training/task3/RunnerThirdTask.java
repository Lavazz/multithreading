package com.epam.training.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunnerThirdTask {
    public static void main(String[] args){

        LinkedList<String> buffer = new LinkedList<>();
        List<String> messages = new ArrayList<>();
        messages.add("Hello");
        messages.add("Yes");
        messages.add("No");


        Thread t1 = new Thread(new Producer(buffer, messages)) ;
        Thread t2 = new Thread(new Consumer(buffer));

        t1.start();
        t2.start();
    }
}
