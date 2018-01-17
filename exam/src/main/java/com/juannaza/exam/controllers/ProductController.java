package com.juannaza.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juannaza.exam.model.ProductInfoResponse;
import com.juannaza.exam.repositories.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	@Qualifier("prod")
	ProductRepository productRepository;
	
	@Autowired
	@Qualifier("test")
	ProductRepository productRepositoryForTest;

	@GetMapping("/product/{id}")
	public ProductInfoResponse getProductInfo(@PathVariable String id, 
			@RequestParam(value = "istest", required = false) boolean isTest){
		ProductRepository prd = getProductRepository(isTest);
		prd.getProductInfo(id);
		return getProductRepository(isTest).getProductInfo(id);
	}
	
	public ProductRepository getProductRepository(boolean flag){
		if (flag) {
			return productRepositoryForTest;
		} else {
			return productRepository;
		}
	}
}
