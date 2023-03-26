package com.thread.priority;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread with max priority " + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread with min priority " + i);
                }
            }
        });
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        System.out.println("Main Thread execution.");
    }
}
