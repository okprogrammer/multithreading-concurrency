package com.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable {
    private int work;

    public Worker(int work) {
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + work + " is in work - thread id: " + Thread.currentThread().getId());
        long duration = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Worker(i + 1));
        }
        executorService.close();
    }
}
