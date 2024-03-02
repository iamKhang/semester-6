/*
 * @ (#) PoolDemo.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class PoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        PoolDemo demo = new PoolDemo();
        Callable<Integer> sumRange1 = demo.new SumRange(1, 100);
        Callable<Integer> sumRange2 = demo.new SumRange(101, 200);
        Callable<Integer> sumRange3 = demo.new SumRange(201, 300);
        Callable<Integer> sumRange4 = demo.new SumRange(301, 400);
        Callable<Integer> sumRange5 = demo.new SumRange(401, 500);

        List<Callable<Integer>> tasks = List.of (sumRange1, sumRange2, sumRange3, sumRange4, sumRange5);

        ExecutorService pool = Executors.newFixedThreadPool(3); // 3 threads

        List<Future<Integer>> fus = pool.invokeAll(tasks);

        Future<Integer> fun = pool.submit(demo.new SumRange(500, 1000));

        pool.shutdown();



        int sum = fus.stream()
                .mapToInt(fu -> {
                    try{
                        return fu.get();
                    }catch (InterruptedException | ExecutionException e){
                        e.printStackTrace();
                    }
                    return 0;
                })
                .sum();

        sum += fun.get();
        System.out.println("Sum = " + sum);
    }


    class SumRange implements Callable<Integer>{
        private int start;
        private int end;

        public SumRange(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            return IntStream.range(start, end).sum();
        }
    }
}
