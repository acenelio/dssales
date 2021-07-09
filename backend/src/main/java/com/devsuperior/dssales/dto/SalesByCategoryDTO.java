package com.devsuperior.dssales.dto;

import java.io.Serializable;

import com.devsuperior.dssales.entities.Category;

public class SalesByCategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String categoryName;
	private Double sum;
	
	public SalesByCategoryDTO() {
	}

	public SalesByCategoryDTO(Category category, Double sum) {
		this.categoryName = category.getName();
		this.sum = sum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
}
