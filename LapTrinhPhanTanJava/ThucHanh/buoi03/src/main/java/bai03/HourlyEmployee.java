package bai03;
/*
 * @ (#) HourlyEmployee.java       1.0     Sep 6, 2023
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
public class HourlyEmployee extends Employee{
	
	private int hoursWorked;
	private double hourlyWage;
	
	public HourlyEmployee(String id, String name, LocalDate dob, int hoursWorked, double hourlyWage) {
		super(id, name, dob);
		this.hoursWorked = hoursWorked;
		this.hourlyWage = hourlyWage;
	}
	
	public HourlyEmployee() {
		this("", "", LocalDate.now(),  0, 0.0);
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	@Override
	public double weeklyPay() {
		if(hoursWorked > 40)
			return (hoursWorked + (hoursWorked - 40) * 0.5) * hourlyWage;
		
		return hoursWorked * hourlyWage;
	}
	
	@Override
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("$ #,###.00");
		return super.toString() + String.format("Hours worked: %-15d\nHourly wage: %-15s\n", hoursWorked, df2.format(hourlyWage));
	}

}

