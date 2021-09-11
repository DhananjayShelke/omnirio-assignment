package com.assignment.omnirio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.omnirio.dto.AttributeDto;
import com.assignment.omnirio.dto.ResponseObject;
import com.assignment.omnirio.service.AttributeService;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

	@Autowired
	private AttributeService attributeServiceImpl;

	@PostMapping
	public ResponseEntity<ResponseObject> createAttribute(@RequestBody AttributeDto attributeDto) {

		attributeServiceImpl.createAttribute(attributeDto);

		return new ResponseEntity<ResponseObject>(
				ResponseObject.builder().message("Attribute Created Successfully").build(), HttpStatus.CREATED);
	}
}
