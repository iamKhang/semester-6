package bai02;

import java.util.Arrays;
import java.util.List;

public class Compare {

  public static void main(String[] args) {
    Integer[] array = new Integer[20_000_000];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    List<Integer> list = Arrays.asList(array);

    long endTime;
    double executionTimeInSeconds;
    long startTime = System.currentTimeMillis();

    long sum = list.parallelStream().mapToLong(Integer::longValue).sum();

    endTime = System.currentTimeMillis();
    executionTimeInSeconds = (endTime - startTime);
    System.out.println("Tong: " + sum);
    System.out.println(
      "Thoi gian khi su dung parallelStream(): " + executionTimeInSeconds
    );

    startTime = System.currentTimeMillis();

    sum = list.stream().mapToInt(Integer::intValue).sum();

    endTime = System.currentTimeMillis();
    executionTimeInSeconds = (endTime - startTime);

    System.out.println(
      "Thoi gian khi khong su sung parallelStream(): " + executionTimeInSeconds
    );
  }
}
