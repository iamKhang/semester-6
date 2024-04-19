package entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	@Column(name = "order_status")
	private boolean orderStatus;
	@Column(name = "order_date")
	private LocalDate orderDate;
	@Column(name = "require_date")
	private LocalDate requireDate;
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> items;
}
