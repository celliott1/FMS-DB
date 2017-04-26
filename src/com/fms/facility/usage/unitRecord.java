package com.fms.facility.usage;

public class unitRecord {

	private int noiseComplaints;
	private int monthsLateRent;
	private int smokingComplaints;
	private double damageToUnit;
	
	public int getNoiseComplaints(){
		return noiseComplaints;
	}
	
	public void setNoiseComplaints(int noiseComplaints){
		this.noiseComplaints = noiseComplaints;
	}
	
	public int getMonthsLateRent(){
		return monthsLateRent;
	}
	
	public void setMonthsLateRent(int monthsLateRent){
		this.monthsLateRent = monthsLateRent;
	}
	
	public int getSmokingComplaints(){
		return smokingComplaints;
	}
	
	public void setSmokingComplaints(int smokingComplaints){
		this.smokingComplaints = smokingComplaints;
	}
	
	public double getDamageToUnit(){
		return damageToUnit;
	}
	
	public void setDamageToUnit(double damageToUnit){
		this.damageToUnit = damageToUnit;
	}
}
