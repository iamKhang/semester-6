package bai03;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppDemo {
	private static Account account = new Account("Lê Hoàng Khang", 0);

	public static void main(String[] args) {

		Runnable depositTask = () -> {
			account.deposit(100);
		};

		ExecutorService service = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			service.submit(depositTask);
		}

		service.shutdown();

		while (!service.isTerminated()) {

		}

		System.out.println("Số dư hiện tại trong tài khoản là: " + account.getBalance());
	}
}
