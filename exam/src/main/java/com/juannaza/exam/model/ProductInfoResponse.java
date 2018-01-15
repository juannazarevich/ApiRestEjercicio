package com.juannaza.exam.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductInfoResponse {
	
	private String id;
	private String name;
	private String description;
	private Float price;
	//TODO el doc debe devolver list_price
	private Float listPrice;
	private List<ProductReview> reviews;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getListPrice() {
		return listPrice;
	}
	public void setListPrice(Float listPrice) {
		this.listPrice = listPrice;
	}
	public List<ProductReview> getReviews() {
		return reviews;
	}
	public void setReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
	}
	
}
