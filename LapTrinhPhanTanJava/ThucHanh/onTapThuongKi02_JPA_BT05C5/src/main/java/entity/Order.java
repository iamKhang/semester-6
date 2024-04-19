package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@Column(name = "order_status")
	private byte orderStatus;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "required_date")
	private LocalDate requiredDate;
	
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
