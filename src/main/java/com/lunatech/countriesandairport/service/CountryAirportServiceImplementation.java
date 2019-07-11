package com.lunatech.countriesandairport.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lunatech.countriesandairport.dto.AirportDetalsDto;
import com.lunatech.countriesandairport.dto.CountriesAndAirportDetailsDto;
import com.lunatech.countriesandairport.dto.CountriesDto;




@Service
public class CountryAirportServiceImplementation implements CountryAirportService {
	
	
	Logger log = LoggerFactory.getLogger(CountryAirportServiceImplementation.class);
	
	@Value("${country.service.url}")
	String COUNTRY_SERVICE_URI;
	
	@Value("${airport.service.url}")
	String AIRPORT_SERVICE_URI;

	@Override
	public  List<CountriesAndAirportDetailsDto> getCountryAndAirportDetails(int runwayMinimum) {
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		List<CountriesAndAirportDetailsDto> countryAndAirportList = new ArrayList<CountriesAndAirportDetailsDto>();
		List<CountriesDto> countryList = new ArrayList<CountriesDto>();
		List<AirportDetalsDto> airportList = new ArrayList<AirportDetalsDto>();

		try {
		log.info("Send Request To Country Service-->"+COUNTRY_SERVICE_URI);
		ResponseEntity<List<CountriesDto>> responseListCountry  = restTemplate.exchange(COUNTRY_SERVICE_URI, HttpMethod.GET, null,
		new ParameterizedTypeReference<List<CountriesDto>>() {});
		countryList = responseListCountry.getBody();

		log.info("Send Request To Airport Service-->"+AIRPORT_SERVICE_URI);
		ResponseEntity<List<AirportDetalsDto>> responseListAirport = restTemplate.exchange(AIRPORT_SERVICE_URI, HttpMethod.GET, null,
		new ParameterizedTypeReference<List<AirportDetalsDto>>() {});
		airportList = responseListAirport.getBody();

		if (runwayMinimum ==0 ) {
		for (CountriesDto country: countryList) {

		String countryCode = country.getCode().toString();

		for (AirportDetalsDto airport: airportList ) {

		String isoCountry = airport.getIso_country().toString();
		
		
		if (countryCode.equals(isoCountry)) {

		CountriesAndAirportDetailsDto countriesAndAirport = new CountriesAndAirportDetailsDto();

		countriesAndAirport.setCountryName(country.getName());
		countriesAndAirport.setAirportDetails(airport);
		countryAndAirportList.add(countriesAndAirport);
			}
		}
		}
		

		}else {
			for (CountriesDto country: countryList) {

				String countryCode = country.getCode().toString();

				for (AirportDetalsDto airport: airportList ) {

				String isoCountry = airport.getIso_country().toString();
				
				
				if (countryCode.equals(isoCountry)) {

				CountriesAndAirportDetailsDto countriesAndAirport = new CountriesAndAirportDetailsDto();

				countriesAndAirport.setCountryName(country.getName());
				countriesAndAirport.setAirportDetails(airport);
				
				if(airport.getRunways()>0) {
				int no =airport.getRunways();
				countryAndAirportList.add(countriesAndAirport);
				}
					}
				}
				}
		}

		} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("Exception Occured: "+e.getMessage());

		}
		return countryAndAirportList;
	}
	
	
	

}
