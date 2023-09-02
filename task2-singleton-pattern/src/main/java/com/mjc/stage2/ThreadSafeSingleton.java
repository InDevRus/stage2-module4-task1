package com.mjc.stage2;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings({"unused", "InstantiationOfUtilityClass"})
public class ThreadSafeSingleton {
    private static AtomicReference<ThreadSafeSingleton> instance = new AtomicReference<>(new ThreadSafeSingleton());
    private static final ReentrantLock lock = new ReentrantLock();

    public static ThreadSafeSingleton getInstance() {
        lock.lock();
        if (instance == null || instance.get() == null) {
            instance = new AtomicReference<>(new ThreadSafeSingleton());
        }
        var result = instance.get();
        lock.unlock();
        return result;
    }

    private ThreadSafeSingleton() {
    }
}