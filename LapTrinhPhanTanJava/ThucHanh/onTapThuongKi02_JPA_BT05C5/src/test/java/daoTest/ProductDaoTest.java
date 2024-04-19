package daoTest;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import dao.implement.ProductImplt;
import entity.Product;

class ProductDaoTest {
	static ProductImplt productImplt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		productImplt = new ProductImplt();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		productImplt = null;
	}

//	@Order(1)
//	@Test
//	void testInsertProduct() {
//		Product product = new Product("Iphone 13", 2021, 1500d);
//		assertTrue(productImplt.insertProduct(product));
//	}
//	
//	@Order(4)
//	@Test
//	void testUpdateProduct() {
//		Product product = productImplt.getProductById(1);
//		System.out.println(product);
//		product.setName("Khang đã Update");
//		assertTrue(productImplt.updateProduct(product));
//	}
//	
//	@Order(3)
//	@Test
//	void testDeleteProduct() {
//		assertTrue(productImplt.deleteProduct(326));
//	}
//	
//	@Order(2)
//	@Test
//	void testGetProductById() {
//		
//			Product product = productImplt.getProductById(2);
//			String actual = product.getName();
//			String expected = "Ritchey Timberwolf Frameset - 2016";
//			assertEquals(expected, actual);
//	}
	
//	@Order(5)
//	@Test
//	void testGetAllProduct() {
//		assertEquals(1, productImplt.getAllProduct().size());
//	}

	@Order(6)
	@Test
	void testGetTopProductPrice() throws IOException {
		List<Product> products = productImplt.getTopProductPrice();
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	@Order(7)
	@Test
	void testGetNotSaleProduct() throws IOException {
		List<Product> products = productImplt.getNotSaleProduct();
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	@Order(8)
	@Test
	void testGetTotalProduct() throws IOException {
		productImplt.getTotalProduct().forEach((k, v) -> System.out.println(k + " : " + v));
	}

}
