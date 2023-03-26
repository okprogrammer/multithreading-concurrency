package com.thread.synchronize;

public class App {
    public static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void process() {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4000; i++) {
                    increment();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter value after finishing proces: " + counter);
    }

    public static void main(String[] args) {
        process();
    }
}
