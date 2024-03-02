package test02;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Customer> customers = ConvertJson.readFile("data/customers.json");
		
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		ConvertJson.writeFile(customers, "data/QuanKhang.json");
	}
}
