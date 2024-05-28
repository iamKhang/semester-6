package daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.BookDao;
import entity.Book;

class BookDaoTest {
	
	static BookDao bookDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bookDao = new BookDao();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		bookDao = null;
	}
	
	@Test
	void testListRatedBooks() {
		List<Book> list = bookDao.listRatedBooks("Ralph Johnson", 4);
		list.forEach(System.out::println);
		assertEquals(1, bookDao.listRatedBooks("Erich Gamma", 4).size());
	}
	
	@Test
	void testCountBooksByAuthor() {
		Map<String, Long> map = bookDao.countBooksByAuthor();
		map.forEach((k, v) -> System.out.println(k + " : " + v));
		assertEquals(11, map.size());
		assertEquals(1, map.get("Erich Gamma"));
		assertEquals(2, map.get("Robert C. Martin"));
		assertEquals(1, map.get("David Thomas"));
	}

	
//	@Test
//	void testUpdateReviews() {
//	    assertEquals(false, bookDao.updateReviews("978013235088", "123", 5, "Good book"));
//	    
//	    assertEquals(true, bookDao.updateReviews("978-0201633610", "3", 5, "Good book"));
//	}
}
