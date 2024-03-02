/*
 * @ (#) CounterApp.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.concurrent.*;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class CounterApp {

    private static Counter counter = new Counter(); // shared object, count = 0

    public static void main(String[] args) {

        Runnable task = () -> {
            counter.increment();
        };

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            pool.execute(task);
        }

        for (int i = 0; i < 1000; i++) {
            pool.execute(task);
        }

        pool.shutdown();
        while (!pool.isTerminated()) {
            // wait for all tasks to finish
        }

        System.out.println("Count = " + counter.getCount()); // Count = 2000
    }

}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
