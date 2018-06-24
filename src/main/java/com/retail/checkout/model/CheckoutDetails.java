package com.retail.checkout.model;

import java.util.List;

public class CheckoutDetails {
	
	private List<Product> products;
	private String currency ;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
