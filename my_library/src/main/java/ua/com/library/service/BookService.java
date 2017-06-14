package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Book;

public interface BookService {
	void create(Book book);

	List<Book> findAll();

	Book findOne(int id);

	void delete(int id);

	List<Book> sortBooks(int value);
}
