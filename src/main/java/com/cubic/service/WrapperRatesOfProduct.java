package com.cubic.service;

import org.springframework.stereotype.Service;

@Service
public class WrapperRatesOfProduct{
	private String barcode;
	private String name;
	private String description;
	private float price;
	private float rate;
	
	public WrapperRatesOfProduct() {
	}
	
	public WrapperRatesOfProduct(String barcode, String name, String description, float price, float rate) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.price = price;
		this.rate = rate;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
}

