package ua.com.library.dto;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import ua.com.library.entity.Author;

public class BookDTO {
	private int id;
	private String company;
    private Author departureAuthor;
    private Author arrivalAuthor;
	private String title;
	private int price;
	
	private String number;
	private String Author;
	public BookDTO(int id, String company,String title, Author departureAuthor, Author arrivalAuthor,
			int price, String number) {
		super();
		this.id = id;
		this.company = company;
		this.departureAuthor = departureAuthor;
		this.arrivalAuthor = arrivalAuthor;
		this.title = title;
		this.price = price;
		
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public BookDTO(String number,Author departureAuthor, Author arrivalAuthor) {
		super();
		this.number = number;
		this.departureAuthor = departureAuthor;
		this.arrivalAuthor = arrivalAuthor;
		
	}
	@Override
	public String toString() {
		return  departureAuthor+" - "+ company ;
	}
	

		
}
