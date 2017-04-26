package com.fms.facility.maintenance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inspection {
	private String description;
	private Date date;
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		return "Inspection - " + description + ", " +  " Date: " + sdf.format(this.date);
	} 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
