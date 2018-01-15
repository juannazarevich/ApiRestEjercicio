package com.juannaza.exam.model;

import org.springframework.stereotype.Component;

@Component
public class ProductInfo {

	private String id;
	private String name;
	private String description;
	private Float price;
	private Float listPrice;
	private Integer stock;
	private boolean used;
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
}
