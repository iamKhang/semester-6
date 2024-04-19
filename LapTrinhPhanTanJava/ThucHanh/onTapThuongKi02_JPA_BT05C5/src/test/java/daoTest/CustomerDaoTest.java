package daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.implement.CustomerImplt;
import entity.Customer;

class CustomerDaoTest {

	static CustomerImplt customerImplt;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerImplt = new CustomerImplt();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		customerImplt = null;
	}

	@Test
	void testGetNumberCustomerByState() throws IOException {
		
		Map<String, Integer> map = customerImplt.getNumberCustomerByState();
		
		int actual = map.get("NY");
		int expected = 1019;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetOrdersByCustomers() throws IOException {

		Map<Customer, Integer> map = customerImplt.getOrdersByCustomers();
		map.forEach((k, v) -> System.out.println(k.getFirstName() +" "+ k.getLastName() + " : " + v));
//		int actual = map.get("Alice");
//		int expected = 1;
//
//		assertEquals(expected, actual);
	}

}
