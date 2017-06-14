package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Author;
import ua.com.library.entity.City;

public interface AuthorService {
	void create(Author author) throws Exception;

	List<Author> findAll();

	Author findOne(int id);

	void delete(int id);

	void addCityToAuthor(Author author, int idCity);

	Author findAuthorWithName(String name);
}
