package entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class Address {
	private String street;
	private String city;
	private String state;
	private int postalCode;
	
}
