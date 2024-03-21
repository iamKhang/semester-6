package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "ogm-mongodb";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Thêm 10 khách hàng vào cơ sở dữ liệu
            for (int i = 1; i <= 10; i++) {
                Customer customer = new Customer();
                customer.setName("Customer " + i);
                customer.setEmail("customer" + i + "@example.com");
                entityManager.persist(customer);
            }

            entityManager.getTransaction().commit();
            System.out.println("Đã thêm 10 khách hàng vào cơ sở dữ liệu thành công.");
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
