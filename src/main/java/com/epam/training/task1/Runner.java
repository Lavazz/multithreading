package com.epam.training.task1;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        MapValueCounter counter = new MapValueCounter(map);
        MapPutting mapPutting = new MapPutting(map);
        MapManipulation manipulation = new MapManipulation(mapPutting, counter);
        manipulation.start();
    }

}
