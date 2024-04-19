package dao.implement;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.CustomerDao;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CustomerImplt extends UnicastRemoteObject implements CustomerDao{
	
	EntityManager em;
	
	public CustomerImplt() throws RemoteException{
		em = Persistence.createEntityManagerFactory("onTapThuongKi02_JPA_BT05C5").createEntityManager();
	}

	@Override
	public Map<String, Integer> getNumberCustomerByState() throws IOException{
	    String hql = "SELECT c.address.state, COUNT(c) FROM Customer c GROUP BY c.address.state";
	    @SuppressWarnings("unchecked")
	    List<Object[]> results = em.createQuery(hql).getResultList();
	    Map<String, Integer> resultMap = results.stream()
	        .collect(Collectors.toMap(e -> (String) e[0], e -> ((Long) e[1]).intValue()));
	    return resultMap;
	}

	@Override
	public Map<Customer, Integer> getOrdersByCustomers() throws IOException{
//		Sort by firstName, lastName
		String hql = "SELECT c, COUNT(o) "
				+ "FROM Customer c JOIN c.orders o "
				+ "GROUP BY c "
				+ "ORDER BY c.firstName, c.lastName";
		@SuppressWarnings("unchecked")
		List<Object[]> results = em.createQuery(hql).getResultList();
		Map<Customer, Integer> resultMap  = new LinkedHashMap<>();
		results.forEach(e -> resultMap.put((Customer) e[0], ((Long) e[1]).intValue()));
		return resultMap;
	}

	@Override
	public int deleteCustomerNotBuy() throws IOException{
		String hql = "DELETE FROM Customer c WHERE c.orders IS EMPTY";
		em.getTransaction().begin();
		int deletedCount = em.createQuery(hql).executeUpdate();
		em.getTransaction().commit();
		return deletedCount;
	}

}
