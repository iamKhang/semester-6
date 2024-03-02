/*
 * @ (#) ThreadDemo3.java       25/12/2023
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
public class ThreadDemo3 extends  Thread{

    @Override
    public void run() {
        int sum = IntStream.rangeClosed(1, 100).sum();
        System.out.println("Sum of 1 to 100 is: " + sum);
    }

    public static void main(String[] args) {

        ThreadDemo3 threadDemo3 = new ThreadDemo3();
        threadDemo3.start();

    }
}
