package com.epam.training.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MapValueCounter implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapValueCounter.class);
    private Map<Integer, Integer> map;
    List<Integer> sumList = Collections.synchronizedList(new ArrayList<>());

    protected MapValueCounter(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            mapSum();
        }
    }

    private void mapSum() {
        synchronized (map) {
            //    if (map.size() > sumList.size()+1) {
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
            }
            //  }
        }
    }
}

