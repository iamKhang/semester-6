package entity;

import java.io.Serializable;

import enums.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "beverages")
public class Beverage extends Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4242289834177649873L;
	@Enumerated(EnumType.STRING)
	private Size size;
	@Column(name = "supplier_name")
	private String supplierName;

	public Beverage() {
		super();
	}

	public Beverage(String id, String name, double price, String description, boolean onSpecial, Size size,
			String supplierName) {
		super(id, name, price, description, onSpecial);
		this.size = size;
		this.supplierName = supplierName;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Beverage [size=" + size + ", supplierName=" + supplierName + ", id=" + id + ", name=" + name
				+ ", price=" + price + ", description=" + description + ", onSpecial=" + onSpecial + "]";
	}

}
