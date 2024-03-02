package test03;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Customer> list = ConvertJson.readFile("data/customers.json");
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		ConvertJson.writeFile(list, "data/customers.json");
	}
}
