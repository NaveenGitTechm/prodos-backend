package com.naveenonjava.prodos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.naveenonjava.prodos.domain.JPAProduct;
import com.naveenonjava.prodos.repository.JPAProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTests {
	
	@Autowired
	private JPAProductRepository productRepository;
	
	@Test
	public void testSaveProduct() {
		productRepository.save(
				new JPAProduct("MOB301", "POCO", "Mobile", "Xiomi Smart Phone with 24MP front camera", "Xiomi"));
		JPAProduct product = productRepository.findById("MOB301").get();
		assertThat(product.getId()).isNotNull();
	}
	
	@Test
	public void testGetProduct() {
		
		JPAProduct product = productRepository.findById("MOB01").get();
		assertThat(product.getId()).isNotNull();
	}
	
	@Test
	public void testDeleteProducts() {
		assertThat(productRepository.findAll()).size().isEqualTo(5);
		productRepository.deleteAll();
		assertThat(productRepository.findAll()).isEmpty();
	}
}
