package dao;

import java.util.Map;

import entity.Department;

public interface DepartmentDao {
	public Map<Department, Long> countCoursesByDepartment();
}
