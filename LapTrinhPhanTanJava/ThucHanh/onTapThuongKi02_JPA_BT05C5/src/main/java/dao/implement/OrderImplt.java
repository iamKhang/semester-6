package dao.implement;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import dao.OrderDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class OrderImplt extends UnicastRemoteObject implements OrderDao {

	EntityManager em;

	public OrderImplt() throws RemoteException{
		em = Persistence.createEntityManagerFactory("onTapThuongKi02_JPA_BT05C5").createEntityManager();
	}

	@Override
	public double getTotalPriceByOrderID(int orderID) throws IOException{

		String query = "SELECT SUM(oi.quantity * oi.listPrice * (1-oi.discount)) " + "FROM OrderItem oi "
				+ "WHERE oi.order.id = :orderID";

		return (double) em.createQuery(query).setParameter("orderID", orderID).getSingleResult();
	}

	@Override
	public double getTotalPriceByDate(LocalDate date) throws IOException{
	    String hql = "SELECT SUM(i.quantity * i.listPrice * (1 - i.discount)) "
	        + "FROM Order o JOIN o.items i "
	        + "WHERE o.orderDate = :date";
	    Double result = em.createQuery(hql, Double.class)
	        .setParameter("date", date)
	        .getSingleResult();
	    return result != null ? result : 0.0;
	}

	@Override
	public double getTotalPriceByMonth(int month, int year) throws IOException{
		String hql = "SELECT SUM(i.quantity * i.listPrice * (1 - i.discount)) " 
				+ "FROM Order o JOIN o.items i "
				+ "WHERE MONTH(o.orderDate) = :month AND YEAR(o.orderDate) = :year";
		Double result = em.createQuery(hql, Double.class).setParameter("month", month).setParameter("year", year)
				.getSingleResult();
		return result != null ? result : 0.0;
	}

}
