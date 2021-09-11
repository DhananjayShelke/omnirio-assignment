package com.assignment.omnirio.service;

import com.assignment.omnirio.dto.ProductDetailsDto;
import com.assignment.omnirio.dto.ProductDto;

public interface ProductService {

	void createProduct(ProductDto productDto);
	
	ProductDetailsDto getProduct(Long productId);
}
