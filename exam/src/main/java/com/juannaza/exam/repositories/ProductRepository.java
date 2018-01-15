package com.juannaza.exam.repositories;

import com.juannaza.exam.model.ProductInfoResponse;

public interface ProductRepository {

	public ProductInfoResponse getProductInfo(String id);
}
