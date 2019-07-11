package com.lunatech.countriesandairport.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lunatech.countriesandairport.dto.CountriesAndAirportDetailsDto;
import com.lunatech.countriesandairport.service.CountryAirportService;
import com.lunatech.countriesandairport.service.CountryAirportServiceImplementation;

@RestController
public class CountriesAndAirportController {

	Logger log = LoggerFactory.getLogger(CountryAirportServiceImplementation.class);
	
	@Autowired
	CountryAirportService countryService;
	
	
	@RequestMapping("/countryairportsummary")
	public ResponseEntity<List<CountriesAndAirportDetailsDto>> getCountriesAndAirportDetails(
			@RequestParam(value="runwayminimum" , required = false) Integer runwayMinimum
			){
		
		log.info("Get Request Received" );
		
		if(runwayMinimum ==null) {
			runwayMinimum = 0;
		}
		List<CountriesAndAirportDetailsDto> countriesAndAirportDetailsList= null;
		
		try{
			countriesAndAirportDetailsList = countryService.getCountryAndAirportDetails(runwayMinimum);
			return new ResponseEntity<List<CountriesAndAirportDetailsDto>>(countriesAndAirportDetailsList,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<CountriesAndAirportDetailsDto>>(countriesAndAirportDetailsList,HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
}
