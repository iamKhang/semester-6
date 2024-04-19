package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("onTapThuongKi02");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
	}
}
