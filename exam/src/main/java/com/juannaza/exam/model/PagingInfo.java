package com.juannaza.exam.model;

import org.springframework.stereotype.Component;

@Component
public class PagingInfo {
	
	private Integer offset;
	private Integer limit;
	private Integer total;
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

}
