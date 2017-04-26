package com.fms.facility.usage;

public class tenantCosts{
	private double rentCost;
	private double petCost;
	private double parkingCost;
	private double lockoutCost;
	
	public double getRentCost(){
		return rentCost;
	}
	public void setRentCost(double rentCost){
		this.rentCost = rentCost;
	}
	public double getPetCost(){
		return petCost;
	}
	public void setPetCost(double petCost){
		this.petCost = petCost;
	}
	public double getParkingCost(){
		return parkingCost;
	}
	public void setParkingCost(double parkingCost){
		this.parkingCost = parkingCost;
	}
	public double getLockoutCost(){
		return lockoutCost;
	}
	public void setLockoutCost(double lockoutCost){
		this.lockoutCost = lockoutCost;
	}
}