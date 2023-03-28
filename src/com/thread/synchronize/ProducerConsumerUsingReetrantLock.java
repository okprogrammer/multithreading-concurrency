package com.thread.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockWorker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method....");
        //wait()
        condition.await();
        System.out.println("Again the producer method...");
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Consumer method....");
        lock.lock();
        //notify()
        condition.signal();
        lock.unlock();
    }
}

public class ProducerConsumerUsingReetrantLock {

    public static void main(String[] args) {
        LockWorker lw = new LockWorker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lw.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lw.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
