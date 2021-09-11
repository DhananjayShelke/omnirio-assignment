package com.assignment.omnirio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.omnirio.dto.CategoryAttributeDto;
import com.assignment.omnirio.dto.CategoryDto;
import com.assignment.omnirio.entity.Attribute;
import com.assignment.omnirio.entity.Category;
import com.assignment.omnirio.entity.CategoryAttribute;
import com.assignment.omnirio.repository.AttributeRepository;
import com.assignment.omnirio.repository.CategoryAttributeRepository;
import com.assignment.omnirio.repository.CategoryRepository;
import com.assignment.omnirio.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryAttributeRepository categoryAttributeRepository;

	@Autowired
	private AttributeRepository attributeRepository;

	@Override
	@Transactional
	public void createCategory(CategoryDto categoryDto) {

		Category category = new Category();

		category.setName(categoryDto.getName());

		categoryRepository.save(category);

		log.info("Category Created Succfully");
	}

	@Override
	@Transactional
	public void createCategoryAttributes(Long categoryId, CategoryAttributeDto categoryAttributeDto) {

		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {

			categoryAttributeDto.getListOfAttributeIds().stream().forEach(attributeId -> {

				Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);

				if (!optionalAttribute.isPresent())
					throw new RuntimeException(String.format("Attribute not found with %d id", attributeId));

				CategoryAttribute categoryAttribute = new CategoryAttribute();

				categoryAttribute.setAttribute(optionalAttribute.get());
				categoryAttribute.setCategory(optionalCategory.get());

				categoryAttributeRepository.save(categoryAttribute);

				log.info("Category Attribute Created Succfully");

			});

		} else {
			throw new RuntimeException(String.format("Category not found with %d id", categoryId));

		}

	}

	@Override
	@Transactional
	public List<CategoryAttribute> getCategoryAttributes(Long categoryId) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get().getCategoryAttributes();
		} else {
			throw new RuntimeException(String.format("Category not found with %d id", categoryId));

		}
	}

}
