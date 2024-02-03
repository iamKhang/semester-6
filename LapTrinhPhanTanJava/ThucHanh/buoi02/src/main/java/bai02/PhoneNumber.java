package bai02;

public class PhoneNumber {
	private String type;
	private String number;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [type=" + type + ", number=" + number + "]";
	}
	
	

}
