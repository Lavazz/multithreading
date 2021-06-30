package com.epam.training.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapManipulation extends Thread {

    private final MapPutting putting;
    private final MapValueCounter counter;
    private static final Logger LOGGER = LoggerFactory.getLogger(MapManipulation.class);

    protected MapManipulation(MapPutting putting, MapValueCounter counter) {
        this.putting = putting;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            putting.putToMap(i, i);
            counter.mapSum();
        }
        LOGGER.info("List=" + counter.getList());
    }
}
