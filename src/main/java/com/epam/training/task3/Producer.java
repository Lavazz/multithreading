package com.epam.training.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Producer implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    public static final String STOP_WORD = "DONE";
    private final LinkedList<String> buffer;
    private final List<String> messages;

    public Producer(LinkedList<String> buffer, List<String> messages) {
        this.buffer = buffer;
        this.messages = messages;
    }

    @Override
    public void run() {
        for (String message : messages) {
            produce(message);
        }
        buffer.add(STOP_WORD);
    }

    private synchronized void produce(String message) {
        while (!buffer.isEmpty()) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                LOGGER.error("interrupt");
            }
        }

        buffer.add(message);
        LOGGER.info("Producer produced-" + message);

        notify();
    }

}


