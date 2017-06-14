package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.library.dao.AuthorDao;
import ua.com.library.dao.CityDao;
import ua.com.library.entity.Author;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.CityService;
import ua.com.library.validator.Validator;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	@Qualifier("cityValidator")
	private Validator validator;

	public void create(City city) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(city);
		cityDao.save(city);
	}

	public List<City> findAll() {
		// TODO Auto-generated method stub
		return cityDao.findAll();
	}

	public City findOne(int id) {
		// TODO Auto-generated method stub
		return cityDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {

		City city = cityDao.some1(id);

		for (Author author : city.getAirports()) {

			authorDao.delete(author);
		}

		cityDao.delete(id);

	}

}
