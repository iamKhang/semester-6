/*
 * @ (#) LockDemo.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class LockDemo {

    private  static Counter2 counter = new Counter2(); // shared object, count = 0
    public static void main(String[] args) {
        Runnable task1 = () -> {
                counter.increment();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(task1);
        }

        for (int i = 0; i < 1000; i++) {
            executorService.submit(task1);
        }

        executorService.shutdown();

//        try {
//            executorService.awaitTermination(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        while (!executorService.isTerminated()) {
            // wait for all tasks to finish
        }

        System.out.println("Final count is: " + counter.getCount());
    }

}

class Counter2 {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try{
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try{
            count--;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
