package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Student;

public class DepartmentDao {
	
	private Driver driver;
	private SessionConfig sessionConfig;
	
	public DepartmentDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig  = SessionConfig
				.builder()
//				.withDefaultAccessMode(AccessMode.WRITE)
				.withDatabase(dbName)
				.build();
	}
	
	/**
	 * GEt the number of students in a department
	 * @param dept - name - The department's name
	 * @return Map<String, Long> - The number of students in the department
     *
	 */
	public Map<String, Long> getNoOfStudentsByDept() {
		
		String query = "MATCH (dept:Department)<-[:BELONGS_TO]-(course:Course)<-[:ENROLLED]-(student:Student) "
				+ "RETURN dept.deptID as department_id, count(student) as total_students ";
		
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				return tx
						.run(query)
						.stream()
						.collect(
								Collectors.toMap(record -> record.get("department_id").asString(), 
										record -> record.get("total_students").asLong())
								);
						
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
