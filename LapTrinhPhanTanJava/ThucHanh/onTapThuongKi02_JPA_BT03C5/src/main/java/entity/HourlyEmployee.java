package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hourly_employees")
public class HourlyEmployee extends Employee{
	
	private double hours;
	private double wage;
	
	public HourlyEmployee() {
		super();
	}
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage) {
		super(firstName, lastName, socialSecurityNumber);
		this.hours = hours;
		this.wage = wage;
	}

	@Override
	public double eanings() {
		// TODO Auto-generated method stub
		return 0;
	}

}
