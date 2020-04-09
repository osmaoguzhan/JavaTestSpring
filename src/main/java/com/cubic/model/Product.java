package com.cubic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Product {
	
	@Id
	private String barcode;
	private String name;
	private String description;
	private float price;
	
	//@OneToMany(mappedBy = "product",targetEntity=Rates.class)
	//private float rates;
	
	
	
	
	public Product(String barcode, String name, String description, float price, float rates) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.price = price;
		//this.rates = rates;
	}




	public Product() {
	}

	/*public float getRates() {
		return rates;
	}




	public void setRates(float rates) {
		this.rates = rates;
	}
*/



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
	
	
}
