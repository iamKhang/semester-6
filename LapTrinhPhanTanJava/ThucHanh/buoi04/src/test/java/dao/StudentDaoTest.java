package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import entity.Student;
import util.AppUtild;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class StudentDaoTest {
	private static final String DB_NAME = "coursedb";
	private StudentDao studentDao;

	@BeforeAll
	void setUp() throws Exception {
		studentDao = new StudentDao(AppUtild.initDriver(), DB_NAME);
	}
	
	@Test
	@Order(1)
	void testAddStudent() {
		Student st = new Student ("55", "John Doe", 3.5f);
		studentDao.addStudent(st);
	}
	
	@Test
	@Order(1)
	void testAddStudent2() {
//		System.out.println("testAddStudent2");
		Student st = new Student("66", "Bobby Smith", 3.7f);
		String id = studentDao.addStudent2(st);
		String expected = "66";
		String actual = id;
		assertEquals(expected, actual);
	}
	
	@Test
	@Order(2)
	void testFindStudentByID() {
//		System.out.println("testFindStudentByID");
		String id = "66";
		Student st = studentDao.findStudentByID(id);
//		System.out.println(st);
		assertNotNull(st);
		assertEquals("Bobby Smith", st.getName());
		assertEquals(3.7f, st.getGpa());
	}
	
	@Test
	void testFindStudentByID_Null() {
		String id = "555";
		Student st = studentDao.findStudentByID(id);
		assertNull(st);
	}
	
	@Test
	void testListOfStudents() {
		List<Student> students = studentDao.listOfStudents(10);
		assertEquals(7, students.size());
		students.forEach(st -> System.out.println(st));
	}
	
	
	@AfterAll
	void tearDown() throws Exception {
		studentDao.deleteStudentById("66");
		studentDao.deleteStudentById("55");
		studentDao.close();
		studentDao = null;
	}

}
