package com.cubic.service;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class Wrapper {
	
	private String barcode;
	private String name;
	private String description;
	private float price;
	private List<Float> rate;
	
	public Wrapper() {
	}
	
	public Wrapper(String barcode, String name, String description, float price, List<Float> rate) {
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
	public List<Float> getRate() {
		return rate;
	}
	public void setRate(List<Float> rate) {
		this.rate = rate;
	}
	
}

