package com.assignment.omnirio.service;

import java.util.List;

import com.assignment.omnirio.dto.CategoryAttributeDto;
import com.assignment.omnirio.dto.CategoryDto;
import com.assignment.omnirio.entity.CategoryAttribute;

public interface CategoryService {

	void createCategory(CategoryDto categoryDto);

	void createCategoryAttributes(Long categoryId, CategoryAttributeDto categoryAttributeDto);

	List<CategoryAttribute> getCategoryAttributes(Long categoryId);
}
