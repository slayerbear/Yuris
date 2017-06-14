package ua.com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Author;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.entity.Customer;

public interface CityDao extends JpaRepository<  City, Integer>{
	@Query("select c from City c left join fetch c.authors ar where c.id =:id")
	City some1(@Param("id") int id);
	@Query("select u from City u where u.city_name=:name")
	City findByCityName(@Param("name") String name);
}
