package bai03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppDemoFuture {
	private static Account account = new Account("Lê Hoàng Khang", 10_000);

	public static void main(String[] args) {
		Callable<Double> withdraw = () -> {
			return account.withdraw(100);
		};
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			Future<Double> fu = service.submit(withdraw);
			futures.add(fu);
		}
		service.shutdown();
		
		double money = futures.stream().mapToDouble(fu -> {
			try {
				return fu.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}).sum();
		
		System.out.println("So tien rut: "+money);
		System.out.println("So du trong tai khoan: "+ account.getBalance());

	}
}
