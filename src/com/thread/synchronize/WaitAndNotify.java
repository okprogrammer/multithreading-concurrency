package com.thread.synchronize;

class Process {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Again in the produce method...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consume method is executed");
            notify();
            // It's not going to handle the lock: we can make the further operation
            Thread.sleep(5000);
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        Process process = new Process();
        Thread produceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        produceThread.start();
        consumeThread.start();
    }
}
