package com.epam.training.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingObjectPool {

    private final int size;
    private final List<Object> pool;

    private final Lock readLock;
    private final Lock writeLock;

    public BlockingObjectPool(int size) {
        this.size = size;
        pool = new ArrayList<>(size);

        ReadWriteLock lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    public Object get() {
        readLock.lock();
        Object result = null;
        try {
            if (!pool.isEmpty()) {
                int index = pool.size() - 1;
                result = pool.get(index);
                pool.remove(index);
            }
        } finally {
            if (pool.size() < size) {
                writeLock.unlock();
            }
            if (!pool.isEmpty()) {
                readLock.unlock();
            }
        }
        return result;
    }

    public void take(Object object) {
        writeLock.lock();
        try {
            if (pool.size() < size) {
                pool.add(object);
            }
        } finally {
            if (pool.size() < size) {
                writeLock.unlock();
            }
            if (!pool.isEmpty()) {
                readLock.unlock();
            }
        }
    }

}