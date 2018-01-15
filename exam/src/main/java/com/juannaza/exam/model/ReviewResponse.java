package com.juannaza.exam.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReviewResponse {
	private List<ProductReview> items;
	private PagingInfo paging;
	public List<ProductReview> getItems() {
		return items;
	}
	public void setItems(List<ProductReview> items) {
		this.items = items;
	}
	public PagingInfo getPaging() {
		return paging;
	}
	public void setPaging(PagingInfo paging) {
		this.paging = paging;
	}
}
