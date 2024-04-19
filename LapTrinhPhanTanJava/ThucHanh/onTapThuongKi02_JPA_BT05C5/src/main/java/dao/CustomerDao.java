package dao;

import java.io.IOException;
import java.rmi.Remote;
import java.util.Map;

import entity.Customer;

public interface CustomerDao extends Remote{
//	Thống kê số khách hàng theo từng bang
	public Map<String, Integer> getNumberCustomerByState() throws IOException;
//	Đếm số đơn hàng của từng khách hàng
	public Map<Customer, Integer> getOrdersByCustomers() throws IOException;
//	Xóa tất cả các khách hàng chưa mua hàng.
	public int deleteCustomerNotBuy() throws IOException;
}
