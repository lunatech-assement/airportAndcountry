package com.lunatech.countriesandairport.dto;

public class AirportDetalsDto {

	
	private String airportIdentifier;
	
	private String airportName;
	
	private int numberOfRunways;

	public String getAirportIdentifier() {
		return airportIdentifier;
	}

	public void setAirportIdentifier(String airportIdentifier) {
		this.airportIdentifier = airportIdentifier;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public int getNumberOfRunways() {
		return numberOfRunways;
	}

	public void setNumberOfRunways(int numberOfRunways) {
		this.numberOfRunways = numberOfRunways;
	}

	@Override
	public String toString() {
		return "AirportDetalsDto [airportIdentifier=" + airportIdentifier + ", airportName=" + airportName
				+ ", numberOfRunways=" + numberOfRunways + "]";
	}
	
	
}
