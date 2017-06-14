package ua.com.library.dto;

import ua.com.library.entity.Country;

public class CityDTO {
	public int id;
	public String city_name;
	public Country country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public CityDTO(int id, String city_name) {
		super();
		this.id = id;
		this.city_name = city_name;
	}
	public CityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
