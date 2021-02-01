package com.naveenonjava.prodos.repository;

import org.springframework.data.repository.CrudRepository;

import com.naveenonjava.prodos.domain.ProdosUser;

public interface ProdosUserRepository extends CrudRepository<ProdosUser, Long>{
	ProdosUser findByUsername(String username);
}
