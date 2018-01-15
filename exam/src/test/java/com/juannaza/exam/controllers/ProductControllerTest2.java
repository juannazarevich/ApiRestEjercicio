//package com.juannaza.exam.controllers;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.test.web.client.match.MockRestRequestMatchers;
//import org.springframework.test.web.client.response.MockRestResponseCreators;
//import org.springframework.web.client.RestTemplate;
//
//import com.juannaza.exam.repositories.impl.ProductRepositoryImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductControllerTest2 {
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@Autowired
//	private ProductRepositoryImpl productRepository;
//	
//	private MockRestServiceServer mockServer;
//	
//	@Before
//	public void setUp(){
//		mockServer = MockRestServiceServer.createServer(restTemplate);
//	}
//	
//	@Test
//	public void test(){
//		mockServer.expect(MockRestRequestMatchers.requestTo("http://api.testingapi.com/legacy/product/"))
//		.andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK));
//		
//		productRepository.getProductInfo("1");
//		
//		mockServer.verify();
//		
//		Assert.assertTrue("hello", true);
//	}
//
//}
