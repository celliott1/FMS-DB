package com.fms.facility.maintenance;

public class successRate {

	private String satisfactoryCompletion;
	private String unsatisfactoryCompletion;
	private String injuries;
	
	public String getSatisfactoryCompletion(){
		return satisfactoryCompletion;
	}
	
	public void setSatisfactoryCompletion(String satisfactoryCompletion){
		this.satisfactoryCompletion = satisfactoryCompletion;
	}
	
	public String getUnsatisfactoryCompletion(){
		return unsatisfactoryCompletion;
	}
	
	public void setUnsatisfactoryCompletion(String unsatisfactoryCompletion){
		this.unsatisfactoryCompletion = unsatisfactoryCompletion;
	}
	public String getInjuries(){
		return injuries;
	}
	
	public void setInjuries(String injuries){
		this.injuries = injuries;
	}
}
