package dao;

import entity.Food;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDao {

	EntityManager em;

	public FoodDao() {
		em = Persistence.createEntityManagerFactory("onTapCuoiKi_JPAWithSocket_BT4C5").createEntityManager();
	}

	// add food, return true if success, false if failed
	public boolean addFood(Food food) {
		try {
			em.getTransaction().begin();
			em.persist(food);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	// b) (1.5 điểm) Liệt kê danh sách mặt hàng là món đặt biệt của nhà hàng mà có
	// sử dụng nguyên
	// liệu được nhập từ nhà cung cấp nào đó khi biết tên nhà cung cấp (tìm tương
	// đối, không phân biệt
	// chữ thường hoa).
	// + listItems (supplierName: String) : List<Item>

	public List<Item> listItems(String supplierName) {
		String query = "SELECT i " + "FROM Item i JOIN i.ingredients ig "
				+ "WHERE ig.supplierName LIKE :supplierName AND i.onSpecial = true";
		return em.createQuery(query, Item.class).setParameter("supplierName", "%" + supplierName + "%").getResultList();
	}

	// c) (1.5 điểm) Tính giá gốc của từng món ăn sau khi chế biết thành phẩm. Kết
	// quả sắp xếp giảm
	// dần theo đơn giá gốc.
	// Trong đó: Giá gốc món ăn = sum((số lượng nguyên liệu * đơn giá nguyên liệu) +
	// (thời gian chuẩn
	// bị + thời gian phục vụ) * 0.2$)
	// + public listFoodAndCost(): Map<Food, Double>

	// Native query
//	 SELECT i.id,
//	 SUM(ig.price * ig.quantity) + (f.preparation_time + f.serving_time) * 0.2 AS
//	 original_price
//	 FROM items i
//	 JOIN foods f ON i.id = f.id
//	 JOIN items_ingredients ii ON i.id = ii.item_id
//	 JOIN ingredients ig ON ii.ingredient_id = ig.ingredient_id
//	 GROUP BY i.id, f.preparation_time, f.serving_time
//	 ORDER BY original_price DESC

	public Map<Food, Double> listFoodAndCost() {
	    // HQL query để tính giá gốc và sắp xếp giảm dần
	    String hql = "SELECT f, " + "(SUM(i.price * i.quantity) + (f.preparationTime + f.servingTime) * 0.2) AS cost "
	            + "FROM Food f " + "JOIN f.ingredients i "
	            + "GROUP BY f.id, f.name, f.price, f.description, f.onSpecial, f.preparationTime, f.servingTime, i.id "
	            + "ORDER BY cost DESC";

	    TypedQuery<Object[]> query = em.createQuery(hql, Object[].class);
	    List<Object[]> results = query.getResultList();

	    Map<Food, Double> foodCostMap = new HashMap<>();
	    for (Object[] result : results) {
	        Food food = (Food) result[0];
	        Double cost = (Double) result[1];
	        foodCostMap.put(food, cost);
	    }

	    return foodCostMap;
	}
}
