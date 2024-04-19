package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("onTapThuongKi02_JPA_BT03C5");
        EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
