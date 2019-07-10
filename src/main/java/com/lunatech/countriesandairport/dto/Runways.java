package com.lunatech.countriesandairport.dto;

public class Runways {

	private int id;
	
	private int airport_ref;
	
	private String airport_ident;
	
	private int length_ft;
	
	private int width_ft;
	
	private String surface;
	
	private int lighted;
	
	private int closed;
	
	private String le_ident;
	
	private String he_ident;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAirport_ref() {
		return airport_ref;
	}

	public void setAirport_ref(int airport_ref) {
		this.airport_ref = airport_ref;
	}

	public String getAirport_ident() {
		return airport_ident;
	}

	public void setAirport_ident(String airport_ident) {
		this.airport_ident = airport_ident;
	}

	public int getLength_ft() {
		return length_ft;
	}

	public void setLength_ft(int length_ft) {
		this.length_ft = length_ft;
	}

	public int getWidth_ft() {
		return width_ft;
	}

	public void setWidth_ft(int width_ft) {
		this.width_ft = width_ft;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public int getLighted() {
		return lighted;
	}

	public void setLighted(int lighted) {
		this.lighted = lighted;
	}

	public int getClosed() {
		return closed;
	}

	public void setClosed(int closed) {
		this.closed = closed;
	}

	public String getLe_ident() {
		return le_ident;
	}

	public void setLe_ident(String le_ident) {
		this.le_ident = le_ident;
	}

	public String getHe_ident() {
		return he_ident;
	}

	public void setHe_ident(String he_ident) {
		this.he_ident = he_ident;
	}

	@Override
	public String toString() {
		return "Runways [id=" + id + ", airport_ref=" + airport_ref + ", airport_ident=" + airport_ident
				+ ", length_ft=" + length_ft + ", width_ft=" + width_ft + ", surface=" + surface + ", lighted="
				+ lighted + ", closed=" + closed + ", le_ident=" + le_ident + ", he_ident=" + he_ident + "]";
	}
	
	
}
