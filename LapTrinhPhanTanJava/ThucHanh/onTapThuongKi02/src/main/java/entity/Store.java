package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stores")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int id;
	@Column(name = "store_name")
	private String name;
	
	@Embedded
    private Contact contact;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "store")
	private List<Staff> staffs;
}
