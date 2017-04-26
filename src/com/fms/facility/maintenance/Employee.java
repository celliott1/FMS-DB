package com.fms.facility.maintenance;

public class Employee{
	private String firstName;
	private String lastName;
	private String assignedTask;
	private String phoneNumber;
	private double salary;
	private int tenure; 
	
	public Employee(String fn, String ln){
		this.firstName = fn;
		this.lastName = ln;
	}
	public String toString(){
		return lastName + "." + firstName;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getAssignedTask(){
		return assignedTask;
	}
	public void setAssignedTask(String assignedTask){
		this.assignedTask = assignedTask;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public int getTenure(){
		return tenure;
	}
	public void setTenure(int tenure){
		this.tenure = tenure;
	}
}
