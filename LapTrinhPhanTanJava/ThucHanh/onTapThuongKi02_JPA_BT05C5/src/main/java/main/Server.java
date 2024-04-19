package main;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.CustomerDao;
import dao.OrderDao;
import dao.ProductDao;
import dao.implement.CustomerImplt;
import dao.implement.OrderImplt;
import dao.implement.ProductImplt;

public class Server {
	
	public static final String URL = "rmi://IAMHOANGKHANG:3791/";
	
	public static void main(String[] args) {
		try {
			CustomerDao customerDao = new CustomerImplt();
			OrderDao orderDao = new OrderImplt();
			ProductDao productDao = new ProductImplt();
			
			Context context = new InitialContext();
			LocateRegistry.createRegistry(3791);
			
			context.rebind(URL + "customer", customerDao);
			context.rebind(URL + "order", orderDao);
			context.rebind(URL + "product", productDao);
			
			System.out.println("Server is running...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
