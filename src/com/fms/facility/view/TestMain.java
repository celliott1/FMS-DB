package com.fms.facility.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.fms.facility.usage.*;
import com.fms.facility.details.*;
import com.fms.facility.maintenance.*;

public class TestMain {
	public static void main(String [] args){
		// creating a FacilityClient
		FacilityClient fc = new FacilityClient();
		
		// creating a facility f1
		Facility f1 = new Facility();
		f1.setAddress("3423 N. Rondo Ave. Chicago IL 60660");
		f1.setDescription("Apartment Complex");
		f1.setName("The Hilton Rise");
		
		Unit u1 = new Unit("Room 101", true);
		u1.addOccupants(new Person("Chris", "Elliott"));
		Person p2 = new Person("Neil", "Christensen");
		p2.setPrimaryOccupant(true);
		u1.addOccupants(p2);
		Unit u2 = new Unit("Room 102", false);
		Unit u3 = new Unit("Room 103", false);
		f1.setId(1);
		f1.addUnit(u1);
		f1.addUnit(u2);
		f1.addUnit(u3);
		// --- end of creating a facility f1
		
		// creating a facility f2
		Facility f2 = new Facility();
		f2.setAddress("1040 W. Granville Ave. Chicago IL 60626");
		f2.setDescription("Hotel Building");
		f2.setName("The Sovereign");
		
		Unit u4 = new Unit("Room 101", false);
		Unit u5 = new Unit("Room 102", false);
		Unit u6 = new Unit("Room 103", false);
		f2.addUnit(u4);
		f2.addUnit(u5);
		f2.addUnit(u6);
		// --- end of creating a facility f2

		// --------------- Facility related testing
		fc.addNewFacility(f1);
		fc.getFacilityInformation(f1);
		
		// removing facility with id 1, i.e. f1
		fc.listFacilities();
		fc.removeFacility(1);
		fc.listFacilities();
		
		// add f1 and f2 back
		fc.addNewFacility(f1);
		fc.addNewFacility(f2);
		fc.listFacilities();
		
		// --------------- Facility Use related testing
		boolean inUse = fc.isInUseDuringInterval(f1);
		System.out.println("f1 is " + (inUse ? "in use" : "not in use"));
		System.out.println();
		boolean inUse2 = fc.isInUseDuringInterval(f2);
		System.out.println("f2 is " + (inUse2 ? "in use" : "not in use"));
		System.out.println();
		fc.assignFacilityToUse(f2, "Hotel building currently renting units.");
		System.out.println("Printing the usage of f2 : " + f2.getCurUsage());
		System.out.println();
		fc.listInspections(f1);
		System.out.println();
		
		Inspection ins = new Inspection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		try {
			ins.setDate(sdf.parse("01/26/1990"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ins.setDescription("Fire inspection");
		// end of creating a inspection
		f1.addInspection(ins);
		fc.listInspections(f1);
		fc.listActualUsage(f2);
		fc.calcUsageRate(f2);
		
		// ------------ maintenance related testing
		Maintenance m1 = new Maintenance(1);
		m1.setCosts(66);
		m1.setDescription("Toilet leaking");
		fc.makeFacilityMaintRequest(u1, m1);
		try {
			fc.scheduleMaintenance(m1, sdf.parse("1/10/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fc.calcMaintenanceCostForFacility(f1);
		Maintenance m2 = new Maintenance(2);
		m2.setCosts(33);
		m2.setDescription("Heating problem");
		m2.setRepairDays(1);
		fc.makeFacilityMaintRequest(u2, m2);
		try {
			fc.scheduleMaintenance(m2, sdf.parse("2/23/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Maintenance m3 = new Maintenance(3);
		m3.setDescription("AC problem");
		fc.makeFacilityMaintRequest(u2, m3);
		fc.listMaintenance(u3);
		fc.listMaintRequests(u2);
		fc.listFacilityProblems(f2);
		
		equipmentExpenses eq = new equipmentExpenses();
		eq.setToolPurchases(48.00);
		System.out.println("The total cost of the tools is: " + eq.getToolPurchases());
		System.out.println();
		eq.setToolRepair(20.00);
		System.out.println("The total cost of the tool repairs is: " + eq.getToolRepair());
		System.out.println();
		eq.setUniformCosts(600.00);
		System.out.println("The total cost of the uniforms is: " + eq.getUniformCosts());
		System.out.println();
		
		successRate sr = new successRate();
		sr.setInjuries("Sprained ankle from ladder fall");
		sr.setSatisfactoryCompletion("Customer enjoys new blue paint coating in unit");
		sr.setUnsatisfactoryCompletion("Customer dislikes the new unit's bathroom wallpaper");
		System.out.println("Maintenance injury: " + sr.getInjuries());
		System.out.println();
		System.out.println("Maintenance satisfaction: " + sr.getSatisfactoryCompletion());
		System.out.println();
		System.out.println("Maintenance unsatisfaction: " + sr.getUnsatisfactoryCompletion());
		System.out.println();




		
		Finances fin = new Finances();
		fin.setExpenses(150000);
		fin.setFacilityProfit(500000);
		fin.setPayroll(200000);
		fin.setPropertyTax(3000);
		fin.setInsurance(100000);
		f1.setFinances(fin);
		System.out.println("Facility expense is " + fin.getExpenses() + " dollars");
		System.out.println("Facility profit is " + fin.getFacilityProfit() + " dollars");
		System.out.println("Facility payroll is " + fin.getPayroll() + " dollars");
		System.out.println("Facility property tax is " + fin.getPropertyTax() + " dollars");
		System.out.println("Facility insurance is " + fin.getInsurance() + " dollars");
		System.out.println();
		
		Utilities ut = new Utilities();
		ut.setCableBill(25.50);
		ut.setElectricBill(35.00);
		ut.setGasBill(20.25);
		ut.setInternetBill(60.75);
		ut.setTrashBill(19.99);
		u1.addUtilities(ut);
		u1.listUtilities(ut);
		System.out.println();
		
		tenantCosts tc = new tenantCosts();
		System.out.println("The tenants monthly costs, excluding utilities, are as follows: ");
        tc.setLockoutCost(50.00);
		tc.setParkingCost(80.00);
		tc.setPetCost(30.00);
		tc.setRentCost(950.00);
		
		System.out.println("Lockout cost - " + tc.getLockoutCost() + " dollars");
		System.out.println("Parking cost - " + tc.getParkingCost() + " dollars");
		System.out.println("Pet cost - " + tc.getPetCost() + " dollars");
		System.out.println("Rent cost - " + tc.getRentCost() + " dollars");
		System.out.println();
		
		Employee employee = new Employee("James", "George");
		System.out.println("Employee details for: " + employee.toString());
		employee.setPhoneNumber("773-244-3214");
		employee.setAssignedTask("Unclogging toilet for room 101");
		employee.setSalary(40000);
		employee.setTenure(4);
		System.out.println("Phone number: " + employee.getPhoneNumber());
		System.out.println("Assigned Task: " + employee.getAssignedTask());
		System.out.println("Salary: " + employee.getSalary() + " dollars");
		System.out.println("Tenure: " + employee.getTenure() + " years");
		f1.addEmployees(employee);
		f1.listEmployees(f1);
		System.out.println();
		
		improvementProjects projects = new improvementProjects();
		projects.setAddingToFacility("Building a new pool site at this facility");
		projects.setNewTechnology("Adding 20 new computers to the lounge room");
		projects.setRemodelingInProgress("Replacing the carpet in the lobby");
		f1.setImprovementProjects(projects);
		System.out.println("Facility Addition: " + projects.getAddingToFacility());
		System.out.println();
		System.out.println("New Technology: " + projects.getNewTechnology());
		System.out.println();
		System.out.println("Current Remodeling: " + projects.getRemodelingInProgress());
		System.out.println();

		officeRoster roster = new officeRoster();
		roster.setDoorman1("Anthony Billops");
		roster.setDoorman2("Jacob Towns");
		roster.setFacilityManager("Benjamin Franklin");
		roster.setLeasingAgent1("Jimmy Fenders");
		roster.setLeasingAgent2("Samantha Simmons");
		roster.setSrLeasingAgent("Jennifer Bettinger");
		f1.setOfficeRoster(roster);
		System.out.println("Doorman 1: " + roster.getDoorman1());
		System.out.println();
		System.out.println("Doorman 2: " + roster.getDoorman2());
		System.out.println();
		System.out.println("Facility Manager: " + roster.getFacilityManager());
		System.out.println();
		System.out.println("Leasing Agent 1: " + roster.getLeasingAgent1());
		System.out.println();
		System.out.println("Leasing Agent 2: " + roster.getLeasingAgent2());
		System.out.println();
		System.out.println("Senior Leasing Agent: " + roster.getSrLeasingAgent());
		
		serviceContracts service = new serviceContracts();
		service.setParkingCompany("Red Vans");
		service.setSecurityCompany("Norton");
		service.setStaffingCompany("Staffer Delight");
		service.setWebDesignCompany("Digital Vibrancy");
		service.setJanitorialServices("Crystal Clear");
		f1.setServiceContracts(service);
		System.out.println("Parking Company: " + service.getParkingCompany());
		System.out.println();
		System.out.println("Security Company: " + service.getSecurityCompany());
		System.out.println();
		System.out.println("Staffing Company : " + service.getStaffingCompany());
		System.out.println();
		System.out.println("Web Design Company : " + service.getWebDesignCompany());
		System.out.println();
		System.out.println("Janitorial Company : " + service.getJanitorialServices());
		System.out.println();

		unitRecord ur = new unitRecord();
		ur.setMonthsLateRent(4);
		ur.setDamageToUnit(245.00);
		ur.setNoiseComplaints(7);
		ur.setSmokingComplaints(3);
		u1.setUnitRecord(ur);
		System.out.println("This unit has had " + ur.getMonthsLateRent()+ " months of late rent");
		System.out.println();
		System.out.println("This unit has had " + ur.getDamageToUnit() + " dollars of damage from tenant");
		System.out.println();
		System.out.println("This unit has had " + ur.getNoiseComplaints() + " noise complaints");
		System.out.println();
		System.out.println("This unit has had " + ur.getSmokingComplaints() + " smoking complaints");
		System.out.println();

		unitRemodel urem = new unitRemodel();
		urem.setBlackToStainless(true);
		urem.setCarpetToHardwood(false);
		urem.setFreshPaint(true);
		u1.setUnitRemodel(urem);
		System.out.println("There is " + (urem.getBlackToStainless() ? "a Black to Stainless project in progress" : "no Black to Stainless project in progress"));
		System.out.println();
		System.out.println("There is " + (urem.getCarpetToHardwood() ? "a carpet to hardwood project in progress" : "no carpet to hardwood project in progress"));
		System.out.println();
		System.out.println("There is " + (urem.getFreshPaint() ? "a fresh paint project in progress" : "no fresh pain project in progress"));
		System.out.println();




		
		














	}
}
