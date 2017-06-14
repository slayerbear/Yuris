package ua.com.library.countryValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.countryValidator.CountryValidationException;
import ua.com.library.countryValidator.CountryValidationMessage;
import ua.com.library.dao.CountryDao;
import ua.com.library.entity.Country;
import ua.com.library.validator.Validator;

@Component("countryValidator")
public class CountryValidator implements Validator{


@Autowired
private  CountryDao countryDao;
	public void validate(Object object) throws Exception {
		Country country=(Country) object;
		if(country.getName().isEmpty()){
			throw new CountryValidationException(CountryValidationMessage.EMPTY_COUNTRY_NAME_FIELD);
			
		}
		if(countryDao.findByName(country.getName()) != null){
			throw new CountryValidationException(CountryValidationMessage.COUNTRY_ALREADY_EXISTS);
			
		}
		

		
		
	}
}
