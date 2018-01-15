package com.juannaza.exam.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.juannaza.exam.model.ProductInfo;
import com.juannaza.exam.model.ProductInfoResponse;
import com.juannaza.exam.model.ReviewResponse;
import com.juannaza.exam.repositories.ProductRepository;

@Repository
@PropertySource(value = "classpath:application.properties")
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url.product}")
	private String urlProduct = "http://api.testingapi.com/legacy/product/";
	
	@Value("${url.review}")
	private String urlReview = "http://api.testingapi.com/legacy/reviews/";
	
	private static final String QUERY_STRING = "?limit=1&offset=0";
	
	@Override
	public ProductInfoResponse getProductInfo(String id) {
		ProductInfo productInfo= restTemplate.getForObject(urlProduct + id, ProductInfo.class);

		ReviewResponse reviewResponse = restTemplate.getForObject(urlReview + id + QUERY_STRING, ReviewResponse.class);
		
		return createProductInfoResponse(productInfo, reviewResponse);
	}

	private ProductInfoResponse createProductInfoResponse(ProductInfo productInfo,
			ReviewResponse reviewResponse) {
		ProductInfoResponse productInfoResponse = new ProductInfoResponse();
		productInfoResponse.setId(productInfo.getId());
		productInfoResponse.setName(productInfo.getName());
		productInfoResponse.setDescription(productInfo.getDescription());
		productInfoResponse.setPrice(productInfo.getPrice());
		productInfoResponse.setListPrice(productInfo.getListPrice());
		productInfoResponse.setReviews(reviewResponse.getItems());
		return productInfoResponse;
	}

}
