package com.naveenonjava.prodos;

//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.naveenonjava.prodos.domain.JPAProduct;
import com.naveenonjava.prodos.repository.JPAProductRepository;

@RestController
public class ProductController {
	//private ProductRepository productRepository;
	
	private JPAProductRepository productRepository;
	
	public ProductController(JPAProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")
	public List<JPAProduct> findAll(){
		List<JPAProduct> products = new ArrayList<>();
		productRepository.findAll().forEach(i -> products.add(i));
		return products;
	}
	

//	@GetMapping("/products")
//	public CollectionModel<EntityModel<JPAProduct>> findAll(){
//		List<JPAProduct> products = new ArrayList<>();
//		productRepository.findAll().forEach(i -> products.add(i));
//		CollectionModel<EntityModel<JPAProduct>> productResources = 
//				CollectionModel.wrap(products);
////		productResources.add(
////				ControllerLinkBuilder.linkTo(
////						ProductController.class).slash("products").withRel("products"));
//		productResources.add(
//				linkTo(methodOn(ProductController.class).findAll()).withRel("products"));
//		return productResources;
//	}
	
//	@GetMapping("/products/{id}")
//	public JPAProduct findProductById(@PathVariable String id){
//		return 
//			productRepository.findById(id).isPresent() ? 
//					productRepository.findById(id).get() : null;
//	}
	
//	@GetMapping("/products")
//	public CollectionModel<ProductResource> findAll(){
//		List<JPAProduct> products = new ArrayList<>();
//		productRepository.findAll().forEach(i -> products.add(i));
//		CollectionModel<ProductResource> productResources = 
//				new ProductResourceAssembler().toCollectionModel(products);
//		productResources.add(
//				linkTo(methodOn(ProductController.class).findAll()).withRel("products"));
//		return productResources;
//	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<JPAProduct> findProductById(@PathVariable String id){
		return 
			productRepository.findById(id).isPresent() ? 
					new ResponseEntity<>(productRepository.findById(id).get(), HttpStatus.OK):
				new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
	}
	
//	@PostMapping(value="/products", consumes="application/json")
//	@ResponseStatus(HttpStatus.CREATED)
//	public JPAProduct saveProduct(@RequestBody JPAProduct product) {
//		return productRepository.save(product);
//	}
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value="/products", consumes="application/json")
	public ResponseEntity<JPAProduct> saveProduct(@RequestBody JPAProduct product, 
			UriComponentsBuilder builder) {
		System.out.println("here in save product..");
		productRepository.save(product);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/products/{id}").
				buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<JPAProduct>(product, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/products")
	public JPAProduct updateProduct(@RequestBody JPAProduct product) {
		return productRepository.save(product);
	}
	
	@PatchMapping(value="/products/{id}", consumes="application/json")
	public JPAProduct updateProduct1(@PathVariable String id, @RequestBody JPAProduct product) {
		JPAProduct updProduct = productRepository.findById(id).get();
		if(product.getBrand() != null) {
			updProduct.setBrand(product.getBrand());
		}
		if(product.getDescription() != null) {
			updProduct.setDescription(product.getDescription());
		}
		//other fields
		return updProduct;
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		try {
			productRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
	}
}
