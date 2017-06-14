package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import ua.com.library.dao.BookDao;
import ua.com.library.entity.Book;
import ua.com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	public void create(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);
	}

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	public Book findOne(int id) {
		// TODO Auto-generated method stub
		return bookDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
	}

	@Override
	public List<Book> sortBooks(int value) {
		return bookDao.sortBooks(value);
	}
}
