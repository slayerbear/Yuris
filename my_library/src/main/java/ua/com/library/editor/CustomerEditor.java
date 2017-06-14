package ua.com.library.editor;

import java.beans.PropertyEditorSupport;

import ua.com.library.service.AuthorService;
import ua.com.library.service.CustomerService;

public class CustomerEditor extends PropertyEditorSupport{
	private final CustomerService customerService;

	public CustomerEditor(CustomerService customerService) {
		
		this.customerService = customerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(customerService.findOne(Integer.parseInt(text)));
	}

}
