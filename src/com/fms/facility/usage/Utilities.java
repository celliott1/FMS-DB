package com.fms.facility.usage;

public class Utilities{
	private double electricBill;
	private double gasBill;
	private double trashBill;
	private double internetBill;
	private double cableBill;
	private double totalBill;
	
	public double getElectricBill(){
		return electricBill;
	}
	public void setElectricBill(double electricBill){
		this.electricBill = electricBill;
	}
	public double getGasBill(){
		return gasBill;
	}
	public void setGasBill(double gasBill){
		this.gasBill = gasBill;
	}
	public double getTrashBill(){
		return trashBill;
	}
	public void setTrashBill(double trashBill){
		this.trashBill = trashBill;
	}
	public double getInternetBill(){
		return internetBill;
	}
	public void setInternetBill(double internetBill){
		this.internetBill = internetBill;
	}
	public double getCableBill(){
		return cableBill;
	}
	public void setCableBill(double cableBill){
		this.cableBill = cableBill;
	}
	public double getTotalBill(){
		return (electricBill + gasBill + trashBill + internetBill + cableBill);
	}
}
