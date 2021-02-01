package com.naveenonjava.prodos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.naveenonjava.prodos.domain.JPAProduct;

public interface JPAProductRepository extends CrudRepository<JPAProduct, String>{
	// Fetch products by brand
	@Query("select p from JPAProduct p where p.brand = ?1")
	List<JPAProduct> findByBrand(String brand);
	
	// Fetch products by name and type
	@Query("select p from JPAProduct p where p.name = ?1 and p.type = ?2")
	List<JPAProduct> findByNameAndType(String name, String type);
}
