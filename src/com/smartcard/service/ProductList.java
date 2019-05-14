package com.smartcard.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.smartcard.model.Product;


public class ProductList {

	// JSON parser object to parse read file
		@SuppressWarnings("unchecked")
		public JSONArray getProductList() {

			JSONParser jsonParser = new JSONParser();
			JSONArray productList = null;

			try (FileReader reader = new FileReader("products.json")) {
				
				JSONObject obj = (JSONObject) jsonParser.parse(reader);
				productList = (JSONArray) obj.get("products");
				
				productList.forEach(product -> parseProductObject((JSONObject) product));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return productList;
		}
		@SuppressWarnings("unchecked")
		public JSONArray getSelectedProductList() {
			JSONParser jsonParser = new JSONParser();
			JSONArray selproductList = null;

			try (FileReader reader = new FileReader("selectedProducts.json")) {
				
				JSONObject obj = (JSONObject) jsonParser.parse(reader);
				selproductList = (JSONArray) obj.get("products");
				
				selproductList.forEach(product -> parseProductObject((JSONObject) product));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return selproductList;
			
		}
		public void parseProductObject(JSONObject productObject) {
			// Get product object within list
			//JSONObject productObject = (JSONObject) product.get("products");

			Gson gson = new Gson();
			Product product = gson.fromJson(productObject.toString(), Product.class);
			
			int id = product.getId();
			String barCodeId = product.getBarCodeId();
			String name = product.getName();
			String productCategory = product.getProductCategory();
			double rate = product.getRate();
			int quantity = product.getQuantity();

		//	System.out.println(" Product Details are: " + id + barCodeId + name + productCategory + rate + quantity);
		}

}
