package ua.com.library.authorValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.AuthorDao;
import ua.com.library.entity.Author;
import ua.com.library.validator.Validator;

@Component("authorValidator")
public class AuthorValidator implements Validator{
	@Autowired
	private  AuthorDao authorDao;



	public void validate(Object object) throws Exception {
		Author author=(Author) object;
		if(author.getName().isEmpty()){
			throw new AuthorValidationException(AuthorValidationMessage.EMPTY_NAME_FIELD);
			
		}
		if(author.getCity()==null){
			throw new AuthorValidationException(AuthorValidationMessage.NO_CITY);
			
		}

		if(authorDao.findByName(author.getName()) != null){
			throw new AuthorValidationException(AuthorValidationMessage.NAME_EXISTS);
			
		}
	}
}
