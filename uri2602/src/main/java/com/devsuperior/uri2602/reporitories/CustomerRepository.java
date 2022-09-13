package com.devsuperior.uri2602.reporitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	/*
	 * Consulta SQL.
	 */
	@Query(nativeQuery = true, value = "SELECT name "
			+ "FROM customers "
			+ "WHERE UPPER(state)= UPPER(:state)")
	List<CustomerMinProjection> search1(String state);
	
	/*
	 * Consulta JPQL. Pode ser feita diretamente ao DTO.
	 */
	@Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) "
			+ "FROM Customer obj "
			+ "WHERE UPPER(obj.state)= UPPER(:state)")
	List<CustomerMinDTO> search2(String state);
}
