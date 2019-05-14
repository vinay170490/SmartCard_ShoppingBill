package com.smartcard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONArray;

import com.google.gson.Gson;
import com.smartcard.Exception.SmartCardException;
import com.smartcard.model.Bill;
import com.smartcard.model.Product;

public class CalculateBill {

	public List<Bill> addProductsToBill(JSONArray products) throws SmartCardException {
		Gson gson = new Gson();
		AtomicLong id = new AtomicLong(10000000000L);
		List<Bill> lineItems = new ArrayList<Bill>();
		
		for(int i=0; i<products.size(); i++) {
			Product product = gson.fromJson(products.get(i).toString(), Product.class);
			Double productTotalCost = product.getRate()*product.getQuantity();
			Bill bill = new Bill();
			bill.setNoOfItems(product.getQuantity());
			bill.setEachProductCost(product.getRate());
			bill.setProductCost(productTotalCost);
			bill.setProductName(product.getName());
			bill.setProductTax(computeTax(productTotalCost,product.getProductCategory()));
			bill.setTotalValue(bill.getProductCost() + bill.getProductTax());
			
			lineItems.add(bill);
				
		}
		long billId = id.getAndIncrement();
		for(int i=0; i<lineItems.size(); i++) {
			lineItems.get(i).setId(billId);
		}

		return lineItems;
		

	}
	public double computeTax(double productTotalCost, String productCategory) throws SmartCardException {
		
		double saleValue = 0;
		if (productCategory.equals("A")) {
			saleValue = productTotalCost * 0.1; // 10% levy

		} else if (productCategory.equals("B")) {
			saleValue = productTotalCost * 0.2; // 20% levy

		} else if (productCategory.equals("C")) {
			saleValue = 0;
		}
		else {
			throw new SmartCardException("Invalid Product Category");
		}
		return saleValue;
	}


}
