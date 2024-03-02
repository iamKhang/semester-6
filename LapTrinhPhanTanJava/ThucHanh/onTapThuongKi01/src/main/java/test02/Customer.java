package test02;

import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private List<String> phoneNumbers;
	private boolean isAlive;
	private int age;
	private double height;
	private Address billAddress;
	private Address shippAddress;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String email, List<String> phoneNumbers, boolean isAlive,
			int age, double height, Address billAddress, Address shippAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.isAlive = isAlive;
		this.age = age;
		this.height = height;
		this.billAddress = billAddress;
		this.shippAddress = shippAddress;
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

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
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

	public Address getBillAddress() {
		return billAddress;
	}

	public void setBillAddress(Address billAddress) {
		this.billAddress = billAddress;
	}

	public Address getShippAddress() {
		return shippAddress;
	}

	public void setShippAddress(Address shippAddress) {
		this.shippAddress = shippAddress;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumbers="
				+ phoneNumbers + ", isAlive=" + isAlive + ", age=" + age + ", height=" + height + ", billAddress="
				+ billAddress + ", shippAddress=" + shippAddress + "]";
	}

}
