package com.fms.facility.usage;

import java.util.ArrayList;

import com.fms.facility.usage.*;
import com.fms.facility.maintenance.Maintenance;

public class Unit {
	private boolean occupied;
	private String name;
	private ArrayList<Person> occupants;
	private ArrayList<Maintenance> outstandingMaintenance;
	private ArrayList<Maintenance> previousMaintenance;
	private ArrayList<Utilities> utilities;
	private unitRecord ur;
	private unitRemodel urem;
	int counter = 0;
	public Unit(String name, boolean occupied){
		this.name = name;
		this.occupied = occupied;
		this.occupants = new ArrayList<Person>();
		this.outstandingMaintenance = new ArrayList<Maintenance>();
		this.previousMaintenance = new ArrayList<Maintenance>();
		this.utilities = new ArrayList<Utilities>();
	}
	public String toString(){
		String rtn = name + " occupied:[" + occupied + "]" 
				+ (occupants.size() > 0 ? ", Occupants: " : "");
		for(Person p : occupants){
			counter++;
			rtn += p.toString();
			if(counter == occupants.size()) break;
			rtn += ", ";
		}
		return rtn;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Person> getOccupants() {
		return occupants;
	}
	public void addOccupants(Person occupant) {
		this.occupants.add(occupant);
	}
	public ArrayList<Maintenance> getOutstandingMaintenance() {
		return outstandingMaintenance;
	}
	public void addOutstandingMaintenance(Maintenance outstandingMaintenance) {
		this.outstandingMaintenance.add(outstandingMaintenance);
	}
	public ArrayList<Maintenance> getPreviousMaintenance() {
		return previousMaintenance;
	}
	public void addPreviousMaintenance(Maintenance previousMaintenance) {
		this.previousMaintenance.add(previousMaintenance);
	}
	public ArrayList<Utilities> getUtilities(){
		return utilities;
	}
	public void addUtilities(Utilities utilities){
		this.utilities.add(utilities);
	}
	public void listUtilities(Utilities utilities){
		System.out.println("The total cost of utilities for this unit is: " + utilities.getTotalBill());
	}
	public unitRecord getUnitRecord(){
		return ur;
	}
	public void setUnitRecord(unitRecord ur){
		this.ur = ur;
	}
	public unitRemodel getUnitRemodel(){
		return urem;
	}
	public void setUnitRemodel(unitRemodel urem){
		this.urem = urem;
	}
}
