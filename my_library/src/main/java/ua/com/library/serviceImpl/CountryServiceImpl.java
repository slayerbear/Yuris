package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.CityDao;
import ua.com.library.dao.CountryDao;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.CountryService;
import ua.com.library.validator.Validator;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CityDao cityDao;

	@Qualifier("countryValidator")
	private Validator validator;
	public void create(Country country) throws Exception  {
		// TODO Auto-generated method stub
		//validator.validate(country);
		countryDao.save(country);
	}

	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		// TODO Auto-generated method stub
		return countryDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {

		Country country = countryDao.some(id);

		System.out.println(country.getName());
		System.out.println(country.getCities());

		for (City city : country.getCities()) {
			// city.setCountry(null);
			cityDao.delete(city);
		}
		//

		countryDao.delete(id);

	}

	public void saveAndFlush(Country country) {
		// TODO Auto-generated method stub
		countryDao.saveAndFlush(country);
	}

	public void deleteCityFromCountry(String idCity) {
		// TODO Auto-generated method stub
		City city = cityDao.findOne(Integer.parseInt(idCity));
		city.setCountry(null);
		cityDao.save(city);

	}

	public List<Country> findCitiesFromCountry() {
		// TODO Auto-generated method stub
		return countryDao.findCountryWithCities();
	}

}
