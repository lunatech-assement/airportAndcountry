package com.lunatech.countriesandairport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import com.lunatech.countriesandairport.dto.CountriesDto;

public interface CountryService {

	public List<Object> getCountriesList();
}
