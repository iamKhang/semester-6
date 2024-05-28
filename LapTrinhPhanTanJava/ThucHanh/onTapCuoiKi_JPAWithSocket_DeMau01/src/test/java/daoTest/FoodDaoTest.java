package daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.FoodDao;
import entity.Food;

class FoodDaoTest {
	
	static FoodDao foodDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		foodDao = new FoodDao();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	    foodDao = null;
	}

//	Test case 1: Test addFood method
//	@Test
//	void testAddFood() {
//		assertEquals(true, foodDao.addFood(null));
//	}
	
	// Test case 2: Test listItems method
	@Test
	void testListItems() {
		int expected = 1;
		int actual = foodDao.listItems("Hank's Beverages").size();
		assertEquals(expected, actual);
	}
	
	@Test
	void listFoodAndCost() {
		Map<Food, Double> map = foodDao.listFoodAndCost();
	    map.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
