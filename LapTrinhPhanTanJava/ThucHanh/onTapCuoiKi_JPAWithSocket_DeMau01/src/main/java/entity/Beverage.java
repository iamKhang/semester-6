package entity;

import java.util.Set;

import enums.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "beverages")
public class Beverage extends Item {
	@Enumerated(EnumType.STRING)
	private Size size;
	@Column(name = "supplier_name")
	private String supplierName;
	public Beverage() {
		super();
	}
	public Beverage(String id, String name, double price, String description, boolean onSpecial,
			Set<Ingredient> ingredients, Size size, String supplierName) {
		super(id, name, price, description, onSpecial, ingredients);
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
