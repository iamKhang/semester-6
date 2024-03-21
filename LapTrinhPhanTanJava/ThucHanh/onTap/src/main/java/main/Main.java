package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Brand;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("onTap mongodb");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tr = em.getTransaction();
		try {
//			tr.begin();
//			Student student = new Student("S001", "John", "john@gmail.com", LocalDate.of(2000, 1, 1));
////			em.persist(student);
//
//			Student student2 = new PartTimeStudent("S004", "Alice", "alice@gmail.com", LocalDate.of(2000, 1, 1),
//					"John Smith");
//			em.persist(student2);
//			
//			
//			student = em.find(Student.class, "S001");
//			student2 = em.find(Student.class, "S004");
//			System.out.println(student2);
//			
//			student2.setManager(student);
//			
//			em.merge(student2);
			tr.begin();
			Brand brand = new Brand("B001", "Apple");
			em.persist(brand);
			

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		 
	}

}
