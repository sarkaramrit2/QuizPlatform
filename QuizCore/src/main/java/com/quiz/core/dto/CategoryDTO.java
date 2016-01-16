package com.quiz.core.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
	
	private String catId;
	private String catName;
	private String catDesc;
	private List<CategoryDTO> subCateogies = new ArrayList<CategoryDTO>();
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public List<CategoryDTO> getSubCateogies() {
		return subCateogies;
	}
	public void setSubCateogies(List<CategoryDTO> subCateogies) {
		this.subCateogies = subCateogies;
	}
	@Override
	public String toString() {
		return "CategoryDTO [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", subCateogies="
				+ subCateogies + "]";
	}
	
}
