package test04;

public class Address {
	private String street;
	private String city;
	private String district;
	private String ward;

	public Address() {
		super();
	}

	public Address(String street, String city, String district, String ward) {
		super();
		this.street = street;
		this.city = city;
		this.district = district;
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", district=" + district + ", ward=" + ward + "]";
	}

}
