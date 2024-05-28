package daoTest;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import dao.PersonDao;
import entity.Instructor;
import entity.Person;

class PersonDaoTest {
	
	private static PersonDao personDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		personDao = new PersonDao("LeHoangKhang_21083791_Hibernate");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		personDao.close();
	}

	@Test
	@Order(1)
	void addPersonTest() {
		Person person = new Instructor("Lê Hoàng", "Khang", "TP.HCM", new Timestamp(System.currentTimeMillis()));
		boolean result = personDao.addPerson(person);
		assert(result);
	}
	
	@Test
	@Order(2)
	void getPersonTest() {
		Person person = personDao.getPerson(4);
		String actual = person.getFirstName();
		String expected = "Fadi";
		assert(actual.equals(expected));
	}
	
	@Test
	@Order(3)
	void getPersionListTest() {
		List<Person> persons = personDao.getPersionList();
		int actual = persons.size();
		System.out.println(actual);
		int expected = personDao.countPerson();
		
		assert(actual == expected);
	}
	
	
//	@Test
//	@Order(4)
//	void deletePersonByLastNameTest() {
//		boolean result = personDao.deletePersonByLastName("Khang");
//		assert (result);
//	}
	
	@Test
	@Order(5)
	void updatePersonTest() {
		Person person = personDao.getPerson(2);
		person.setFirstName("Lê");
		person.setLastName("Khang");
		boolean result = personDao.updatePerson(person);
		assert (result);
	}

}
