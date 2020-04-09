package com.cubic.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Rates {

	@Id
	private String pBarcode;
	private float rate;

	public Rates() {
	}

	public Rates(String pBarcode, float rate) {
		super();
		this.pBarcode = pBarcode;
		this.rate = rate;
	}

	public String getpBarcode() {
		return pBarcode;
	}

	public void setpBarcode(String pBarcode) {
		this.pBarcode = pBarcode;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
}
