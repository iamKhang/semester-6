package dao.impl;

import java.util.List;

import dao.StudentDao;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class StudentImpl implements StudentDao{
	
	private static final String PERSISTENCE_UNIT_NAME = "jpa-mssql";
	private EntityManager em;
	
	public StudentImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<Student> findByEnrollmentInYear(int year) {
		return em.createNamedQuery("Student.findByEnrollmentInYear", Student.class)
				.setParameter("year", year)
				.getResultList();
	}

	@Override
	public List<Student> findByEnrollmentInCourse(String title) {
		return em.createNamedQuery("Student.findStudentsEnrolledInCourse", Student.class)
				.setParameter("title", "%"+title+"%")
				.getResultList();
	}
	@Override
	public List<Student> findAll() {
		return em.createNamedQuery("Student.findAll", Student.class).getResultList();
	}

	@Override 
	public void updateInfo(String name, String name2, String id) {
		em.getTransaction().begin();
		em.createNamedQuery("Student.updateInfo").setParameter("lastName", name).setParameter("firstName", name2)
				.setParameter("id", id).executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void deleteByID(String id) {
		em.getTransaction().begin();
	    
	    // Xóa tất cả StudentGrade liên quan
	    em.createNamedQuery("StudentGrade.xoaTheoStudentID")
	      .setParameter("studentId", id)
	      .executeUpdate();

	    // Xóa Student
	    em.createNamedQuery("Student.xoaTheoID")
	      .setParameter("id", id)
	      .executeUpdate();
	      
	    em.getTransaction().commit();
		
	}

	@Override
	public Student add(Student student) {
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		return student;
	}

}
