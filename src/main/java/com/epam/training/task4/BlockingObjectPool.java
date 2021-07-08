package com.epam.training.task4;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingObjectPool {

    private final List<Object> pool;

    private final Lock readLock;
    private final Lock writeLock;

    public BlockingObjectPool(int size) {
        pool = new ArrayList<>(size);

        ReadWriteLock lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    public Object get() {
        readLock.lock();
        Object result = null;
        try {
            if (CollectionUtils.isNotEmpty(pool)) {
                int index = pool.size() - 1;
                result = pool.get(index);
                pool.remove(index);
            }
        } finally {
            if (!CollectionUtils.isFull(pool)) {
                writeLock.unlock();
            }
            if (CollectionUtils.isNotEmpty(pool)) {
                readLock.unlock();
            }
        }
        return result;
    }

    public void take(Object object) {
        writeLock.lock();
        try {
            if (!CollectionUtils.isFull(pool)) {
                pool.add(object);
            }
        } finally {
            if (!CollectionUtils.isFull(pool)) {
                writeLock.unlock();
            }
            if (CollectionUtils.isNotEmpty(pool)) {
                readLock.unlock();
            }
        }
    }

}