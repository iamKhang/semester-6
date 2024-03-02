package test03;

import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private List<String> phoneNumber;
	private boolean isAlive;
	private int age;
	private double height;
	private Address billingAddress;
	private Address shippingAddress;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String email, List<String> phoneNumber, boolean isAlive, int age,
			double height, Address billingAddress, Address shippingAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isAlive = isAlive;
		this.age = age;
		this.height = height;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", isAlive=" + isAlive + ", age=" + age + ", height=" + height + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}

}
