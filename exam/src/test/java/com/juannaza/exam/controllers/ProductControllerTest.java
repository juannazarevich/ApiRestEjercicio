package com.juannaza.exam.controllers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.juannaza.exam.model.ProductInfo;
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
	ResponseEntity<ProductInfo> response;
	
	@Mock
	RestTemplate restTemplate;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test(){
		productController.getProductInfo("1");
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId("1");
		//Mockito.when(restTemplate.getForEntity(Matchers.anyString(),Matchers.eq(ProductInfo.class), Matchers.<Object>anyVararg())).thenReturn(response);
		when(restTemplate.getForEntity(anyString(),eq(ProductInfo.class))).thenReturn(response);
		//Mockito.doReturn(response).when(restTemplate).getForEntity(Matchers.anyString(), Matchers.eq(ProductInfo.class));
		when(response.getBody()).thenReturn(productInfo);
	}
	
}
