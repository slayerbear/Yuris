package ua.com.library.dto;

import ua.com.library.entity.City;

public class AuthorDTO {
	public int id;
public String name;
public City city;

public AuthorDTO(String name) {
	super();
	this.name =name;
}

public AuthorDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}

@Override
public String toString() {
	return "AuthorDTO [city=" + city + "]";
}


}
