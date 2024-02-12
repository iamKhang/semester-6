package bai03;
/*
 * @ (#) Employee.java       1.0     Sep 6, 2023
 *
 * Copyright (c) 2023 IUH. All rights reserved.
 */

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/*
 * @description: 
 * @author: Khanh Nguyen
 * @date:   Sep 6, 2023
 * @version:    1.0
 */
public abstract class Employee {
	
	protected String id;
	protected String name;	
	protected LocalDate dob;

	public Employee(String id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public Employee() {
		this("","", LocalDate.now());
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df2 = new DecimalFormat("$ #,###.00");
		return String.format("\nEmployee type: %-15s\nId: %-15s\nName: %-15s\nDate of birth: %-15s\nWeekly total salary: %-15s\n==Salary details==\n",
				this.getClass().getSimpleName(),id, name, dob.format(df1), df2.format(weeklyPay()));
	}
	
	public abstract double weeklyPay();

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
}

