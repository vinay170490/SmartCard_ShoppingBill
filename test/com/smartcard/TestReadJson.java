package com.smartcard;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.smartcard.Exception.SmartCardException;
import com.smartcard.model.Bill;
import com.smartcard.service.CalculateBill;
import com.smartcard.service.ProductList;


//@RunWith(MockitoJUnitRunner.class)
public class TestReadJson {
	
	@InjectMocks
	ReadJson readJson;

	JSONArray products;
	JSONArray selectedProducts;
	List<Bill> billList = new ArrayList<Bill>();
	
	@Before
	public void setUp() throws IOException, ParseException {
		MockitoAnnotations.initMocks(ReadJson.class);
		
		JSONParser jsonParser = new JSONParser();
		
		FileReader productsReader = new FileReader("products.json");
		JSONObject productsObject = (JSONObject) jsonParser.parse(productsReader);
		products = (JSONArray) productsObject.get("products");
		
		FileReader selectedProductsReader = new FileReader("selectedProducts.json");
		JSONObject selectedProductsObject = (JSONObject) jsonParser.parse(selectedProductsReader);
		selectedProducts = (JSONArray) selectedProductsObject.get("products");
	}
	
	@Test
	public void testProductList() throws SmartCardException {
		ReadJson readJson = new ReadJson();
		ProductList productList = mock(ProductList.class);
		CalculateBill calculateBill = mock(CalculateBill.class);
		
		when(productList.getProductList()).thenReturn(products);
		Mockito.doThrow(new RuntimeException()).when(productList).parseProductObject(any(JSONObject.class));

		when(calculateBill.computeTax(anyDouble(), anyString())).thenReturn(new Double(0));
		when(calculateBill.addProductsToBill(products)).thenReturn(billList);
		assertEquals(readJson.getProductList(), products);
		
	}

}
