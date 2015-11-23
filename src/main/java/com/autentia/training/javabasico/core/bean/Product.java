package com.autentia.training.javabasico.core.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

	private String name;
	private String description;
	private BigDecimal price;
	
	public Product() {
	}

	public static Product valueOf(String name, String description, BigDecimal price) {
		Product p = new Product();
		p.setName(name);
		p.setDescription(description);
		p.setPrice(price);
		return p;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		price.setScale(2, RoundingMode.CEILING);
		this.price = price;
	}
	
}
