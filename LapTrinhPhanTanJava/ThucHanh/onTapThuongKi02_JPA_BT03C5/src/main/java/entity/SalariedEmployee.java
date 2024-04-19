package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "salaried_employees")
public class SalariedEmployee extends Employee{
	@Column(name = "weekly_salary", nullable = false)
	private double weeklySalary;
	
	public SalariedEmployee() {
		super();
	}
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double eanings() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
