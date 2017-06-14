package ua.com.library.dto;

import java.util.List;

import ua.com.library.entity.City;


public class CountryDTO {
	public int id;
	public String name;
	private List<City> cities;
	public CountryDTO(String name) {
		super();
		this.name = name;
	}
	public CountryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
