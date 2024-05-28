package server;

import java.util.List;
import java.util.Map;

import dao.ItemDao;
import dao.impl.ItemDaoImpl;
import entity.Food;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeHoangKhang_21083791_CuoiKi_De01_SQLServer");
		ItemDao itemDao = new ItemDaoImpl();
		
//		Map<Food, Double> map = itemDao.listFoodAndCost();
//		for (Food f : map.keySet()) {
//			System.out.println(f.getName() + " " + map.get(f));
//		}
		
		List<Item> items = itemDao.listItems("Dan's Seafood");
		items.forEach(i -> System.out.println(i.getName()));
	}
}
