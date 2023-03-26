package com.thread.create;

public class UsingAnnonymousClass {
    public static void main(String[] args) {
        Thread threaA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadA " + i);
                }
            }
        });

        Thread threaB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadB " + i);
                }
            }
        });

        threaA.start();
        threaB.start();
    }
}
