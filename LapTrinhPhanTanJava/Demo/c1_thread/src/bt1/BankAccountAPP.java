package bt1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccountAPP {
	
	private static BankAccount acc = new BankAccount("John Smith", 0.0);
	
	public static void main(String[] args) {
		
		
		Runnable depositTask = ()->{
				acc.deposit(100.0);
		};
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 100; i++) {
			service.submit(depositTask);
		}
		
		service.shutdown();
		
		while(!service.isTerminated()) {
			//Wait
		}
		
		System.out.println("Balance: " + acc.getBalance());
		
		
	}
	

}
