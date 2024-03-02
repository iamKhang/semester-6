/*
 * @ (#) LIstSharingDemo.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.*;
import java.util.concurrent.*;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class ListSharingDemo {

//  private static List<Integer> list = new ArrayList<>(); // shared object, not thread-safe, fast
//    private static List<Integer> list = new Vector<>(); // Thread-safe, but slow
    private static List<Integer> list = new CopyOnWriteArrayList<>();
//    private static List<Integer> list = Collections.synchronizedList(new ArrayList<>()); // shared object

    public static void main(String[] args) {
        Random rd = new Random();

        Runnable task = () -> {
//            synchronized (list) { // synchronized block
                list.add(rd.nextInt(100)); // range: 0 - 99
//            }
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

        System.out.println("List size: " + list.size()); //Expected: 2000 <> Actual: 2000 (but not always)

    }


}
