package itemDaoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.ItemDao;
import dao.impl.ItemDaoImpl;
import entity.Food;
import enums.Type;
import jakarta.persistence.EntityManagerFactory;

class ItemDaoTest {
	static ItemDao itemDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		itemDao = new ItemDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		itemDao = null;
	}

//	public boolean addFood(Food food);
//
//	public List<Item> listItems(String supplierName);
//
//	public Map<Food, Double> listFoodAndCost();
	
	@Test
	void testAddFoodSuccess() {
		Food food = new Food("F2003", "Banh mi thit", 20_000, "Rat ngon", true, Type.DESSERT, 10, 30);
		assertTrue(itemDao.addFood(food));
	}
	
	@Test
	void testAddFoodFail() {
		Food food = new Food("2003", "Banh mi thit", 20_000, "Rat ngon", true, Type.DESSERT, 10, 30);
		assertFalse(itemDao.addFood(food));
	}
	
	@Test
	void testListItems() {
		assertEquals(3, itemDao.listItems("Anna Food Distributors").size());
	}
}
