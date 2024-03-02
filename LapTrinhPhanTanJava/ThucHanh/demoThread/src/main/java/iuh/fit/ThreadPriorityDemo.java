/*
 * @ (#) ThreadPriorityDemo.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
        };

        System.out.println("Priority of main thread: " + Thread.currentThread().getPriority()); // Priority of main thread: 5

        Thread t1 = new Thread(task, "Thread One");

        System.out.println("Priority of t1: " + t1.getPriority()); // Priority of t1: 5

        Thread.currentThread().setPriority(7);

        System.out.println("Priority of main thread: " + Thread.currentThread().getPriority()); // Priority of main thread: 7

        Thread t2 = new Thread(task, "Thread Two");

        System.out.println("Priority of t2: " + t2.getPriority()); // Priority of t2: 7

        t1.start();
        t2.start();

    }
}
