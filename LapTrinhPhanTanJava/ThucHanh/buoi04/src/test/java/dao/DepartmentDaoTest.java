package dao;

import util.AppUtild;

public class DepartmentDaoTest {
	public static void main(String[] args) {
		
		DepartmentDao deptDao = new DepartmentDao(AppUtild.initDriver(), "coursedb");
		
		deptDao.getNoOfStudentsByDept()
		.entrySet()
		.forEach(System.out::println);
		
	}
}
