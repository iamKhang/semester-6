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
public class Customer {
//	private String id;
	private String customerID;
	private String address;
	private String city;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String country;
	private String fax;
	private String phone;
	private String postalCode;
	private String region;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(customerID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerID, other.customerID);
	}
	
	
}
