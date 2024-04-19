package daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.implement.OrderImplt;

class OrderDaoTest {
	
	static OrderImplt orderDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		orderDao = new OrderImplt();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		orderDao = null;
	}

	@Test
	void testGetTotalPriceByOrderID() throws IOException {
		double actual = orderDao.getTotalPriceByOrderID(1);
		double expected = 10231.0464;
		
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetTotalPriceByDate() throws IOException {
		double actual = orderDao.getTotalPriceByDate(java.time.LocalDate.of(2016, 1, 12));
		double expected = 6542.6113000000005;

		assertEquals(expected, actual);
	}
}
