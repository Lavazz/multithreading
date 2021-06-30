package com.epam.training.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapValueCounter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapValueCounter.class);
    Map<Integer, Integer> map;
    List<Integer> sumList = new ArrayList<>();

    protected MapValueCounter(Map<Integer, Integer> map) {
        this.map = map;
    }


    public synchronized void mapSum() {
        int sum = map.values()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
        sumList.add(sum);
        LOGGER.info("sum=" + sum);
    }

    public List<Integer> getList() {
        return sumList;
    }
}
