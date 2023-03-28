package com.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//singelton pattern
enum Downloader {
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data from the web...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class App {
    /**
     * It is used to control access to a shared resource
     * that uses a counter variable
     * <p>
     * semaphore maintains a set of permits
     * -acquire() ...if a permit is avaailable then takes it
     * -release() ...adds a permit
     * ``semaphore just keeps a count of the number of permits available
     * new Semaphore(int permits, boolean faireness)!!
     **/

    public static void main(String[] args) {
///create multiple threads - executors
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }
}
