package com.epam.training.task1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Runner1 {

    public static void main(String[] args) {

      int threadQuantity=20;

        //   ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();   //  option 1

        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());            //  option 2

        //   Map<Integer, Integer> map = new HashMap<>();                              // option 3

        MapPutting mapPutting = new MapPutting(map, threadQuantity );
        MapValueCounter counter = new MapValueCounter(map, threadQuantity );

        Thread puttingThread = new Thread(mapPutting);
        Thread sumThread = new Thread(counter);
        puttingThread.start();
        sumThread.start();

    }

}
