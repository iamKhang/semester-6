package entity;

import java.util.Objects;

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
public class Product {
	private String productID;
	private String productName;
	private Supplier supplier;
	private Category category;
	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;
	private int unitsOnOrder;
	private int reorderLevel;
	private boolean discontinued;
	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productID, other.productID);
	}
	
	
}
