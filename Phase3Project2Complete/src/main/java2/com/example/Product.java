package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table
public class Product {
	
	@Id
	private int id;
	private int price;
	private String description;

	public Product() {}
	
	public Product(int id, int price, String description) {
		this.id=id;
		this.description=description;
		this.price=price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int id) {
		this.id = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
