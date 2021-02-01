package com.naveenonjava.prodos.repository;

import com.naveenonjava.prodos.domain.Product;

public interface ProductRepository {
	Iterable<Product> findAll();
	
	Product findOne(String id);
	
	Product save(Product product);
}
