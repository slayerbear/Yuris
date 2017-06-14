package ua.com.library.customerValidator;

import java.sql.Connection;


import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.CustomerDao;
import ua.com.library.entity.Customer;
import ua.com.library.validator.Validator;

@Component("customerValidator")
public class CustomerValidator implements Validator {
@Autowired
private CustomerDao customerDao;



public void validate(Object object) throws Exception {
	Customer customer=(Customer) object;
	if(customer.getName().isEmpty()){
		throw new CustomerValidationException(CustomerValidationMessage.EMPTY_USERNAME_FIELD);
		
	}
	if(customerDao.findByName(customer.getName()) != null){
		throw new CustomerValidationException(CustomerValidationMessage.NAME_ALREADY_EXISTS);
		
	}
	if(customer.getEmail().isEmpty()){
		throw new CustomerValidationException(CustomerValidationMessage.EMPTY_EMAIL_FIELD);
		
	}
	if(!customer.getEmail().contains("@")) {
		throw new CustomerValidationException(CustomerValidationMessage.NOT_EMAIL);
		
	}
	if(customerDao.findByEmail(customer.getEmail()) != null){
		throw new CustomerValidationException(CustomerValidationMessage.EMAIL_ALREADY_EXISTS);
		
	}
	if(customer.getPassword().isEmpty()){
		throw new CustomerValidationException(CustomerValidationMessage.EMPTY_PASSWORD_FIELD);
		
	}

	if(customer.getTelephone().isEmpty()){
		throw new CustomerValidationException(CustomerValidationMessage.EMPTY_TELEPHONE_FIELD);
		
	}
	
	if(customer.getTelephone().length()!=10
			){
		throw new CustomerValidationException(CustomerValidationMessage.NOT_TELEPHONE);
		
	}

	if(customerDao.findByTelephone(customer.getTelephone()) != null){
		throw new CustomerValidationException(CustomerValidationMessage.TELEPHONE_ALREADY_EXISTS);
		
	}

	
	
}

}
