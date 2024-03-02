package dao;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Student;
import util.AppUtild;

public class StudentDao {
	
	private Driver driver;
	private SessionConfig sessionConfig;
	
	public StudentDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig  = SessionConfig
				.builder()
//				.withDefaultAccessMode(AccessMode.WRITE)
				.withDatabase(dbName)
				.build();
	}
	
	/**
	 * Add new student
	 * @param student - The student to add
	 */
	public void addStudent(Student st) {
		
		String query = "CREATE (s:Student {studentID: $id, name: $name, gpa: $gpa}) ";
	
		Map<String, Object> pars = Map.of("id", st.getStudentId(), 
				"name", st.getName(), 
				"gpa", st.getGpa());
		
		try(Session session = driver.session(sessionConfig)){
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}
	
	/**
	 * Add new student
	 * @param student - The student to add
	 * @return The student's id
	 */
	public String addStudent2(Student st) {
		
		String query = "CREATE (s:Student {studentID: $id, name: $name, gpa: $gpa}) "
				+ "RETURN s.studentID as studentID";
		
		Map<String, Object> pars = Map.of("id", st.getStudentId(), 
				"name", st.getName(), 
				"gpa", st.getGpa());
		
		try(Session session = driver.session(sessionConfig)){
			return session.executeWrite(tx -> {
				Result result = tx.run(query, pars);
				if(!result.hasNext())
					return null;
				
				Record record = result.stream().findFirst().get();
				
				return record.get("studentID").asString();
			});
		}
	}
	
	/**
	 * Get student by id
	 * 
	 * @param id - The student's id
	 * @return The student
	 */
	public Student findStudentByID(String studentID) {
		
		String query = "MATCH (s:Student) "
				+ "WHERE s.studentID = $id "
				+ "RETURN s";
		
		Map<String, Object> pars = Map.of("id", studentID);
		
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;
				
				Record record = result.stream().findFirst().get();
				Node node = record.get("s").asNode();
//				return new Student(node.get("studentID").asString(),
//						node.get("name").asString(),
//						Float.parseFloat(node.get("gpa").toString()));
				
				return AppUtild.convert(node, Student.class);
				
			});
		}
	}
	
	/**
	 * Get list of students, limit to n
	 * @param n - The number of students to return
	 * @return The list of students
     *
	 */
	public List<Student> listOfStudents(int limit) {
		
		String query = "MATCH (s:Student) " 
				+ "RETURN s "
				+ "LIMIT $limit";
		
		Map<String, Object> pars = Map.of("limit", limit);
		
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);				
				
				return result
						.stream()
						.map(record -> {
							Node node = record.get("s").asNode();
//                            return new Student(node.get("studentID").asString(),
//                                    node.get("name").asString(),
//                                    Float.parseFloat(node.get("gpa").toString()));
							return AppUtild.convert(node, Student.class);
						}).toList();
			});
		}
	}
	
	/**
	 * Update student's information
	 * @param student - The student to update
     *
	 */
	public void updateStudent(Student st) {
		String query = "MERGE (s:Student {studentID: $id}) " + "SET s.name = $name, s.gpa = $gpa";
		Map<String, Object> pars = Map.of("id", st.getStudentId(), "name", st.getName(), "gpa", st.getGpa());
	
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}
	
	/**
	 * Delete student by id
	 * 
	 * @param id - The student's id
	 *
	 */
	public void	deleteStudentById(String studentID) {
		String query = "MATCH (s:Student) " + "WHERE s.studentID = $id " + "DELETE s";
		Map<String, Object> pars = Map.of("id", studentID);
		
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}
	
	
	/**
	 * Close the driver
	 */
	public void close() {
		driver.close();
    }
}
