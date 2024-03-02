package leHoangKhangJsonTK1;

import java.time.LocalDate;
import java.util.List;

public class Project {
	private String id;
	private String location;
	private double budget;
	private String peojectName;
	private LocalDate startDate;
	private Department department;
	private List<Assignment> assignments;

	public Project() {
		super();
	}

	public Project(String id, String location, double budget, String peojectName, LocalDate startDate,
			Department department, List<Assignment> assignments) {
		super();
		this.id = id;
		this.location = location;
		this.budget = budget;
		this.peojectName = peojectName;
		this.startDate = startDate;
		this.department = department;
		this.assignments = assignments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getPeojectName() {
		return peojectName;
	}

	public void setPeojectName(String peojectName) {
		this.peojectName = peojectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", location=" + location + ", budget=" + budget + ", peojectName=" + peojectName
				+ ", startDate=" + startDate + ", department=" + department + ", assignments=" + assignments + "]";
	}

}
