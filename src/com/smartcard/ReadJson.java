package com.smartcard;

import java.util.List;

import org.json.simple.JSONArray;

import com.smartcard.model.Bill;
import com.smartcard.service.CalculateBill;
import com.smartcard.service.ProductList;

public class ReadJson extends ProductList {

	public static void main(String[] args) {
		
		ProductList products = new ProductList();
		CalculateBill calculateBill = new CalculateBill();
		
		JSONArray productList = products.getProductList();
		List<Bill> billItems = calculateBill.addProductsToBill(productList);
	
		System.out.println("Selected Items are :");
		double totalCost = 0;
		double serviceTax = 0;
 for(int i = 0; i<billItems.size();i++) {
	 System.out.println(billItems.get(i).getProductName()+" "+
			 billItems.get(i).getNoOfItems()+" "+billItems.get(i).getProductCost());
	 		serviceTax = serviceTax+billItems.get(i).getProductTax();
	 		totalCost = totalCost + billItems.get(i).getProductCost();
	 
 	}
 	totalCost = totalCost+serviceTax;
	System.out.println("Service Tax : " + serviceTax);
	System.out.println("Total Bill : " + totalCost);
	}
}
