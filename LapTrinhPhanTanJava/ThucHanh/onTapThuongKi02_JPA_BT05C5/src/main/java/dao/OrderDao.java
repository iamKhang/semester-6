package dao;

import java.io.IOException;
import java.rmi.Remote;
import java.time.LocalDate;

public interface OrderDao extends Remote{
//	5) Tính tổng tiền của đơn hàng khi biết mã số đơn hàng.
	public double getTotalPriceByOrderID(int orderID) throws IOException;
//	Tính tổng tiền của tất cả các hóa đơn trong một ngày nào đó
	public double getTotalPriceByDate(LocalDate date) throws IOException;
//	Thống kê tổng tiền hóa đơn theo tháng / năm.
	public double getTotalPriceByMonth(int month, int year) throws IOException;
}
