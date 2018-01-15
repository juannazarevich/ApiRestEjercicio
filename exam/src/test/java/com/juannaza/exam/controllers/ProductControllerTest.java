package com.juannaza.exam.controllers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juannaza.exam.model.PagingInfo;
import com.juannaza.exam.model.ProductInfo;
import com.juannaza.exam.model.ProductInfoResponse;
import com.juannaza.exam.model.ProductReview;
import com.juannaza.exam.model.ReviewResponse;
import com.juannaza.exam.repositories.impl.ProductRepositoryImpl;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public class ProductControllerTest {

	@InjectMocks
	@Spy
	ProductController productController;
	
	@InjectMocks
	@Spy
	ProductRepositoryImpl productRepositoryImpl;
	
	@Mock
	ResponseEntity<ProductInfo> responseProduct;
	
	@Mock
	ResponseEntity<ReviewResponse> responseReview;
	
	@Mock
	RestTemplate restTemplate;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnProductInfoResponse() throws JsonProcessingException{
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId("1");
		productInfo.setDescription("Una heladera");
		productInfo.setName("Heladera");
		productInfo.setPrice(100F);
		productInfo.setStock(10);
		productInfo.setUsed(true);
		productInfo.setListPrice(78F);
		when(restTemplate.getForObject(anyString(), eq(ProductInfo.class))).thenReturn(productInfo);
		ProductReview productReview = new ProductReview();
		productReview.setId("1");
		productReview.setReview("Buenisimo");
		productReview.setUser("elepe");
		List<ProductReview> reviews = new ArrayList<>();
		reviews.add(productReview);
		PagingInfo pagingInfo = new PagingInfo();
		pagingInfo.setLimit(1);
		pagingInfo.setOffset(0);
		pagingInfo.setTotal(10);
		ReviewResponse reviewResponse = new ReviewResponse();
		reviewResponse.setItems(reviews);
		reviewResponse.setPaging(pagingInfo);
		when(restTemplate.getForObject(anyString(), eq(ReviewResponse.class))).thenReturn(reviewResponse);
		ProductInfoResponse productInfoResponse = productController.getProductInfo("1");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(productInfoResponse);
		System.out.println(jsonString);
		
		Assert.assertEquals(productInfoResponse.getId(), "1");
	}
	
}
