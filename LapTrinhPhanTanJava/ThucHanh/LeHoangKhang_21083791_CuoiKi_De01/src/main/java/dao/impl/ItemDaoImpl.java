package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ItemDao;
import entity.Food;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ItemDaoImpl implements ItemDao {

	EntityManager em;

	public ItemDaoImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("LeHoangKhang_21083791_CuoiKi_De01_SQLServer");
		em = emf.createEntityManager();
	}

	@Override
	/**
	 * Thêm một món ăn mới. Trong đó, mã số của món phải bắt đầu là F và theo sau ít
	 * nhất 3 ký số. + addFood (food: Food) : boolean
	 */
	public boolean addFood(Food food) {

//		Nếu mã số của món ăn không bắt đầu bằng F hoặc không có ít nhất 3 ký số return false
//		Sử dụng regex để kiểm tra
		if (!food.getId().matches("F\\d{3,}")) {
			return false;
		}
		try {
			em.getTransaction().begin();
			em.persist(food);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		}
	}

	/**
	 * b) (1.5 điểm) Liệt kê danh sách mặt hàng là món đặt biệt của nhà hàng mà có
	 * sử dụng nguyên liệu được nhập từ nhà cung cấp nào đó khi biết tên nhà cung
	 * cấp (tìm tương đối, không phân biệt chữ thường hoa)
	 */
	@Override
	public List<Item> listItems(String supplierName) {
		String query = "SELECT i " + "FROM Item i JOIN i.ingredients ig " + "WHERE ig.supplierName LIKE :supplierName";
		return em.createQuery(query, Item.class).setParameter("supplierName", "%" + supplierName + "%").getResultList();
	}

	/**
	 * c) (1.5 điểm) Tính giá gốc của từng món ăn sau khi chế biết thành phẩm. Kết
	 * quả sắp xếp giảm dần theo đơn giá gốc. Trong đó: Giá gốc món ăn = SUM(số
	 * lượng nguyên liệu * đơn giá nguyên liệu) + (thời gian chuẩn bị + thời gian
	 * phục vụ)* 0.2$
	 */
	@Override
	public Map<Food, Double> listFoodAndCost() {
		String query = "SELECT f, SUM(ig.price * ig.quantity) + (f.preparationTime + f.servingTime) * 0.2 "
				+ "FROM Food f JOIN f.ingredients ig " + "GROUP BY f "
				+ "ORDER BY f.price DESC";
		List<Object[]> list = em.createQuery(query, Object[].class).getResultList();
		Map<Food, Double> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Food) objects[0], (Double) objects[1]);
		}
		return map;
	}

}
