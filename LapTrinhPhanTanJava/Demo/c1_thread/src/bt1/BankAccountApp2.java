package bt1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BankAccountApp2 {
	
	private static BankAccount accout = new BankAccount("John Smith", 10_000.0);
	
	public static void main(String[] args) {
		
		Callable<Double> task = () -> {
			return accout.withdraw(100.0);
		};
		
		List<Future<Double>> futures = new ArrayList<>();
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 100; i++) {
			Future<Double> fu = service.submit(task);
			futures.add(fu);
		}
		
		service.shutdown();
		
		double money = futures.stream()
				.mapToDouble(fu -> {
					try {
						return fu.get();
					}catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
					return 0.0;
				})
				.sum();
		
		System.out.println("Money: " + money);
		System.out.println("Balance: " + accout.getBalance());
	}
	
}
