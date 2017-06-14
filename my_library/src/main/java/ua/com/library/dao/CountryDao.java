package ua.com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Author;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer> {
	Country findByName(String name);
	@Query("select distinct a from Country a left join fetch a.cities")
	List<Country> findCountryWithCities();

	@Query("select c from Country c left join fetch c.cities ct where c.id =:id")
	Country some(@Param("id") int id);

}
