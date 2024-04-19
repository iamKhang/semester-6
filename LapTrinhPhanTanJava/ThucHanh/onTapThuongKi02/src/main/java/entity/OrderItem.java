package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	private int quantity;
	private double listPrice;
	private double discount;

}
