package com.epam.training.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MapPutting implements Runnable {

    private Map<Integer, Integer> map;
    private static final Logger LOGGER = LoggerFactory.getLogger(MapPutting.class);

    protected MapPutting(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            putToMap(i, i);
            LOGGER.info("i=" + i);
        }

    }

    private void putToMap(int key, int value) {
        synchronized (map) {
            map.notify();
            map.put(key, value);
            try {
                map.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


