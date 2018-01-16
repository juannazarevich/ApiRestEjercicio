package com.juannaza.exam.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.juannaza.exam.exceptions.CommunicationException;
import com.juannaza.exam.exceptions.ResourceNotFoundException;
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
		ProductInfo productInfo = new ProductInfo();
		try {
			productInfo= restTemplate.getForObject(urlProduct + id, ProductInfo.class);
		} catch (RestClientException e) {
			throw new CommunicationException("Error de conexión al obtener productos", e);
		}
		
		ReviewResponse reviewResponse = new ReviewResponse();
		try {
			reviewResponse = restTemplate.getForObject(urlReview + id + QUERY_STRING, ReviewResponse.class);
		} catch (Exception e) {
			throw new CommunicationException("Error de conexión al obtener reseñas", e);
		}
		
		if (productInfo == null || reviewResponse == null) {
			throw new ResourceNotFoundException("Recurso no encontrado");
		}
		
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
