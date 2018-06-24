package com.retail.checkout.model;

public class BillDetails {
	
	private double totalBillAmt;
	private double totalSalesTax;
	private double totalSumAmountOfAllProducts;
	private long totalProductCount;
	private long totalQuantity;
	private String currency;
	
	
	public double getTotalBillAmt() {
		return totalBillAmt;
	}
	public void setTotalBillAmt(double totalBillAmt) {
		this.totalBillAmt = totalBillAmt;
	}
	public double getTotalSalesTax() {
		return totalSalesTax;
	}
	public void setTotalSalesTax(double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}
	public double getTotalSumAmountOfAllProducts() {
		return totalSumAmountOfAllProducts;
	}
	public void setTotalSumAmountOfAllProducts(double totalSumAmountOfAllProducts) {
		this.totalSumAmountOfAllProducts = totalSumAmountOfAllProducts;
	}
	public long getTotalProductCount() {
		return totalProductCount;
	}
	public void setTotalProductCount(long totalProductCount) {
		this.totalProductCount = totalProductCount;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	

}
