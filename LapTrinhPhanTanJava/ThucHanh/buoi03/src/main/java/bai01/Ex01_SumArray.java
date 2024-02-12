package bai01;

import java.util.Iterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Ex01_SumArray extends RecursiveTask<Long> {
	private static final int THRESHOLD = 100_000;
	private int[] array;
	private int start;
	private int end;

	public Ex01_SumArray(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		if (end - start <= THRESHOLD) {
			return computeDirectly();
		} else {
			int mid = (start + end) / 2;
			Ex01_SumArray leftTask = new Ex01_SumArray(array, start, mid);
			Ex01_SumArray rightTask = new Ex01_SumArray(array, mid, end);

			leftTask.fork();
			long rightResult = rightTask.compute();
			long leftResult = leftTask.join();

			return leftResult + rightResult;
		}
	}

	private long computeDirectly() {
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] array = new int[200_000_000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		long end;
		long start;
		long timeRun;

		start = System.currentTimeMillis();
		Ex01_SumArray task = new Ex01_SumArray(array, 0, array.length);
		ForkJoinPool pool = new ForkJoinPool();
		long result = pool.invoke(task);
		end = System.currentTimeMillis();
		timeRun = end - start;

		System.out.println("Tong mang la : " + result);
		System.out.println("Thoi gian khi su dung Fork/Join: " + timeRun);

		result = 0;
		start = System.currentTimeMillis();
		for (int i : array) {
			result += array[i];
		}
		end = System.currentTimeMillis();
		timeRun = end - start;

		System.out.println("Tong mang la: " + result);
		System.out.println("Thoi gian khi khong su dung Fork/Join: " + timeRun);
		
	}
}