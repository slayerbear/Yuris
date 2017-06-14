package ua.com.library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private City city;
	@OneToMany(mappedBy="departureAuthor", cascade = CascadeType.REMOVE)
	private List<Book> departureBooks;
	@OneToMany(mappedBy="arrivalAuthor", cascade = CascadeType.REMOVE)
	private List<Book> arrivalBooks;



	public List<Book> getDepartureBooks() {
		return departureBooks;
	}

	public void setDepartureBooks(List<Book> departureBooks) {
		this.departureBooks = departureBooks;
	}

	public List<Book> getArrivalBooks() {
		return arrivalBooks;
	}

	public void setArrivalBooks(List<Book> arrivalBooks) {
		this.arrivalBooks = arrivalBooks;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author(String author_name) {
		super();

		this.name = author_name;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return name+" ";
	}


	
	
	

}
