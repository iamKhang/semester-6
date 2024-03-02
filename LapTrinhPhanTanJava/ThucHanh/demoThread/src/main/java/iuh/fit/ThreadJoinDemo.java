/*
 * @ (#) ThreadJoinDemo.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadJoinDemo demo = new ThreadJoinDemo();
        Runnable task = demo.new Task();
        Thread t1 = new Thread(task, "Thread One"); //Default name is Thread-0

        System.out.println("State of t1 before start: " + t1.getState()); // State of t1 before start: NEW

        t1.start();
//        t1.run();
        System.out.println("State of t1 after start: " + t1.getState()); // State of t1 after start: RUNNABLE

//        t1.join(); // wait for t1 to finish
        while (t1.isAlive()) {
        }

        System.out.println("State of t1 after join: " + t1.getState()); // State of t1 after join: TERMINATED

        System.out.println(Thread.currentThread().getName() + " end here");

    }


    class Task implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1);
//                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println();
        }
    }

}
