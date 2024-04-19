package dao.impl;

import java.util.List;

import dao.CourseDao;
import entity.Course;
import entity.OnsiteCourse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CourseImpl implements CourseDao{
	
	private static final String PERSISTENCE_UNIT_NAME = "jpa-mssql";
	private EntityManager em;
	
	public CourseImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public boolean addCourse(Course course) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCourse(Course course) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCourse(int id) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Course course = em.find(Course.class, id);
			em.remove(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Course findCourseByID(int id) {
		return em.find(Course.class, id);
	}

	@Override
	public Course findCourseByTitle2(String title) {
		return em.createQuery("select c from Course c where c.title = :title", Course.class)
				.setParameter("title", title)
//				.getSingleResult();
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Course> findCourseByTitle(String title) {
		return em.createNamedQuery("Course.findByTitle", Course.class)
				.setParameter("title", "%"+title+"%")
				.getResultList();
	}

	@Override
	public List<Course> findAll() {
		return em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<OnsiteCourse> findAllOnsiteCourses() {
		return em.createNamedQuery("Course.findOnsiteCourses", OnsiteCourse.class)
                .getResultList();
	}

	
}
