package ua.com.library.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dao.CustomerDao;
import ua.com.library.dao.BookDao;
import ua.com.library.entity.Customer;
import ua.com.library.entity.Book;
import ua.com.library.entity.Role;
import ua.com.library.service.CustomerService;
import ua.com.library.validator.Validator;

@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private BookDao bookDao;


	public void create(Customer customer) throws Exception {
		validator.validate(customer);
		customer.setRole(Role.ROLE_USER);
		customer.setPassword(encoder.encode(customer.getPassword()));

		customerDao.save(customer);
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	public Customer findOne(int id) {
		// TODO Auto-generated method stub
		return customerDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		customerDao.delete(id);
	}

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return customerDao.findByName(arg0);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) throws Exception {


		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + customer.getName() + "/"
				+ multipartFile.getOriginalFilename();

		customer.setPathImage("resources/" + customer.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + customer.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		customerDao.save(customer);
	}

	public Customer findByUUID(String uuid) {
		// TODO Auto-generated method stub
		return customerDao.findByUUID(uuid);
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	@Transactional
	public void buyBook(Principal principal, String id) {
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));

		Book book = bookDao.findOne(Integer.parseInt(id));

		customer.getBooks().add(book);
		
		

	}


	public Cookie intoBasket(String id, HttpServletRequest request, HttpServletResponse response) {

		request.getSession(false);
		Book book = bookDao.findOne(Integer.parseInt(id));

		Cookie cookieBook = new Cookie(book.getNumber(), String.valueOf(book.getId()));
		cookieBook.setMaxAge(24 * 60 * 60 * 60);
		cookieBook.setHttpOnly(true);
		cookieBook.setPath("/");

		response.addCookie(cookieBook);

		return cookieBook;

	}

	public List<Book> userBooksCookie(HttpServletRequest request) {

		request.getSession(false);
		List<Book> books = new ArrayList<>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {

			} else {

				books.add(bookDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return books;

	}

	@Transactional
	@Override
	public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response) {

		Customer customer = customerDao.fetchCustomerWithBook(Integer.parseInt(principal.getName()));
		Book book = bookDao.findOne(Integer.parseInt(id));
		customer.getBooks().add(book);
		

		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);

	}

	@Override
	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);

	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
		for (int i = 0; i < cookies.length; i++) {
			if (id.equals(cookies[i].getValue())) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setHttpOnly(true);
				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	@Override
	public void updateProfile(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
	}

	public List<Book> clickOnBuuton(HttpServletRequest request) {

		request.getSession(false);

		Cookie[] cookie = request.getCookies();

		List<Book> books = new ArrayList<>();

		for (Cookie cookie1 : cookie) {

			books.add(bookDao.findOne(Integer.parseInt(cookie1.getValue())));

		}

		return books;

	}




}
