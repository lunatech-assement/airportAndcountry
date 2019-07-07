package com.lunatech.countriesandairport.dto;

public class CountriesAndAirportDetailsDto {

	private String countryName;
	
	private AirportDetalsDto airportDetails;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public AirportDetalsDto getAirportDetails() {
		return airportDetails;
	}

	public void setAirportDetails(AirportDetalsDto airportDetails) {
		this.airportDetails = airportDetails;
	}

	@Override
	public String toString() {
		return "CountriesDto [countryName=" + countryName + ", airportDetails=" + airportDetails + "]";
	}
	
	
}
