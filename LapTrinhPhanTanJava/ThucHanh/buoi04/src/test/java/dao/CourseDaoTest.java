package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import entity.Course;
import util.AppUtild;

@TestInstance(Lifecycle.PER_CLASS)
class CourseDaoTest {

	private static final String DB_NAME = "coursedb";
	private static CourseDao courseDao;

	@BeforeAll
	static void setUp() throws Exception {
		courseDao = new CourseDao(AppUtild.initDriver(), DB_NAME);
	}

	@Test
	void testAddCourse() {
		Course course = new Course("IE202", "Simulation", 3);
		String depId = "IE";
		String id = courseDao.addCourse(course, depId);
		String actual = id;
		String expected = "IE202";
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSearchCourse() {
		String dept = "IE";
		int count = courseDao.countCourseByDepIds(dept);
		int expected = 3;
		int actual = count;
		assertEquals(expected, actual);
	}

	@AfterAll
	static void tearDown() throws Exception {
		courseDao.removeCourse("IE202");
		courseDao.close();
	}

}
