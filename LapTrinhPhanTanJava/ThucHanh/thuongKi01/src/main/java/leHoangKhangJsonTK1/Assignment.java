package leHoangKhangJsonTK1;

public class Assignment {
	private int hours;
	private String employeeId;

	public Assignment() {
		super();
	}

	public Assignment(int hours, String employeeId) {
		super();
		this.hours = hours;
		this.employeeId = employeeId;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Assignment [hours=" + hours + ", employeeId=" + employeeId + "]";
	}

}
