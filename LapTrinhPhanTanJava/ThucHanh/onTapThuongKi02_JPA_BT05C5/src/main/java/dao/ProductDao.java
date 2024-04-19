package dao;

import java.io.IOException;
import java.rmi.Remote;
import java.util.List;
import java.util.Map;

import entity.Product;

public interface ProductDao extends Remote{
	public boolean insertProduct(Product product) throws IOException;
	public boolean updateProduct(Product product) throws IOException;
	public boolean deleteProduct(int id) throws IOException;
	public Product getProductById(int id) throws IOException;
	public List<Product> getAllProduct() throws IOException;
//	Lấy danh sách sản phẩm có giá cao nhất
    public List<Product> getTopProductPrice() throws IOException;	
//  Tìm danh sách sản phẩm chưa bán được lần nào
    public List<Product> getNotSaleProduct() throws IOException;
    public Map<Product, Integer> getTotalProduct() throws IOException;
    
}
