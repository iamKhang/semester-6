package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 982405747041550874L;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String street;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String city;
	@Column(columnDefinition = "NVARCHAR(10)")
	private String state;
	@Column(name = "zip_code", columnDefinition = "NVARCHAR(5)")
	private String zipCode;
}
