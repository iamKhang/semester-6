package dao;

import java.util.List;
import java.util.Map;

import entity.Food;
import entity.Item;

public interface ItemDao {
//	Câu 3: Hiện thực chương trình dựa trên mô hình client server (dùng kỹ thuật RMI), thiết lập một
//	server triển khai trên mạng LAN với các chức năng như sau (port là 4 số cuối MSSV, host là máy
//	SV làm bài):
//	a) (1.5 điểm) Thêm một món ăn mới. Trong đó, mã số của món phải bắt đầu là F và theo sau ít
//	nhất 3 ký số.
//	+ addFood (food: Food) : boolean
//	b) (1.5 điểm) Liệt kê danh sách mặt hàng là món đặt biệt của nhà hàng mà có sử dụng nguyên
//	liệu được nhập từ nhà cung cấp nào đó khi biết tên nhà cung cấp (tìm tương đối, không phân biệt
//	chữ thường hoa).
//	+ listItems (supplierName: String) : List<Item>
//	c) (1.5 điểm) Tính giá gốc của từng món ăn sau khi chế biết thành phẩm. Kết quả sắp xếp giảm
//	dần theo đơn giá gốc.
//	Trong đó: Giá gốc món ăn = (số lượng nguyên liệu * đơn giá nguyên liệu) + (thời gian chuẩn
//	bị + thời gian phục vụ) * 0.2$
//	+ public listFoodAndCost(): Map<Food, Double>
	
	public boolean addFood(Food food);

	public List<Item> listItems(String supplierName);

	public Map<Food, Double> listFoodAndCost();
}
