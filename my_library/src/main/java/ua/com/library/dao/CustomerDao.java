package ua.com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	Customer findByName(String name);

	Customer findByEmail(String email);

	Customer findByTelephone(String telephone);

	@Query("select u from Customer u where u.uuid=:uuid")
	Customer findByUUID(@Param("uuid") String uuid);

	@Query("select distinct u from Customer u left join fetch u.books where u.id =:id")
	Customer fetchCustomerWithBook(@Param("id") int id);
}
