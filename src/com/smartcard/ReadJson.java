package com.smartcard;

import java.util.List;

import org.json.simple.JSONArray;

import com.smartcard.Exception.SmartCardException;
import com.smartcard.model.Bill;
import com.smartcard.service.CalculateBill;
import com.smartcard.service.ProductList;

public class ReadJson extends ProductList {

	public static void main(String[] args) throws SmartCardException {

		ProductList products = new ProductList();
		CalculateBill calculateBill = new CalculateBill();

		JSONArray productList = products.getProductList();
		JSONArray selproductList = products.getSelectedProductList();

		List<Bill> totalItems = calculateBill.addProductsToBill(productList);
		
		if(totalItems.size()==0) {
			throw new SmartCardException("No products in the bill");
		}
		
		System.out.println("Total No. of Products are: ");
		System.out.println("-------------------------------");
		for (int i = 0; i < totalItems.size(); i++) {
			System.out.println(" productName : " + totalItems.get(i).getProductName()
					+ " || Selected No. of products : " + totalItems.get(i).getNoOfItems()
					+ " || Actual value of each product : " + totalItems.get(i).getEachProductCost()
					+ " || Total Cost of selected no. of products  : " + totalItems.get(i).getProductCost()
					+ " || ProductTax for selected no. of products : " + totalItems.get(i).getProductTax()
					+ "  || Actual total value of the selected products : " + totalItems.get(i).getTotalValue());

		}

		List<Bill> billItems = calculateBill.addProductsToBill(selproductList);

		System.out.println("\nSelected Items are :");
		System.out.println("-------------------------------");
		double totalCost = 0;
		double serviceTax = 0;
		for (int i = 0; i < billItems.size(); i++) {
			System.out.println(" Product Name : " + billItems.get(i).getProductName() + " || No. Of Items : "
					+ billItems.get(i).getNoOfItems() + " || Price : " + billItems.get(i).getProductCost());
			serviceTax = serviceTax + billItems.get(i).getProductTax();
			totalCost = totalCost + billItems.get(i).getProductCost();

		}
		totalCost = totalCost + serviceTax;
		System.out.println("-------------------------------");
		System.out.println("Service Tax    : " + serviceTax);
		System.out.println("-------------------------------");
		System.out.println("Total Bill     : " + totalCost);
	}
}
