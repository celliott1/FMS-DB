package com.fms.facility.details;

import java.sql.*;
import com.fms.facility.details.Finances;
import com.fms.facility.usage.Person;

public class FacilityDB {
	
	static final String url = "jdbc:mysql://localhost:3306/";
	static final String user = "root";
	static final String pass = "comp373123";
	
	public Facility getFacility(int id) {
	
		try{
			Connection mycon = DriverManager.getConnection(url, user, pass);
			Statement mystm = mycon.createStatement();
			String selectFacilityQuery = "SELECT name, description, address, curUsage FROM Facility WHERE id = '" + id + "'";
			ResultSet facRS = mystm.executeQuery(selectFacilityQuery);
			
			Facility facility1 = new Facility();
			while(facRS.next()){
				facility1.setId(facRS.getInt("id"));
				facility1.setDescription(facRS.getString("description"));
				facility1.setAddress(facRS.getString("address"));
				facility1.setCurUsage(facRS.getString("curUsage"));
			}
			facRS.close();
			
			String selectFinancesQuery = "SELECT facilityProfit, propertyTax, payroll, expenses, insurance FROM Facility WHERE id = '" + id + "'";
			ResultSet finRS = mystm.executeQuery(selectFinancesQuery);
			Finances fin = new Finances();
			
			while(finRS.next()){
				fin.setFacilityProfit(finRS.getDouble("facilityProfit"));
				fin.setPropertyTax(finRS.getDouble("propertyTax"));
				fin.setPayroll(finRS.getDouble("payroll"));
				fin.setExpenses(finRS.getDouble("expenses"));
				fin.setInsurance(finRS.getDouble("insurance"));
			}
				facility1.setFinances(fin);
				finRS.close();
				
			String selectImpQuery = "SELECT addingToFacility, newTechnology, remodelingInProgress FROM Facility WHERE id = '" + id + "'";
			ResultSet impRS = mystm.executeQuery(selectImpQuery);
			improvementProjects imp = new improvementProjects();
			
			while(impRS.next()){
				imp.setAddingToFacility(impRS.getString("addingToFacility"));
				imp.setNewTechnology(impRS.getString("newTechnology"));
				imp.setRemodelingInProgress(impRS.getString("remodelingInProgress"));
			}
				facility1.setImprovementProjects(imp);
				impRS.close();
				
			String selectRosQuery = "SELECT doorman1, doorman2, facilityManager, leasingAgent1, leasingAgent2, srLeasingAgent FROM Facility WHERE id = '" + id + "'";
			ResultSet rosRS = mystm.executeQuery(selectRosQuery);
			officeRoster ros = new officeRoster();
			
			while(rosRS.next()){
				ros.setDoorman1(rosRS.getString("doorman1"));
				ros.setDoorman2(rosRS.getString("doorman2"));
				ros.setFacilityManager(rosRS.getString("facilityManager"));
				ros.setLeasingAgent1(rosRS.getString("leasingAgent1"));
				ros.setLeasingAgent2(rosRS.getString("leasingAgent2"));
				ros.setSrLeasingAgent(rosRS.getString("srLeasingAgent"));
			}
				facility1.setOfficeRoster(ros);
				rosRS.close();
				
			String selectSerQuery = "SELECT janitorialServices, parkingCompany, securityCompany, staffingCompany, webDesignCompany FROM Facility WHERE id = '" + id + "'";
			ResultSet serRS = mystm.executeQuery(selectSerQuery);
			serviceContracts ser = new serviceContracts();
			
			while(serRS.next()){
				ser.setJanitorialServices(serRS.getString("janitorialServices"));
				ser.setParkingCompany(serRS.getString("parkingCompany"));
				ser.setSecurityCompany(serRS.getString("securityCompany"));
				ser.setStaffingCompany(serRS.getString("staffingCompany"));
				ser.setWebDesignCompany(serRS.getString("webDesignCompany"));
			}
			facility1.setServiceContracts(ser);
			serRS.close();
			mystm.close();
				
			return facility1;
		}
			
			catch (SQLException se) {
				System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
			    System.err.println(se.getMessage());
			    se.printStackTrace();
			}	
	return null;
	}
	
