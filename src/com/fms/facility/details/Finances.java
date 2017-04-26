package com.fms.facility.details;

public class Finances {
	private double facilityProfit;
	private double propertyTax;
	private double payroll;
	private double expenses;
	private double insurance;
	
	public double getFacilityProfit(){
		return facilityProfit;
	}
	public void setFacilityProfit(double facilityProfit){
		this.facilityProfit = facilityProfit;
	}
	public double getPropertyTax(){
		return propertyTax;
	}
	public void setPropertyTax(double propertyTax){
		this.propertyTax = propertyTax;
	}
	public double getPayroll(){
		return payroll;
	}
	public void setPayroll(double payroll){
		this.payroll = payroll;
	}
	public double getExpenses(){
		return expenses;
	}
	public void setExpenses(double expenses){
		this.expenses = expenses;
	}
	public double getInsurance(){
		return insurance;
	}
	public void setInsurance(double insurance){
		this.insurance = insurance;
	}
}