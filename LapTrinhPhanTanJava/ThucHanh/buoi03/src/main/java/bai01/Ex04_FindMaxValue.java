package bai01;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class Ex04_FindMaxValue {

	public static void main(String[] args) {
		ForkJoinPool pool = ForkJoinPool.commonPool();

		int n = 10_000_000;
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
//		FindMaxValueTask task = new FindMaxValueTask(arr, 0, n);

//		pool.invoke(task);

		pool.shutdown();

		
	}

//	public static class FindMaxValueTask extends RecursiveTask<Integer> {
//
//		private static final int THRESHOLD = 10_000;
//		private int[] arr;
//		private int lo;
//		private int hi;
//
//		public FindMaxValueTask(int[] arr, int lo, int hi) {
//			this.arr = arr;
//			this.lo = lo;
//			this.hi = hi;
//		}

//		@Override
//		protected Entry<Integer, Integer> compute() {
//			if (hi - lo >= THRESHOLD) {
//				return Arrays.stream(arr)
//						.mapToObj(i -> new AbstractMap.SimpleEntry<>(arr[i], i))
//						.max(Map.Entry.comparingByKey())
//						.orElse(null);
//			} else {
//				int mid = (lo + hi) / 2;
//
//				FindMaxValueTask left = new FindMaxValueTask(arr, lo, mid);
//				FindMaxValueTask right = new FindMaxValueTask(arr, mid, hi);
//
//				left.fork();
//				Entry<Integer, Integer> rightResult = right.compute();
//				Entry<Integer, Integer> leftResult = left.join();
//
//				return (leftResult.getKey() > rightResult.getKey()) ? leftResult : rightResult;
//			}
//		}

//	}

}
