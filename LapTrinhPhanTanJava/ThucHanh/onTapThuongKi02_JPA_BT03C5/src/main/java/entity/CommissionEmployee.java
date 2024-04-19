package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "commission_employees")
public class CommissionEmployee extends Employee{
	@Column(name = "commission_rate", nullable = false)
	private double commissionRate;
	@Column(name = "gross_sales", nullable = false)
	private double grossSales;
	
	public CommissionEmployee() {
		super();
	}
	
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate,
			double grossSales) {
		super(firstName, lastName, socialSecurityNumber);
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
	}
	
	@Override
	public double eanings() {
		// TODO Auto-generated method stub
		return 0;
	}

}
