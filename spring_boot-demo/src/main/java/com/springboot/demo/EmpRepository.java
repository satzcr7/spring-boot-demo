package com.springboot.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends CrudRepository<EmpModel, Integer> {

	// Crud Repository has common CRUD operations.
	// Spring JPA provides implementation of this interface.
}
