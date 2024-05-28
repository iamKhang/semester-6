package server;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Server {
	public static void main(String[] args) {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("onTapCuoiKi_JPAWithSocket_DeMau04_Map_SQLServer");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
	}
}
