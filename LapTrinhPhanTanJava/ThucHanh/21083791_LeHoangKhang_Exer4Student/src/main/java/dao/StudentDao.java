package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {
	
	public List<Student> findByEnrollmentInYear(int year);
	public List<Student> findByEnrollmentInCourse(String title);
	public List<Student> findAll();
	public void deleteByID(String id);
	public Student add(Student student);
	public void updateInfo(String name, String name2, String id);
}
