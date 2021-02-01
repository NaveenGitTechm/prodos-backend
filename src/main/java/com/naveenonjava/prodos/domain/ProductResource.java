package com.naveenonjava.prodos.domain;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value="product", collectionRelation="products")
public class ProductResource extends RepresentationModel{
	private String id;
	private String name;
	private String type;
	private String description;
	private String brand;
	
	public ProductResource(JPAProduct product) {
		this.id=product.getId();
		this.name=product.getName();
		this.type=product.getType();
		this.description=product.getDescription();
		this.brand=product.getBrand();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
