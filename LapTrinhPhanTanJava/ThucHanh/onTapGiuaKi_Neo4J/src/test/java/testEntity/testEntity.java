package testEntity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Customer;

class testEntity {
	

	@Test
	void test() {
		Customer customer = new Customer();
		customer.setAddress("address");
		customer.setCity("city");
		customer.setCompanyName("companyName");
		customer.setContactName("contactName");
		customer.setContactTitle("contactTitle");
		customer.setCountry("country");
		customer.setCustomerID("customerID");
		customer.setFax("fax");
		System.out.println(customer.toString());
	}

}
