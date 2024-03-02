package test04;

import java.util.List;

public class Patient {
	private String id;
	private String firstName;
	private String lastName;
	private String bloodType;
	private String gender;
	private Address address;
	private List<String> phoneNumbers;
	private List<Test> tests;
	private int dateOfBirth;

	public Patient() {
		super();
	}

	public Patient(String id, String firstName, String lastName, String bloodType, String gender, Address address,
			List<String> phoneNumbers, List<Test> tests, int dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bloodType = bloodType;
		this.gender = gender;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.tests = tests;
		this.dateOfBirth = dateOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bloodType=" + bloodType
				+ ", gender=" + gender + ", address=" + address + ", phoneNumbers=" + phoneNumbers + ", tests=" + tests
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
