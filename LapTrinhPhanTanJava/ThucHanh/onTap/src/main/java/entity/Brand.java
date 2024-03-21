package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand implements Serializable {
	
	@Id
	private String id;
	@Column(name = "brand_name")
	private String name;
	
	public Brand() {
		super();
	}
	
	public Brand(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String brandName) {
		this.name = brandName;
	}
}
