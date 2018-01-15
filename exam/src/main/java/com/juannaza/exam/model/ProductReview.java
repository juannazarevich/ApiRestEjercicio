package com.juannaza.exam.model;

import org.springframework.stereotype.Component;

@Component
public class ProductReview {

	private String id;
	private String user;
	private String review;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
