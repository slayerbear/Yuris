package ua.com.library.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String company;
	private String title;
	@ManyToOne
	private Author departureAuthor;
	@ManyToOne
	private Author arrivalAuthor;

	
	private int price;
	
	
	@ManyToOne
	private Customer customer;
	private String number;


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Book(String book_name) {
		super();

		this.title = book_name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Author getDepartureAuthor() {
		return departureAuthor;
	}

	public void setDepartureAuthor(Author departureAuthor) {
		this.departureAuthor = departureAuthor;
	}

	public Author getArrivalAuthor() {
		return arrivalAuthor;
	}

	public void setArrivalAuthor(Author arrivalAuthor) {
		this.arrivalAuthor = arrivalAuthor;
	}

	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Book(String company,String title, Author departureAuthor, Author arrivalAuthor, int price,
			 String number) {
		super();
		this.company = company;
		this.departureAuthor = departureAuthor;
		this.arrivalAuthor = arrivalAuthor;
		this.title = title;
		this.price = price;
		
		
		this.number = number;
	}

	@Override
	public String toString() {
		return title+" ";
	}



}