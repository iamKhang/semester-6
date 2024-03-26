package main;

import dao.CategoryDAO;
import entity.Category;
import entity.Customer;

public class Main {
	public static void main(String[] args) {
//		Customer customer = new Customer("id", "address", "city", "companyName", "contactName", "contactTitle", "country", "customerID", "fax", "phone", "postalCode", "region");
//		System.out.println(customer);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		
		Category category = new Category("HoangKhang", "HoangKhang", "HoangKhang", "HoangKhang");
		categoryDAO.addCategory(category);
		
		categoryDAO.removeCategory("categoryDemo");
	}
}
