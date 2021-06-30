package com.epam.training.task1;

import java.util.Map;

public class MapPutting {

    Map<Integer, Integer> map;
    private static int count = 0;

    protected MapPutting(Map<Integer, Integer> map) {
        this.map = map;
    }

    public synchronized void putToMap(int key, int value) {
        map.put(key, value);
    }
}


