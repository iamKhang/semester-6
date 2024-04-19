package entity;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "staff_id"))
@Table(name = "staffs")
public class Staff extends Person{
	private boolean active;
	
	
	@OneToMany(mappedBy = "manager")
	private List<Staff> staffs;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	@OneToMany(mappedBy = "staff")
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
}
