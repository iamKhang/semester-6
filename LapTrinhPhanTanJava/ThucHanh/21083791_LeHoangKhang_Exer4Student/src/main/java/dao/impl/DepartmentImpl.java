package dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.DepartmentDao;
import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DepartmentImpl implements DepartmentDao{
	
	private static final String PERSISTENCE_UNIT_NAME = "jpa-mssql";
	private EntityManager em;
	
	public DepartmentImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public Map<Department, Long> countCoursesByDepartment() {
		
		Map<Department, Long> map = new LinkedHashMap<Department, Long>();
		
		List<?> results = em.createNamedQuery("Department.countCoursesByDepartment")
				.getResultList();
		
		results
		.stream()
		.map(o -> (Object[]) o)
		.forEach(o -> {
			int departmentID = (int)o[0];
			Department department = em.find(Department.class, departmentID);
			long count = (long)o[1];
			map.put(department, count);
		});
		
		return map;
	}


}
