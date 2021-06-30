package com.epam.training.task1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

    public static void main(String[] args) {

        //  ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();   //  option 1

        //  Map<Integer, Integer> m = new HashMap<>();
        //  Map<Integer, Integer> map = Collections.synchronizedMap(m);            //  option 2

        Map<Integer, Integer> map = new HashMap<>();                              // option 3

        MapValueCounter counter = new MapValueCounter(map);
        MapPutting mapPutting = new MapPutting(map);
        MapManipulation manipulation = new MapManipulation(mapPutting, counter);
        manipulation.start();
    }

}
