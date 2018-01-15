package com.juannaza.exam.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.juannaza.exam.model.ProductInfo;
import com.juannaza.exam.model.ProductInfoResponse;
import com.juannaza.exam.model.ReviewResponse;
import com.juannaza.exam.repositories.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "http://api.testingapi.com/legacy/product/";
	
	@Override
	public ProductInfoResponse getProductInfo(String id) {
		//ResponseEntity<ProductInfo> result= restTemplate.getForEntity("api.testingapi.com/legacy/product/" + id, ProductInfo.class);
		ResponseEntity<ProductInfo> result= restTemplate.getForEntity(url, ProductInfo.class);
		ProductInfo productInfo = result.getBody();

		ReviewResponse reviewResponse;
		
		reviewResponse = restTemplate.getForObject("api.testingapi.com/legacy/reviews/" + id + "?limit=1&offset=0", ReviewResponse.class);
		
		ProductInfoResponse productInfoResponse = new ProductInfoResponse();
		
		productInfoResponse.setId(id);
		productInfoResponse.setName(productInfo.getName());
		productInfoResponse.setDescription(productInfo.getDescription());
		productInfoResponse.setPrice(productInfo.getPrice());
		productInfoResponse.setListPrice(productInfo.getListPrice());
		productInfoResponse.setReviews(reviewResponse.getItems());
		
		return productInfoResponse;
	}

}
