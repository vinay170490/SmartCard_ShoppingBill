package com.smartcard.model;

public class Bill {

	
	private long id;
	
	private String productName;
	private int noOfItems;
	private double eachProductCost;
	private double productCost;
	private double productTax;
	private double totalValue;
	
	public Bill() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double totalCost) {
		this.productCost = totalCost;
	}

	public double getProductTax() {
		return productTax;
	}

	public void setProductTax(double totalTax) {
		this.productTax = totalTax;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return " productName=" + productName + ", noOfItems=" + noOfItems + ", productCost="
				+ productCost + ", productTax=" + productTax + ", totalValue=" + totalValue ;
	}

	public double getEachProductCost() {
		return eachProductCost;
	}

	public void setEachProductCost(double d) {
		this.eachProductCost = d;
	}

}
