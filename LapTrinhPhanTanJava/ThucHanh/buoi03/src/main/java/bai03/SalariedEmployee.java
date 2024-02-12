package bai03;
/*
 * @ (#) SalariedEmployee.java       1.0     Sep 6, 2023
 *
 * Copyright (c) 2023 IUH. All rights reserved.
 */



import java.text.DecimalFormat;
import java.time.LocalDate;

/*
 * @description: 
 * @author: Khanh Nguyen
 * @date:   Sep 6, 2023
 * @version:    1.0
 */
public class SalariedEmployee extends Employee{
	
	protected double annualSalary;

	public SalariedEmployee(String id, String name, LocalDate dob, double salary) {
		super(id, name, dob);
		this.annualSalary = salary;
	}
	
	public SalariedEmployee() {
		this("", "", LocalDate.now(), 0.0);
	}
	
	@Override
	public double weeklyPay() {
		final int WEEKS_PER_YEAR = 52;
		return annualSalary / WEEKS_PER_YEAR;
	}

	
	
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("$ #,###.00");
		return super.toString() + String.format("Annual salary: %-15s\n", df.format(annualSalary));
	}

}

