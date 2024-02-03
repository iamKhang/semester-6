package bai03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private String accountID;
	private double balance;

	private Lock lock = new ReentrantLock();

	public void deposit(double amount) {
		lock.lock();

		try {

			while (balance + amount > 100_000) {
				System.out.println("Số tiền trong tài khoản không được quá 100.000");
				Thread.sleep(1000);
			}
			balance += amount;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
	
	public double withdraw(double amount) {
		lock.lock();
		try {
			while(amount > balance) {
				System.out.println("Số tiền rút vượt quá số dư trong tài khoản!");
				Thread.sleep(1000);
			}
			balance -= amount;
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			lock.unlock();
		}
		return amount;
	}

	public Account() {
		super();
	}

	public Account(String accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + "]";
	}

}
