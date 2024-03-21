package test;

import java.time.LocalDate;

import entity.PartTimeStudent;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_ORM_Student MSSQL");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Student student = new Student("S001", "John", "john@gmail.com", LocalDate.of(2000, 1, 1));
//			em.persist(student);

			Student student2 = new PartTimeStudent("S004", "Alice", "alice@gmail.com", LocalDate.of(2000, 1, 1),
					"John Smith");
			em.persist(student2);
			
			
			student = em.find(Student.class, "S001");
			student2 = em.find(Student.class, "S004");
			System.out.println(student2);
			
			student2.setManager(student);
			
			em.merge(student2);
			

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
