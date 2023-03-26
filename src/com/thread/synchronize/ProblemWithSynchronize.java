package com.thread.synchronize;

public class ProblemWithSynchronize {
    public static int counter1 = 0;
    public static int counter2 = 0;

    //usually it is not good practise to use synchronized keyword
    public static void increment1() {
        //class level locking
        //rule of thumb: we synchronize blocks that are 100% necessary
        synchronized (ProblemWithSynchronize.class) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (ProblemWithSynchronize.class) {
            counter2++;
        }
    }

    public static void process() {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment1();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment2();
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
        System.out.println("Counter value after finishing proces: " + counter1 + " " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
