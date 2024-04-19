package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private double quantity;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
}
