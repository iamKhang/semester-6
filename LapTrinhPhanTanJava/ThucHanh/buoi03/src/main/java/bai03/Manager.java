package bai03;
/*
 * @ (#) Manager.java       1.0     Sep 6, 2023
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
public class Manager extends SalariedEmployee{
	
	private double weeklyBonus;
	
	public Manager(String id, String name, LocalDate dob, double salary, double weeklyBonus) {
		super(id, name, dob, salary);
		this.weeklyBonus = weeklyBonus;
	}

	public Manager() {
		this("", "", LocalDate.now(), 0.0, 0.0);
	}

	public double getWeeklyBonus() {
		return weeklyBonus;
	}

	public void setWeeklyBonus(double weeklyBonus) {
		this.weeklyBonus = weeklyBonus;
	}
	
	
	@Override
	public double weeklyPay() {
		return super.weeklyPay() + weeklyBonus;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("$ #,###.00");
		return super.toString() + String.format("Weekly bonus: %-15s\n", df.format(weeklyBonus));
	}
}

