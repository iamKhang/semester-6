package bt1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{
	//withdraw : rut tien
	//deposit : tien gui

	private String name;
	private double balance = 0;// tien con lai



	private final Lock lock = new ReentrantLock();// kiem soat quyen truy cap trang thai tk
	private final Condition condition = lock.newCondition();// dtuong lien ket voi khoa bao hieu giua cac luong


	public BankAccount(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public BankAccount() {
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void deposit(double amount) {//gui so tien dc chi dinh vao tai khoan
		lock.lock();
		try {
			if(amount<=0 || amount > 100_000.0) {
				throw new IllegalArgumentException("Error !!! Tien gui vuot qua 100$");
			}else {
				balance += amount;
				condition.signalAll();
			}
		}finally {
			lock.unlock();
		}
	}

	public double withdraw(double amount) throws InterruptedException {//rut so tien chi dinh vao tai khoan
		lock.lock();
		try {
			if(amount <= 0)
				throw new IllegalArgumentException("So tien phai > 0");
			else
				while(balance < amount) {
					System.out.println("Khong du tien. Balance: " + balance);
					condition.await(2, TimeUnit.SECONDS); // Doi ai do nap tien
				}

			balance -= amount;

		}finally {
			lock.unlock();
		}

		return amount;
	}
}