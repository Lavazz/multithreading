package com.epam.training.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MapValueCounter implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapValueCounter.class);
    private final int threadQuantity;
    private final Map<Integer, Integer> map;
    List<Integer> sumList = Collections.synchronizedList(new ArrayList<>());

    protected MapValueCounter(Map<Integer, Integer> map, int threadQuantity) {
        this.map = map;
        this.threadQuantity = threadQuantity;
    }

    @Override
    public void run() {
        for (int i = 0; i < threadQuantity; i++) {
            mapSum();
        }
    }

    private void mapSum() {
        synchronized (map) {

            map.notify();

            int sum = map.values()
                    .stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
            sumList.add(sum);
            LOGGER.info("sum=" + sum);

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