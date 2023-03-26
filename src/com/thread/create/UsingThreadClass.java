package com.thread.create;

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread1 " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread2 " + i);
        }
    }
}

public class UsingThreadClass {

    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();

        th1.start();
        th2.start();
    }
}
