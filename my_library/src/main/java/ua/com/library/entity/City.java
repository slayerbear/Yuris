package ua.com.library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({ @NamedQuery(name = "City.findAll", query = "select u from City u"),

})
@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Country country;
	private String city_name;
	@OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
	private List<Author> authors;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public City(String city_name) {
		super();
		this.city_name = city_name;
	}

	public List<Author> getAirports() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int id, Country country, String city_name, List<Author> authors) {
		super();
		this.id = id;
		this.country = country;
		this.city_name = city_name;
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "" + city_name;
	}

	
	

}
