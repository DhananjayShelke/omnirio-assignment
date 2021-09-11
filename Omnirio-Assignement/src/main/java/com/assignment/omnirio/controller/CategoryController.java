package com.assignment.omnirio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.omnirio.dto.CategoryAttributeDto;
import com.assignment.omnirio.dto.CategoryDto;
import com.assignment.omnirio.dto.ResponseObject;
import com.assignment.omnirio.entity.CategoryAttribute;
import com.assignment.omnirio.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryServiceImpl;

	@PostMapping
	public ResponseEntity<ResponseObject> createCategory(@RequestBody CategoryDto categoryDto) {

		categoryServiceImpl.createCategory(categoryDto);

		return new ResponseEntity<ResponseObject>(
				ResponseObject.builder().message("Category Created Successfully").build(), HttpStatus.CREATED);
	}

	@PostMapping("/{categoryId}/attributes")
	public ResponseEntity<ResponseObject> createCategoryAttributes(@PathVariable("categoryId") Long categoryId,
			@RequestBody CategoryAttributeDto categoryAttributeDto) {

		categoryServiceImpl.createCategoryAttributes(categoryId, categoryAttributeDto);
		return new ResponseEntity<ResponseObject>(
				ResponseObject.builder().message("Category Attributes Created Successfully").build(),
				HttpStatus.CREATED);
	}

	@GetMapping("/{categoryId}/attributes")
	public ResponseEntity<List<CategoryAttribute>> getCategoryAttributes(@PathVariable("categoryId") Long categoryId) {

		return new ResponseEntity<List<CategoryAttribute>>(categoryServiceImpl.getCategoryAttributes(categoryId),
				HttpStatus.OK);
	}
}
