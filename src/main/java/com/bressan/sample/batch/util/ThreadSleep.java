package com.bressan.sample.batch.util;

public class ThreadSleep extends Thread {

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void startThread() {
        ThreadSleep threadSleep = new ThreadSleep();
        threadSleep.run();
    }
}
