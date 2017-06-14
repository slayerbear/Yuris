package ua.com.library.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.library.entity.Author;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.entity.Customer;
import ua.com.library.entity.Book;



public class DtoUtilMapper {
public static List<AuthorDTO> authorsToAuthorsDTO(List<Author> authors){
	List<AuthorDTO> authorDTOs=new ArrayList<AuthorDTO>();
	for (Author author : authors) {
		AuthorDTO authorDTO=new AuthorDTO();
		authorDTO.setName(author.getName());
		authorDTO.setId(author.getId());
		authorDTO.setCity(author.getCity());
		authorDTOs.add(authorDTO);
		
	}
	return authorDTOs;
	
}

public static List<CityDTO> citiesToCitiesDTO(List<City> cities){
	List<CityDTO> cityDTOs=new ArrayList<CityDTO>();
	for (City city : cities) {
		CityDTO cityDTO=new CityDTO();
		cityDTO.setCity_name(city.getCity_name());
		cityDTO.setCountry(city.getCountry());
		cityDTO.setId(city.getId());
		cityDTOs.add(cityDTO);
	}
	return cityDTOs;
	
}

public static List<CountryDTO> countriesToCountriesDTO(List<Country> countries){
	List<CountryDTO>  countryDTOs=new ArrayList<CountryDTO>();
	for (Country  country : countries) {
		CountryDTO countryDTO=new CountryDTO();
		countryDTO.setName(country.getName());
		countryDTO.setId(country.getId());
		//countryDTO.setRegions(country.getRegions());
		countryDTOs.add(countryDTO);
	}
	return countryDTOs;
	
}
public static List<CustomerDTO> customersToCustomersDTO(List<Customer> customers){
	List<CustomerDTO>  customerDTOs=new ArrayList<CustomerDTO>();
	for (Customer  customer : customers) {
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setName(customer.getName());
		customerDTO.setId(customer.getId());
		customerDTO.setEmail(customer.getEmail());
		customerDTOs.add(customerDTO);
	}
	return customerDTOs;
	
}

public static List<BookDTO> booksToBooksDTO(List<Book> books){
	List<BookDTO>  bookDTOs=new ArrayList<BookDTO>();
	for (Book  book : books) {
		BookDTO bookDTO=new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setCompany(book.getCompany());
		bookDTO.setDepartureAuthor(book.getDepartureAuthor());
		bookDTO.setArrivalAuthor(book.getArrivalAuthor());
	
		bookDTO.setNumber(book.getNumber());
		bookDTOs.add(bookDTO);
	}
	return bookDTOs;
	
}


}









