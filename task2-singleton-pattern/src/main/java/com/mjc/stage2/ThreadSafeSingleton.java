package com.mjc.stage2;

import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings({"unused", "InstantiationOfUtilityClass"})
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private static final ReentrantLock lock = new ReentrantLock();

    public static ThreadSafeSingleton getInstance() {
        var result = instance;
        if (result != null) {
            return result;
        }

        lock.lock();
        if (instance != null) {
            instance = new ThreadSafeSingleton();
        }
        lock.unlock();

        return instance;
    }

    private ThreadSafeSingleton() {
    }
}