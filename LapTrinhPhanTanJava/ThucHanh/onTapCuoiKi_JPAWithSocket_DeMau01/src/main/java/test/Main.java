package test;

import dao.FoodDao;

public class Main {
	public static void main(String[] args) {
//        Test Hibernate
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("onTapCuoiKi_JPAWithSocket_BT4C5");
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
//		em.close();
//	    System.out.println("Done");
		
		FoodDao foodDao = new FoodDao();
//		List<Item> items = foodDao.listItems("Hank's Beverages");
//		for (Item item : items) {
//			System.out.println(item);
//		}
		
		foodDao.listFoodAndCost();
	    
	}
}
