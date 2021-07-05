package com.epam.training.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class Consumer implements Runnable {

    public static final String STOP_WORD = "DONE";
    private final LinkedList<String> buffer;
    boolean flag = true;
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    public Consumer(LinkedList<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        consume();
    }

    public synchronized void consume() {
        while (flag) {
            while (buffer.isEmpty()) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    LOGGER.error("interrupt");
                }
            }

            String message = buffer.removeFirst();
            if (message.equals(STOP_WORD)) {
                flag = false;
            }
            LOGGER.info("Consumer consumed-" + message);
            notifyAll();
        }
    }
}
