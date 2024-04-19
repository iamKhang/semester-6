package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
public class Customer extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	@Override
	public String toString() {
		return "Customer [address=" + address + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contact=" + contact + "]";
	}
	
	
}
