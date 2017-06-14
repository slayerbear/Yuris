package ua.com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	@Query("select b from Book b where b.price >= :value")
	List<Book> sortBooks(@Param("value") int value);
	List<Book> findAll();
}
