package practiceTest1st;

import java.util.Arrays;

public class Address {
	private String building;
	private double[] coord;
	private String street;
	private String zipcode;

	public Address() {
		super();
	}

	public Address(String building, double[] coord, String street, String zipcode) {
		super();
		this.building = building;
		this.coord = coord;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public double[] getCoord() {
		return coord;
	}

	public void setCoord(double[] coord) {
		this.coord = coord;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [building=" + building + ", coord=" + Arrays.toString(coord) + ", street=" + street
				+ ", zipcode=" + zipcode + "]";
	}

}
