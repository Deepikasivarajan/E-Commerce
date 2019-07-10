package com.hcl.ecommerce.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long categoryId;
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
