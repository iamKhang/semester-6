package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "base_plus_commission_employees")
public class BasePlusCommissionEmployee extends CommissionEmployee{
	@Column(name = "base_salary", nullable = false)	
	private double baseSalary;

	public BasePlusCommissionEmployee() {
		super();
	}

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
			double commissionRate, double grossSales, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, commissionRate, grossSales);
		this.baseSalary = baseSalary;
	}

	@Override
	public double eanings() {
		// TODO Auto-generated method stub
		return 0;
	}

}
