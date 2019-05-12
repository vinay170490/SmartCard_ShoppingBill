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
	

		System.out.println("Total Bill is "+ billItems.toString());
	}
}
