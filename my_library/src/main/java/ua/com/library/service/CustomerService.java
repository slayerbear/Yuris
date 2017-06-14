package ua.com.library.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import ua.com.library.entity.Customer;
import ua.com.library.entity.Book;

public interface CustomerService {
	void create(Customer customer) throws Exception;

	List<Customer> findAll();

	Customer findOne(int id);

	void delete(int id);

	void buyBook(Principal principal, String id);

	public void saveImage(Principal principal, MultipartFile multipartFile) throws Exception;

	Customer findByUUID(String uuid);

	void update(Customer customer);

	void updateProfile(Customer customer);
	// for cookie

	public Cookie intoBasket(String id, HttpServletRequest request, HttpServletResponse response);

	List<Book> userBooksCookie(HttpServletRequest request);

	public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response);

	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
}
