package com.assignment.omnirio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CategoryAttribute> categoryAttributes = new ArrayList<CategoryAttribute>();

	public void addAttribute(CategoryAttribute attribute) {
		this.categoryAttributes.add(attribute);
	}

	public void removeAtribute(CategoryAttribute attribute) {
		this.categoryAttributes.remove(attribute);
	}
}
