package client;

import java.rmi.Naming;
import java.util.Map;

import dao.ProductDao;
import entity.Product;

public class Client {
	
	public static final String URL = "rmi://IAMHOANGKHANG:3791/";

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			ProductDao productDao = (ProductDao) Naming.lookup(URL + "product");
			Map<Product, Integer> products = productDao.getTotalProduct();
			for (Product product : products.keySet()) {
				System.out.println(product + " /n " + products.get(product));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
