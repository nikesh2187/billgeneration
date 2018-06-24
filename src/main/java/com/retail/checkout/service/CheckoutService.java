package com.retail.checkout.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.checkout.BO.CheckOutBO;
import com.retail.checkout.common.CommonUtils;
import com.retail.checkout.exception.CustomException;
import com.retail.checkout.model.CheckoutDetails;
import com.retail.checkout.model.Product;

@RestController
@RequestMapping("/checkout")
public class CheckoutService {
	
	@Autowired
	CheckOutBO checkout;
	
	
	@RequestMapping(value = "/generateBill", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> generateBill(@RequestBody CheckoutDetails cd) throws CustomException  {

		return checkout.generateBill(cd);
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProduct()  {
		
		Product p = new Product();
		p.setProductId(1);
		p.setCategory("category A");
		p.setPrice(25.3);
		p.setProductName("Tata Salt");
		p.setQuantity(3);
		
		Product p2 = new Product();
		p2.setProductId(2);
		p2.setCategory("category B");
		p2.setPrice(50.5);
		p2.setProductName("Polo T-Shirt");
		p2.setQuantity(1);
		
		Product p3 = new Product();
		p3.setProductId(3);
		p3.setCategory("category C");
		p3.setPrice(45);
		p3.setProductName("Saffola 1L Oil");
		p3.setQuantity(2);
		
		List<Product> products = new ArrayList<>();
		
		products.add(p);
		products.add(p2);
		products.add(p3);
		CheckoutDetails cd = new CheckoutDetails();
		
		cd.setProducts(products);
		cd.setCurrency("INR");
		
		
		return CommonUtils.getResponse(cd, MediaType.APPLICATION_JSON);
	
	}

}
