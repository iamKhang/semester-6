package testDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.CategoryDAO;
import entity.Category;

class TestCategoryDao {
	private static CategoryDAO categoryDAO;
	
	@BeforeAll
	static void setUp() throws Exception {
		categoryDAO = new CategoryDAO();
	}
	
	@Test
	void testFindCategoryById() {
		Category category = categoryDAO.findCategory("HoangKhang");
		assertEquals("Beverages", category.getCategoryName());
	}
	
	@Test
	void testAddCategory() {
		Category category = new Category("HoangKhang", "HoangKhang", "HoangKhang", "HoangKhang");
		categoryDAO.addCategory(category);
	}
	
	
	@AfterAll
	static void tearDown() throws Exception {
        categoryDAO.removeCategory("HoangKhang");
	}

}
