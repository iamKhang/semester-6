package entity;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@SerializedName("productID")
	private String productId;
	private String productName;
	private double unitPrice;
	private String quantityPerUnit;
	@SerializedName("supplierID")
	private String supplierId;
	@SerializedName("categoryID")
	private String categoryId;
	private int reOrderLevel;
	private int unitsInStock;
	
	
	

}
