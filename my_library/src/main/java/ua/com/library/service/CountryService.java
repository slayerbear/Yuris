package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Country;

public interface CountryService {
	void create(Country country) throws Exception;

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void deleteCityFromCountry(String idBook);

	List<Country> findCitiesFromCountry();

	void saveAndFlush(Country country);
}
