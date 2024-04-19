/*
 * @ (#) Main.java	1.0	Apr 1, 2024
 * 
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;

import java.util.Map;

import dao.CourseDao;
import dao.DepartmentDao;
import dao.StudentDao;
import dao.impl.CourseImpl;
import dao.impl.DepartmentImpl;
import dao.impl.StudentImpl;
import entity.Course;
import entity.Department;

public class Main {

	public static void main(String[] args) {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
//		EntityManager em = emf.createEntityManager();
		
		CourseDao courseDao = new CourseImpl();
		StudentDao studentDao = new StudentImpl();
		DepartmentDao departmentDao = new DepartmentImpl();
		
//		courseDao.findAll().forEach(System.out::println);
//		courseDao.findAllOnsiteCourses().forEach(System.out::println);		
		
//		studentDao.findByEnrollmentInCourse("po").forEach(System.out::println);
		
//		Map<Department, Long> map = departmentDao.countCoursesByDepartment();
//		map.entrySet()
//		.stream()
//		.forEach(entry -> {
//			System.out.println("Department: " + entry.getKey());
//			System.out.println("Number of courses: " + entry.getValue());
//		});
//		
		
		Course course = courseDao.findCourseByTitle2("Calculus");
		System.out.println(course);
		
	}
}
