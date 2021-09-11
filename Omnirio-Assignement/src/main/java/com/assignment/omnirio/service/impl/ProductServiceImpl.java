package com.assignment.omnirio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.omnirio.dto.CategoryAttributeDetaisDto;
import com.assignment.omnirio.dto.CategoryDetailsDto;
import com.assignment.omnirio.dto.ProductDetailsDto;
import com.assignment.omnirio.dto.ProductDto;
import com.assignment.omnirio.entity.Category;
import com.assignment.omnirio.entity.CategoryAttribute;
import com.assignment.omnirio.entity.Product;
import com.assignment.omnirio.repository.CategoryRepository;
import com.assignment.omnirio.repository.ProductRepository;
import com.assignment.omnirio.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public void createProduct(ProductDto productDto) {

		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
		if (optionalCategory.isPresent()) {

			Product product = new Product();

			product.setName(productDto.getName());
			product.setCategory(optionalCategory.get());

			productRepository.save(product);

			log.info("Product created Successfully");

		} else {
			throw new RuntimeException(String.format("Category not found with %d Id", productDto.getCategoryId()));
		}
	}

	@Override
	@Transactional
	public ProductDetailsDto getProduct(Long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isPresent()) {
			ProductDetailsDto productDetailsDto = new ProductDetailsDto();

			Product product = optionalProduct.get();

			productDetailsDto.setName(product.getName());

			Category category = product.getCategory();

			CategoryDetailsDto categoryDetailsDto = new CategoryDetailsDto();
			categoryDetailsDto.setName(category.getName());

			List<CategoryAttribute> listOfCategoryAttributes = category.getCategoryAttributes();

			List<CategoryAttributeDetaisDto> listOfCategoryAttributeDetaisDto = listOfCategoryAttributes.stream()
					.map(categoryAttribute -> categoryAttribute.getAttribute()).map(attribute -> {
						CategoryAttributeDetaisDto categoryAttributeDetaisDto = new CategoryAttributeDetaisDto();
						categoryAttributeDetaisDto.setAttribute(attribute);

						return categoryAttributeDetaisDto;
					}).collect(Collectors.toList());

			categoryDetailsDto.setCategoryAttributes(listOfCategoryAttributeDetaisDto);

			productDetailsDto.setCategoryDetails(categoryDetailsDto);
			
			return productDetailsDto;

		} else {
			throw new RuntimeException(String.format("Product not found with %d id", productId));
		}
		
	}

}
