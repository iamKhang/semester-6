package practiceTest1st;

import java.util.ArrayList;
import java.util.Objects;

public class Restaurant {
	private String restaurant_id;
	private boolean is_closed;
	private String name;
	private Address address;
	private String borough;
	private String cuisine;
	private ArrayList<Grade> grades;

	public Restaurant() {
		super();
	}

	public Restaurant(String restaurant_id, boolean is_closed, String name, Address address, String borough,
			String cuisine, ArrayList<Grade> grades) {
		super();
		this.restaurant_id = restaurant_id;
		this.is_closed = is_closed;
		this.name = name;
		this.address = address;
		this.borough = borough;
		this.cuisine = cuisine;
		this.grades = grades;
	}

	public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public boolean isIs_closed() {
		return is_closed;
	}

	public void setIs_closed(boolean is_closed) {
		this.is_closed = is_closed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", is_closed=" + is_closed + ", name=" + name
				+ ", address=" + address + ", borough=" + borough + ", cuisine=" + cuisine + ", grades=" + grades + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(restaurant_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(restaurant_id, other.restaurant_id);
	}

}
