package com.juannaza.exam.repositories.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.juannaza.exam.model.PagingInfo;
import com.juannaza.exam.model.ProductInfo;
import com.juannaza.exam.model.ProductInfoResponse;
import com.juannaza.exam.model.ProductReview;
import com.juannaza.exam.model.ReviewResponse;
import com.juannaza.exam.repositories.ProductRepository;

@Repository("test")
public class ProductRepositoryMockImpl implements ProductRepository {

	@Override
	public ProductInfoResponse getProductInfo(String id) {
		Map<String, ProductInfoResponse> mapProductInfoResponse = new HashMap<>();
		ProductInfo productInfo = setOneProductInfo();
		ReviewResponse reviewResponse = setOneReviewResponse();
		ProductInfoResponse productInfoResponse = createProductInfoResponse(productInfo, reviewResponse);
		mapProductInfoResponse.put("1", productInfoResponse);
		productInfo = setTwoProductInfo();
		reviewResponse = setTwoReviewResponse();
		productInfoResponse = createProductInfoResponse(productInfo, reviewResponse);
		mapProductInfoResponse.put("2", productInfoResponse);
		productInfo = setThreeProductInfo();
		productInfoResponse = createProductInfoResponse(productInfo, null);
		mapProductInfoResponse.put("3", productInfoResponse);
		return mapProductInfoResponse.get(id);
	}
	
	private ProductInfoResponse createProductInfoResponse(ProductInfo productInfo,
			ReviewResponse reviewResponse) {
		ProductInfoResponse productInfoResponse = new ProductInfoResponse();
		productInfoResponse.setId(productInfo.getId());
		productInfoResponse.setName(productInfo.getName());
		productInfoResponse.setDescription(productInfo.getDescription());
		productInfoResponse.setPrice(productInfo.getPrice());
		productInfoResponse.setListPrice(productInfo.getListPrice());
		if (reviewResponse == null) {
			productInfoResponse.setReviews(null);
		} else {
			productInfoResponse.setReviews(reviewResponse.getItems());
		}
		return productInfoResponse;
	}
	
	private ReviewResponse setOneReviewResponse() {
		ProductReview productReview = new ProductReview();
		productReview.setId("a");
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
		return reviewResponse;
	}
	
	private ReviewResponse setTwoReviewResponse() {
		ProductReview productReview = new ProductReview();
		productReview.setId("b");
		productReview.setReview("Otro comentario");
		productReview.setUser("pedro123");
		ProductReview productReviewTwo = new ProductReview();
		productReviewTwo.setId("c");
		productReviewTwo.setReview("Segundo comentario");
		productReviewTwo.setUser("pablo123");
		List<ProductReview> reviews = new ArrayList<>();
		reviews.add(productReview);
		reviews.add(productReviewTwo);
		PagingInfo pagingInfo = new PagingInfo();
		pagingInfo.setLimit(2);
		pagingInfo.setOffset(0);
		pagingInfo.setTotal(10);
		ReviewResponse reviewResponse = new ReviewResponse();
		reviewResponse.setItems(reviews);
		reviewResponse.setPaging(pagingInfo);
		return reviewResponse;
	}

	private ProductInfo setOneProductInfo() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId("1");
		productInfo.setDescription("Una heladera");
		productInfo.setName("Heladera");
		productInfo.setPrice(100F);
		productInfo.setStock(10);
		productInfo.setUsed(true);
		productInfo.setListPrice(78F);
		return productInfo;
	}
	
	private ProductInfo setTwoProductInfo() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId("2");
		productInfo.setDescription("Un lavarropas");
		productInfo.setName("Lavarropas");
		productInfo.setPrice(500F);
		productInfo.setStock(10);
		productInfo.setUsed(true);
		productInfo.setListPrice(420F);
		return productInfo;
	}
	
	private ProductInfo setThreeProductInfo(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId("3");
		productInfo.setDescription("Un microondas");
		productInfo.setName("Microondas");
		productInfo.setPrice(200F);
		productInfo.setStock(10);
		productInfo.setUsed(true);
		productInfo.setListPrice(120F);
		return productInfo;
	}
	
	

}
