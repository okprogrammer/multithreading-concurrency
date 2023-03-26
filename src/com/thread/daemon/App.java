package com.thread.daemon;

class DaemonWorker implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4000);
                System.out.println("Daemon thread is running...");
            } catch (InterruptedException e) {

            }
        }
    }
}

class NormalWorker implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("Normal finishes its execution...");
        } catch (InterruptedException e) {

        }
    }
}

public class App {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new NormalWorker());

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}
