package com.assignment.omnirio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.omnirio.dto.ProductDetailsDto;
import com.assignment.omnirio.dto.ProductDto;
import com.assignment.omnirio.dto.ResponseObject;
import com.assignment.omnirio.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productServiceImpl;

	@PostMapping
	public ResponseEntity<ResponseObject> createProduct(@RequestBody ProductDto productDto) {

		productServiceImpl.createProduct(productDto);

		return new ResponseEntity<ResponseObject>(
				ResponseObject.builder().message("Category Created Successfully").build(), HttpStatus.CREATED);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductDetailsDto> getProduct(@PathVariable("productId") Long productId) {

		return new ResponseEntity<ProductDetailsDto>(productServiceImpl.getProduct(productId), HttpStatus.OK);
	}
}
