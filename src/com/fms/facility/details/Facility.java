package com.fms.facility.details;

import java.util.ArrayList;

import com.fms.facility.maintenance.Inspection;
import com.fms.facility.usage.Person;
import com.fms.facility.usage.Unit;
import com.fms.facility.maintenance.Employee;
import com.fms.facility.details.Finances;
import com.fms.facility.details.*;

import java.lang.StringBuilder;

public class Facility{
	private int id;
	private ArrayList<Unit> units;
	private String name;
	private String description;
	private String address;
	// default to empty string "", empty string means there is no usage message.
	private String curUsage;
	private ArrayList<Inspection> inspections;
	private ArrayList<Employee> employees;
	private Finances finances;
	private improvementProjects improvement;
	private officeRoster roster;
	private serviceContracts service;
	
	public Facility(){
		units = new ArrayList<Unit>();
		inspections = new ArrayList<Inspection>();
		finances = new Finances();
		this.employees = new ArrayList<Employee>();
		this.curUsage = "";
	}
	public void addUnit(Unit unit){
		units.add(unit);
	}
	public void printUnits(){
		for(Unit u : units){
			System.out.println(u.toString());
		}
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Facility: " + name);
		sb.append("; Address: " + address);
		sb.append("; Description: " + description);
		sb.append("; Units: ");
		for(Unit u : units){
			sb.append("{" + u.toString() + "}");
		}
		return sb.toString();
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Unit> getUnits() {
		return units;
	}
	public String getCurUsage() {
		return curUsage;
	}
	public void setCurUsage(String curUsage) {
		this.curUsage = curUsage;
	}
	public Finances getFinances() {
		return finances;
	}
	public void setFinances(Finances finances) {
		this.finances = finances;
	}
	public ArrayList<Inspection> getInspections() {
		return inspections;
	}
	public void addInspection(Inspection inspection) {
		this.inspections.add(inspection);
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void addEmployees(Employee employee) {
		this.employees.add(employee);
	}
	public ArrayList<Employee> listEmployees(Facility f){
		if(true) {
			System.out.print("Listing employees for facility: ");
			if(f.getEmployees().size() == 0){
				System.out.print("There are no employees");
			}
			for(Employee e : f.getEmployees()){
				System.out.print(e.toString() + ",");
			}
		}
		System.out.println();
		return f.getEmployees();
	}
	public improvementProjects getImprovementProjects(){
		return improvement;
	}
	public void setImprovementProjects(improvementProjects improvement){
		this.improvement = improvement;
	}
	public  officeRoster getOfficeRoster(){
		return roster;
	}
	public void setOfficeRoster(officeRoster roster){
		this.roster = roster;
	}
	public serviceContracts getServiceContracts(){
		return service;
	}
	public void setServiceContracts(serviceContracts service){
		this.service = service;
	}
}
