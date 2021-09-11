package com.assignment.omnirio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.omnirio.dto.AttributeDto;
import com.assignment.omnirio.entity.Attribute;
import com.assignment.omnirio.repository.AttributeRepository;
import com.assignment.omnirio.service.AttributeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	private AttributeRepository attributeRepository;

	@Override
	@Transactional
	public void createAttribute(AttributeDto attributeDto) {

		Attribute attribute = new Attribute();

		attribute.setName(attributeDto.getName());
		attribute.setValue(attributeDto.getValue());

		attributeRepository.save(attribute);

		log.info("Attribute created successfully");
	}

}
