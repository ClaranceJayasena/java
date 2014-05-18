package com.au.modelobject;

import java.util.List;

/**
 * @author Clarance Jayasena
 */

public class SubjectResultObject {
	
	
   	private String iTotalDisplayRecords;
   	private String iTotalRecords;
   	private Number sEcho;
   	private List<String[]> aaData; 	

	public String getITotalDisplayRecords(){
		return this.iTotalDisplayRecords;
	}
	public void setITotalDisplayRecords(String iTotalDisplayRecords){
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
 	public String getITotalRecords(){
		return this.iTotalRecords;
	}
	public void setITotalRecords(String iTotalRecords){
		this.iTotalRecords = iTotalRecords;
	}
 	public Number getSEcho(){
		return this.sEcho;
	}
	public void setSEcho(Number sEcho){
		this.sEcho = sEcho;
	}
	
 	public List<String[]> getAaData() {
		return aaData;
	}
	public void setAaData(List<String[]> aaData) {
		this.aaData = aaData;
	}	

}
