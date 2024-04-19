package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "product_name", columnDefinition = "NVARCHAR(255)")
	private String name;
	
	@Column(name = "model_year", columnDefinition = "SMALLINT")
	private int modelYear;
	
	@Column(name = "list_price")
	private double listPrice;
	
	@OneToMany(mappedBy = "product")
	private List<OrderItem> items;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@OneToMany(mappedBy = "product")
	private List<Stock> stocks;

	public Product(String name, int modelYear, double listPrice) {
		super();
		this.name = name;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}



	public Product(int id, String name, int modelYear, double listPrice) {
		super();
		this.id = id;
		this.name = name;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", modelYear=" + modelYear + ", listPrice=" + listPrice + "]";
	}
	
	
	
	
}
