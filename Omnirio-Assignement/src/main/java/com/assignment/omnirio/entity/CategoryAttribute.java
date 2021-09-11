package com.assignment.omnirio.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class CategoryAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "cateroryId", referencedColumnName = "id")
	private Category category;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "attributeId", referencedColumnName = "id")
	private Attribute attribute;
}
