package com.lunatech.countriesandairport.dto;

import java.util.List;

public class AirportDetalsDto {

	
	private String id;
	
	private String ident;
	
	private String iso_country;
	
	private String name;
	
	private  List<Runways> noOfRunways;

	public int getRunways() { return noOfRunways.size(); }
	 

	public void setRunways(List<Runways> noOfRunways) {
		this.noOfRunways = noOfRunways;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getIso_country() {
		return iso_country;
	}

	public void setIso_country(String iso_country) {
		this.iso_country = iso_country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public int getNoOfRunways() { return noOfRunways = runways.size(); }
	 */

	


	@Override
	public String toString() {
		return "AirportDetalsDto [id=" + id + ", ident=" + ident + ", iso_country=" + iso_country + ", name=" + name
				+ "]";
	}


	
	
}
