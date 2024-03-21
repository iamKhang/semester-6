package test;

import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import entity.Address;
import entity.Clazz;
import entity.ClazzProfile;
import entity.Course;
import entity.Enrollment;
import entity.Gender;
import entity.PartTimeStudent;
import entity.Student;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Testing {
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("JPA_ORM_Student MSSQL");
	}

	@Test
	void testAddStudent() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student student = new Student("S001", "John", "john@gmail.com", LocalDate.of(2000, 1, 1));
			entityManager.persist(student); // Create
		});
	}

	@Test
	void testAddStudent2Clazz() {
		doInJPA(this::entityManagerFactory, entityManager -> {
			Student st = entityManager.find(Student.class, "S001");
			Clazz clazz = new Clazz("DHKHMT17CTT", "Kỹ thuật khoa học máy tính 17C tiên tiến", 50);
			st.setClazz(clazz);

			entityManager.persist(clazz);
			entityManager.merge(st);

		});
	}

	@Test
	void testAddEnrollment() {
		doInJPA(this::entityManagerFactory, em -> {
			Student student = em.find(Student.class, "S001");
			Course course = new Course("AJava", "Advanced Java Programming", 4);
			Enrollment enrollment = new Enrollment(student, course, "Spring", 2024, 85);

			em.persist(course);
			em.persist(enrollment);
		});
	}
	
	@Test
	void testFindByID() {
		doInJPA(this::entityManagerFactory, em -> {
			Student student = em.find(Student.class, "S001");
			Course course = em.find(Course.class, "AJava");
			System.out.println(student);
			System.out.println(course);
		});
	}
	
	@Test
	void testSetPhone2Student() {
		doInJPA(this::entityManagerFactory, em -> {
			Student student = em.find(Student.class, "S001");
			Set<String> phones = new HashSet<>(List.of("0987654321", "0123456789"));
			student.setPhones(phones );
			em.merge(student);
		});
	}
	
	@Test
	void testCreateProfile2Clazz() {
		doInJPA(this::entityManagerFactory, em -> {
			Clazz clazz = em.find(Clazz.class, "DHKHMT17CTT");
			ClazzProfile profile = new ClazzProfile();
			profile.setClazz(clazz);
			profile.setCreateDate(LocalDate.now());
			profile.setDescription("This is a class for advanced students");
			em.persist(profile);
		});
	}
	
	@Test
	void testSetAddressAndGender2Student() {
		doInJPA(this::entityManagerFactory, em -> {
			Student student = em.find(Student.class, "S001");
			Address address = new Address("123 Texas", "Houston", "TX", 12000);
			student.setAddress(address);
			student.setGender(Gender.MALE);
			em.merge(student);
		});
	}
	
	@Test
	void testAddPartTimeStudent() {
		doInJPA(this::entityManagerFactory, em -> {
			PartTimeStudent student = new PartTimeStudent("S002", "Alice", "alice@gmail.com", LocalDate.of(2000, 1, 1), "John Smith");
			em.persist(student);
		});
	}
}
