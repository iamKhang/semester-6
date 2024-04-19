package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "staffs")
@AttributeOverride(name = "id", column = @Column(name = "staff_id"))
public class Staff extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "TINYINT")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	@OneToMany(mappedBy = "manager")
	private Set<Staff> staffs;
	
	@OneToMany(mappedBy = "staff")
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	public Staff() {
		super();
	}	
	
}
