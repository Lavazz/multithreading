package com.epam.training.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MapPutting implements Runnable {

    public int threadQuantity;
    private final Map<Integer, Integer> map;
    private static final Logger LOGGER = LoggerFactory.getLogger(MapPutting.class);

    protected MapPutting(Map<Integer, Integer> map, int threadQuantity) {
        this.map = map;
        this.threadQuantity = threadQuantity;
    }


    @Override
    public void run() {
        for (int i = 0; i < threadQuantity; i++) {
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
                LOGGER.error("interrupt");
            }

            if (map.size() == threadQuantity) {
                Thread.currentThread().interrupt();
            }

        }
    }

}