package com.epam.training.task1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

    public static void main(String[] args) {

        //   ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();   //  option 1

        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());            //  option 2

        //   Map<Integer, Integer> map = new HashMap<>();                              // option 3

        MapPutting mapPutting = new MapPutting(map);
        MapValueCounter counter = new MapValueCounter(map);

        Thread puttingThread = new Thread(mapPutting);
        Thread sumThread = new Thread(counter);
        puttingThread.start();
        sumThread.start();

    }

}
