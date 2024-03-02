package leHoangKhangJsonTK1;

import java.util.List;

public class Department {
	private String id;
	private String name;
	private List<Contact> contacts;

	public Department() {
		super();
	}

	public Department(String id, String name, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.contacts = contacts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", contacts=" + contacts + "]";
	}

}
