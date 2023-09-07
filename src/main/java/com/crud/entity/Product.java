
package com.crud.entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Product_tb")
public class Product {

	@Id
	@GeneratedValue
	int id;
	String name;
	double price;
	
	private Long timestampMillis;

	private UUID uId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public UUID getuId() {
		return uId;
	}
	public void setuId(UUID uId) {
		this.uId = uId;
	}
	public Long getTimestampMillis() {
		return timestampMillis;
	}
	public void setTimestampMillis(Long timestampMillis) {
		this.timestampMillis = timestampMillis;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
