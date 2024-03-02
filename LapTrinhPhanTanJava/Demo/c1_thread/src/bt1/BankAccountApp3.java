package bt1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BankAccountApp3 {

	private static BankAccount account = new BankAccount("John Smith", 0.0);
	
	public static void main(String[] args) {
		
		Runnable task1 = () -> {
			try {
				Thread.sleep(1000);
				account.deposit(10_000.0);
				System.out.println("Nap thanh cong. Balance = " + account.getBalance() );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Callable<Double> task2 = () -> {
			return account.withdraw(50_000.0);
		};
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		service.submit(task1);
		service.submit(task1);
		service.submit(task1);
//		service.submit(task1);
		service.submit(task1);
		
		Future<Double> fu = service.submit(task2);
		
		service.shutdown();
		
		double money = 0.0;
		try {
			money = fu.get(10, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			System.exit(0);
		} 
		
		System.out.println("Money: " + money);
		System.out.println("Balance: " + account.getBalance());
	}
	
}
