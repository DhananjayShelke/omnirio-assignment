package com.assignment.omnirio.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDetailsDto {

	private String name;

	private List<CategoryAttributeDetaisDto> categoryAttributes;
}