	public void addFacility(Facility facility) throws SQLException{
		Connection mycon = DriverManager.getConnection(url, user, pass);
		PreparedStatement facPst = null;
		PreparedStatement finPst = null;
		PreparedStatement impPst = null;
		PreparedStatement rosPst = null;
		PreparedStatement serPst = null;
		
		try{
			String facStm = "INSERT INTO Facility(id, description, address, curUsage) VALUES (?, ?, ?, ?)";
			facPst = mycon.prepareStatement(facStm);
			facPst.setInt(1, facility.getId());
			facPst.setString(2, facility.getDescription());
			facPst.setString(3, facility.getAddress());
			facPst.setString(4, facility.getCurUsage());
			facPst.executeUpdate();
			
			String finStm = "INSERT INTO Finances(facilityProfit, propertyTax, payroll, expenses, insurance) VALUES (?, ?, ?, ?, ?)";
			finPst = mycon.prepareStatement(finStm);
			finPst.setDouble(1, facility.getFinances().getFacilityProfit());
			finPst.setDouble(2, facility.getFinances().getPropertyTax());
			finPst.setDouble(3, facility.getFinances().getPayroll());
			finPst.setDouble(4, facility.getFinances().getExpenses());
			finPst.setDouble(5, facility.getFinances().getInsurance());
			finPst.executeUpdate();
			
			String impStm = "INSERT INTO improvementProjects(addingToFacility, newTechnology, remodelingInProgress) VALUES (?, ?, ?)";
			impPst = mycon.prepareStatement(impStm);
			impPst.setString(1, facility.getImprovementProjects().getAddingToFacility());
			impPst.setString(2, facility.getImprovementProjects().getNewTechnology());
			impPst.setString(3, facility.getImprovementProjects().getRemodelingInProgress());
			impPst.executeUpdate();
			
			String rosStm = "INSERT INTO officeRoster(doorman1, doorman2, facilityManager, leasingAgent1, leasingAgent2, srLeasingAgent) VALUES (?, ?, ?, ?, ?, ?)";
			rosPst = mycon.prepareStatement(rosStm);
			rosPst.setString(1, facility.getOfficeRoster().getDoorman1());
			rosPst.setString(2, facility.getOfficeRoster().getDoorman2());
			rosPst.setString(3, facility.getOfficeRoster().getFacilityManager());
			rosPst.setString(4, facility.getOfficeRoster().getLeasingAgent1());
			rosPst.setString(5, facility.getOfficeRoster().getLeasingAgent2());
			rosPst.setString(6, facility.getOfficeRoster().getSrLeasingAgent());
			rosPst.executeUpdate();
			
			String serStm = "INSERT INTO serviceContracts(janitorialServices, parkingCompany, securityCompany, staffingCompany, webDesignCompany) VALUES (?, ?, ?, ?, ?)";
			serPst = mycon.prepareStatement(serStm);
			serPst.setString(1, facility.getServiceContracts().getJanitorialServices());
			serPst.setString(2, facility.getServiceContracts().getParkingCompany());
			serPst.setString(3, facility.getServiceContracts().getSecurityCompany());
			serPst.setString(4, facility.getServiceContracts().getStaffingCompany());
			serPst.setString(5, facility.getServiceContracts().getWebDesignCompany());
			serPst.executeUpdate();
			
			
	     } catch (SQLException ex) {

	        } finally {

	            try {
	                if (finPst != null) {
	                	finPst.close();
	                	facPst.close();
	                }
	                if (mycon != null) {
	                    mycon.close();
	                }

	            } catch (SQLException ex) {
	      	      System.err.println("CustomerDAO: Threw a SQLException saving the facility object.");
	    	      System.err.println(ex.getMessage());
	            }
	        }

		}
}


