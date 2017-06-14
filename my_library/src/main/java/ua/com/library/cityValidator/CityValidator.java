package ua.com.library.cityValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.AuthorDao;
import ua.com.library.dao.CityDao;
import ua.com.library.entity.Author;
import ua.com.library.entity.City;
import ua.com.library.validator.Validator;

@Component("cityValidator")
public class CityValidator implements Validator{

@Autowired
private  CityDao cityDao;
	public void validate(Object object) throws Exception {
		City city=(City) object;
		if(city.getCity_name().isEmpty()){
			throw new CityValidationException(CityValidationMessage.EMPTY_CITY_NAME_FIELD);
			
		}
		if(city.getCountry()==null){
			throw new CityValidationException(CityValidationMessage.NO_COUNTRY);
			
		}
		if(cityDao.findByCityName(city.getCity_name()) != null){
			throw new CityValidationException(CityValidationMessage.CITY_ALREADY_EXISTS);
			
		}
		

		
		
	}
}
