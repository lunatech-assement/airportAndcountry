package com.lunatech.countriesandairport.dto;

public class CountriesDto {
	
	private String id;
	
	private String code;
	
	private String name;
	
	private String continent;
	
	private String wikipedia_link;
	
	private String keywords;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getWikipedia_link() {
		return wikipedia_link;
	}
	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	@Override
	public String toString() {
		return "CountriesDto [id=" + id + ", code=" + code + ", name=" + name + ", continent=" + continent
				+ ", wikipedia_link=" + wikipedia_link + ", keywords=" + keywords + "]";
	}
	
	
	

}
