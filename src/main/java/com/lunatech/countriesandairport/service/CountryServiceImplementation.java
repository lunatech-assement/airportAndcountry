package com.lunatech.countriesandairport.service;

import java.util.Arrays;
import java.util.List;

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

import com.lunatech.countriesandairport.dto.CountriesDto;


@Service
public class CountryServiceImplementation implements CountryService {
	
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	
	@Value("${country.service.url}")
	String COUNTRY_SERVICE_URL;

	@Override
	public  List<Object> getCountriesList() {
		
		
		
		
		
		final String countryUri = COUNTRY_SERVICE_URL;
		final String AirportUri = COUNTRY_SERVICE_URL;
		
		System.out.println("uri -->"+ countryUri);
	    RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Object>> response = restTemplate.exchange(countryUri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Object>>() {});
		
		System.out.println("response -->"+ response.getBody());
		return response.getBody();
	}

}
