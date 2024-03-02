/*
 * @ (#) CallableDemo.java       25/12/2023
 *
 * Copyright (c) 2023 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   25/12/2023
 */
public class CallableDemo {

    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            // Calculate sum of 1 to 100
            return  IntStream
                    .rangeClosed(1, 100)
                    .sum();
        };

        ExecutorService executorServices = Executors.newFixedThreadPool(2);
        Future<Integer> fu = executorServices.submit(task);
        try {
            System.out.println("Sum = " + fu.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorServices.shutdown();


//        FutureTask<Integer> futureTask = new FutureTask<>(task);
//        Thread thread1 = new Thread(futureTask, "Thread 1");
//        thread1.start();
    }

}
