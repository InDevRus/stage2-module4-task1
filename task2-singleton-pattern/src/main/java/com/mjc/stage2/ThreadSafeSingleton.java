package com.mjc.stage2;

public class ThreadSafeSingleton {
    private ThreadSafeSingleton() {

    }

    private static class ThreadSafeSingletonHolder {
        public static final ThreadSafeSingleton instance = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstance() {
        return ThreadSafeSingletonHolder.instance;
    }
}
