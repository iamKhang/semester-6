package dao;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import entity.Product;
import utils.ConnectDB;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestProductDAO {
	private ProductDAO productDAO;
	
	@BeforeAll
	void setUp() throws Exception {
		productDAO = new ProductDAO();
	}

	@Test
	@Order(1)
	void testGetAllProduct() {
		List<Product> products = productDAO.getAllProducts();
	}
	
	@Test
	@Order(1)
	void testGetProductById() {
//        Product product = productDAO.getProductById("15");
//        assert(product != null);
//        assert(product.getProductName().equals("Genen Shouyu"));
    }
	
	@Test
	@Order(2)
	void testAddProduct() {
//		Product product = new Product("100", "Test Product", 1000.0, "10 boxes x 20 bags", "1", "1", 10, 1000);
//		productDAO.addProduct(product);
//		Product productTest = productDAO.getProductById("100");
//		assert(productTest != null);
//		assert(productTest.getProductName().equals("Test Product"));
	}
	
	@Test
	@Order(3)
	void testUpdateProduct() {
//		Product product = new Product("100", "Test Product Update", 1000.0, "10 boxes x 20 bags", "1", "1", 10, 1000);
//		productDAO.updateProduct(product);
//		Product productTest = productDAO.getProductById("100");
//		assert(productTest != null);
//		assert(productTest.getProductName().equals("Test Product Update"));
	}
	
	@Test
	@Order(4)
	void testDeleteProduct() {
		productDAO.deleteProduct("100");
		Product product = productDAO.getProductById("100");
		assert(product == null);
	}
	
	@Test
	void testSearchProductBySupplier() {
		List<Product> products = productDAO.searchProductBySupplierName("Pavlova");
		assert(products != null);
		assert(products.size() == 5);
	}
	
	@Test
	void testSearchProductWithHighPrice() {
//		List<Product> products = productDAO.findProductWithHighPrice();
////		Check if products have 1 product with productID = 38
//		assert(products != null);
//        assert(products.size() == 1);
//        assert(products.get(0).getProductId().equals("38"));
	}
	
	@AfterAll
	void tearDown() throws Exception {
		productDAO.deleteProduct("100");
		ConnectDB.connectDB().close();
	}

}
