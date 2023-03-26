package com.thread.synchronize;

public class LockingWithCustomObject {

    public static int counter1 = 0;
    public static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1() {
        synchronized (lock1) {
            counter1++;
        }
    }

    public static synchronized void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void process() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment1();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment2();
                }
            }
        });

        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter values: " + "counter = " + counter1 + " counter2 = " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
