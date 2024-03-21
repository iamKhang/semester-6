package entity;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private String shipCity;
	private String orderID;
	private String freight;
	private Date requiredDate;
	private Date orderDate;
	private String shipCountry;
	private String shipName;
	private String shipAddress;
	private String shipPostalCode;
	private String shipRegion;
	private String shipVia;
	private String employeeID;
	private String customerID;
	
}
