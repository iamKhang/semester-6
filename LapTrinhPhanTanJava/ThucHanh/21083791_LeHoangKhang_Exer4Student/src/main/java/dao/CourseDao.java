package dao;

import java.util.List;

import entity.Course;
import entity.OnsiteCourse;

public interface CourseDao {
	
	public boolean addCourse(Course course);
	public boolean updateCourse(Course course);
	public boolean deleteCourse(int id);
	public Course findCourseByID(int id);
	public Course findCourseByTitle2(String title); //Tim tuyet doi
	public List<Course> findCourseByTitle(String title); //Tim tuong doi
	public List<Course> findAll(); 
	public List<OnsiteCourse> findAllOnsiteCourses();
	
}
