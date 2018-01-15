package com.juannaza.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.juannaza.exam.model.ProductInfoResponse;
import com.juannaza.exam.repositories.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/product/{id}")
	public ProductInfoResponse getProductInfo(@PathVariable String id){
		return productRepository.getProductInfo(id);
	}
}
