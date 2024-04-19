package dao.implement;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import dao.ProductDao;
import entity.Customer;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ProductImplt extends UnicastRemoteObject implements ProductDao {

	private EntityManager em;

	public ProductImplt() throws RemoteException{
		em = Persistence.createEntityManagerFactory("onTapThuongKi02_JPA_BT05C5")
				.createEntityManager();
	}

	@Override
	public boolean insertProduct(Product product) throws IOException{
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		
	}

	@Override
	public boolean updateProduct(Product product) throws IOException{
		try {
			em.getTransaction().begin();
			em.merge(product);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}



	@Override
	public Product getProductById(int id) throws IOException{
		Product product = em.find(Product.class, id);
		return product;
	}



	@Override
	public boolean deleteProduct(int id) throws IOException{
		try {
			em.getTransaction().begin();
			Product product = em.find(Product.class, id);
			em.remove(product);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<Product> getAllProduct() throws IOException{
		List<Product> list = em.createQuery("from Product", Product.class).getResultList();
		return list;
	}

	/**
	 * Lấy danh sách sản phẩm có giá cao nhất
	 */
	@Override
	public List<Product> getTopProductPrice() throws IOException{
		// Tìm giá cao nhất
		Double maxPrice = em.createQuery("SELECT MAX(p.listPrice) FROM Product p", Double.class).getSingleResult();
		System.out.println("Giá cao nhất: " + maxPrice);
		// Lấy danh sách các sản phẩm có giá bằng với giá cao nhất
		List<Product> products = em.createQuery("FROM Product p WHERE p.listPrice = :maxPrice", Product.class)
				.setParameter("maxPrice", maxPrice)
				.getResultList();
	
		return products;
	}

	/**
	 * Tìm danh sách sản phẩm chưa bán được lần nào
	 */
	@Override
	public List<Product> getNotSaleProduct() throws IOException{
		List<Product> products = em.createQuery("SELECT p FROM Product p WHERE p.items IS EMPTY", Product.class)
				.getResultList();
		return products;
	}

	@Override
	public Map<Product, Integer> getTotalProduct() throws IOException{
		String sql = "SELECT p, SUM(i.quantity) FROM Product p JOIN p.items i GROUP BY p";
		List<Object[]> results = em.createQuery(sql, Object[].class).getResultList();
		Map<Product, Integer> map = new LinkedHashMap<Product, Integer>();
		
		results.forEach(e -> map.put((Product) e[0], ((Long) e[1]).intValue()));
		return map;
	}

}
