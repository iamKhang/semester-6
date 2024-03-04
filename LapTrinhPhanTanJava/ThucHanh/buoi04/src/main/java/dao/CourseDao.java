package dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Course;
import util.AppUtild;

public class CourseDao {
	private Driver driver;
	private SessionConfig sessionConfig;

	public CourseDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

//	Add course by departmentID
	public String addCourse(Course course, String depId) {
		String query = "MATCH (d:Department {deptID: $depId}) "
				+ "CREATE (c:Course {courseID: $id, name: $name, hours: $hours})-[:BELONGS_TO]->(d) Return c.courseID as courseID";

		Map<String, Object> pars = Map.of("id", course.getCourseId(), "name", course.getName(), "hours",
				course.getHours(), "depId", depId);

		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext()) {
					return null;
				}
				Record record = result.stream().findFirst().get();
				return record.get("courseID").asString();
			});
		}
	}

//	Remove course by courseID
	public void removeCourse(String courseId) {
		String query = "MATCH (c:Course {courseID: $id}) DETACH DELETE c";
		Map<String, Object> pars = Map.of("id", courseId);

		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}

//	Count couser by deptID
	public int countCourseByDepIds(String courseId) {
		String query = "MATCH (d:Department {deptID: $id})\r\n" + "WITH d\r\n"
				+ "MATCH (c:Course)-[:BELONGS_TO]->(d)\r\n" + "RETURN COUNT(c) AS numberOfCourses\r\n" + "";
		Map<String, Object> pars = Map.of("id", courseId);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext()) {
					return 0;
				}
				Record record = result.stream().findFirst().get();
				return record.get("numberOfCourses").asInt();
			});
		}
	}

//	Get all courses
	public List<Course> getAllCourses() {
		String query = "MATCH (c:Course) RETURN c";

		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream().map(record -> {
					Node node = record.get("c").asNode();
					return AppUtild.convert(node, Course.class);
				}).toList();
			});
		}
	}

	
//	Get all courses by deptID
	public List<Course> getAllCoursesByDepId(String depId) {
		String query = "MATCH (d:Department {deptID: $id})\r\n" + "WITH d\r\n"
				+ "MATCH (c:Course)-[:BELONGS_TO]->(d)\r\n" + "RETURN c";

		Map<String, Object> pars = Map.of("id", depId);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				return result.stream().map(record -> {
					Node node = record.get("c").asNode();
					return AppUtild.convert(node, Course.class);
				}).toList();
			});
		}
	}
	
//	Remove course by courseID
	public void removeCourseByDepId(String depId) {
		String query = "MATCH ((c:Course) -[:BELONGS_TO]-> d:Department {deptID: $id}) DETACH DELETE c";
		Map<String, Object> pars = Map.of("id", depId);

		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}
	
//	The driver is closed
	public void close() {
		driver.close();
	}

}
