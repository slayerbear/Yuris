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
import ua.com.library.service.AuthorService;
import ua.com.library.validator.Validator;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	@Qualifier("authorValidator")
	private Validator validator;

	public void create(Author author) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(author);
		authorDao.save(author);
	}

	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

	public Author findOne(int id) {
		// TODO Auto-generated method stub
		return authorDao.findOne(id);
	}

	public void delete(int id) {

		// TODO Auto-generated method stub
		authorDao.delete(id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void addCityToAuthor(Author author, int idCity) {

		authorDao.saveAndFlush(author);

		City city = cityDao.findOne(idCity);

		city.setAuthors((List<Author>) author);

		cityDao.save(city);

	}

	@Override
	public Author findAuthorWithName(String name) {
		// TODO Auto-generated method stub
		Author a;
		a = authorDao.findByName(name);
		return a;
	}




	

	

}
