package ua.com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Author;
import ua.com.library.entity.City;


public interface AuthorDao extends JpaRepository< Author, Integer>{
	Author findByName(String name);
	@Query("select c from Author c left join fetch c.city ar where c.id =:id")
	Author some2(@Param("id") int id);


}
