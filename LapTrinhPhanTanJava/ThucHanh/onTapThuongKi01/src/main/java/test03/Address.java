package test03;

public class Address {
	private String address;
	private String city;
	private String state;
	private int postalCode;

	public Address() {
		super();
	}

	public Address(String address, String city, String state, int postalCode) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ "]";
	}

}
