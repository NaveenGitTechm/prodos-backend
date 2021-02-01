//package com.naveenonjava.prodos.domain;
//
//import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
//
//import com.naveenonjava.prodos.ProductController;
//
//public class ProductResourceAssembler 
//		extends RepresentationModelAssemblerSupport<JPAProduct, ProductResource>{
//	
//	public ProductResourceAssembler() {
//		super(ProductController.class,ProductResource.class);
//	}
//	
//	@Override
//	protected ProductResource instantiateModel(JPAProduct product) {
//		return new ProductResource(product);
//	}
//	
//	@Override
//	public ProductResource toModel(JPAProduct product) {
//		return createModelWithId("products/"+product.getId(), product);
//	}
//	
//}
