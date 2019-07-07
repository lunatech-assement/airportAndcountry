package com.lunatech.countriesandairport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunatech.countriesandairport.dto.CountriesAndAirportDetailsDto;
import com.lunatech.countriesandairport.service.CountryService;

@RestController
public class CountriesAndAirportController {

	
	@Autowired
	CountryService countryService;
	
	
	@RequestMapping("/countryairportsummary")
	public ResponseEntity<List<CountriesAndAirportDetailsDto>> getCountriesAndAirportDetails(){
		
		List<CountriesAndAirportDetailsDto> countriesAndAirportDetailsList= null;
		
		try {
			
			countryService.getCountriesList();
			return new ResponseEntity<List<CountriesAndAirportDetailsDto>>(countriesAndAirportDetailsList,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<CountriesAndAirportDetailsDto>>(countriesAndAirportDetailsList,HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
}
