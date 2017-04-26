package com.fms.facility.usage;

public class Person {
	private String firstName;
	private String lastName;
	private boolean primaryOccupant;
	public Person(String fn, String ln){
		this.firstName = fn;
		this.lastName = ln;
		this.primaryOccupant = false;
	}
	public String toString(){
		return lastName + "." + firstName + (primaryOccupant ? ".(primary occupant)" : "");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isPrimaryOccupant() {
		return primaryOccupant;
	}
	public void setPrimaryOccupant(boolean primaryOccupant) {
		this.primaryOccupant = primaryOccupant;
	}
}
