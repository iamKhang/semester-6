/*
 * @ (#) ThreadDemo1.java       25/12/2023
 *
 * Copyright (c) 2023 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.stream.IntStream;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   25/12/2023
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread1 = new Thread(task, "Thread 1");
//        thread1.setName("Thread 1");
        thread1.start();
//        thread1.run();
    }

}

class MyTask implements Runnable {

    @Override
    public void run() {
        // Calculate sum of 1 to 100
        int sum = IntStream
                .rangeClosed(1, 100)
                .sum();
        System.out.println(Thread.currentThread().getName() + ", Sum = " + sum);
    }
}