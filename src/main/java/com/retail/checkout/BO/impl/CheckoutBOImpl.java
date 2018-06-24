package com.retail.checkout.BO.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.retail.checkout.BO.CheckOutBO;
import com.retail.checkout.common.CommonUtils;
import com.retail.checkout.exception.CustomException;
import com.retail.checkout.exception.InvalidCategoryException;
import com.retail.checkout.exception.InvalidPriceException;
import com.retail.checkout.exception.InvalidProductNameException;
import com.retail.checkout.exception.ProductNotExistsException;
import com.retail.checkout.model.BillDetails;
import com.retail.checkout.model.CheckoutDetails;
import com.retail.checkout.model.Product;

@Component
public class CheckoutBOImpl implements CheckOutBO {

	private static Map<Long, Product> sampleData = new HashMap<>();
	private static Map<String, Long> categoryWiseTax = new HashMap<>();

	static {//This data will be fetched from database in production. For Testing purpose storing sample data in Map
		Product p = new Product();
		long sampleProductId1 = 1;
		p.setProductId(sampleProductId1);
		p.setCategory("category A");
		p.setPrice(25.3);
		p.setProductName("Tata Salt");

		Product p2 = new Product();

		long sampleProductId2 = 2;
		p2.setProductId(sampleProductId2);
		p2.setCategory("category B");
		p2.setPrice(50.5);
		p2.setProductName("Polo T-Shirt");

		Product p3 = new Product();
		long sampleProductId3 = 3;
		p3.setProductId(sampleProductId3);
		p3.setCategory("category C");
		p3.setPrice(45);
		p3.setProductName("Saffola 1L Oil");

		sampleData.put(sampleProductId1, p);
		sampleData.put(sampleProductId2, p2);
		sampleData.put(sampleProductId3, p3);

		categoryWiseTax.put("category A", 10l);
		categoryWiseTax.put("category B", 20l);
		categoryWiseTax.put("category C", 0l);
	}

	@Override
	public ResponseEntity<Object> generateBill(CheckoutDetails cd) throws CustomException {

		double totalBillAmt = 0;
		double totalSalesTax = 0;
		double totalSumAmountOfAllProducts = 0;
		long totalProductCount = 0;
		long totalQuantity = 0;

		for (Product p : cd.getProducts()) {
			checkProductDetails(p);
			totalSumAmountOfAllProducts += (p.getPrice()*p.getQuantity());
			totalSalesTax += salesTaxCalc(p);
			totalQuantity += p.getQuantity();
			totalProductCount++;
		}
		
		BigDecimal bigD = new BigDecimal(totalSalesTax);
		bigD = bigD.setScale(2, RoundingMode.HALF_UP);
		
		totalBillAmt = totalSumAmountOfAllProducts + bigD.doubleValue();

		BillDetails bd = new BillDetails();
		bd.setTotalBillAmt(totalBillAmt);
		bd.setTotalProductCount(totalProductCount);
		bd.setTotalQuantity(totalQuantity);
		bd.setTotalSalesTax(bigD.doubleValue());
		bd.setTotalSumAmountOfAllProducts(totalSumAmountOfAllProducts);
		bd.setCurrency(cd.getCurrency());//Internationalization

		return CommonUtils.getResponse(bd, MediaType.APPLICATION_JSON);
	}

	private double salesTaxCalc(Product p) {

		long taxPercent = categoryWiseTax.get(p.getCategory());

		double taxAmount = 0.0;

		if (taxPercent != 0.0)
			taxAmount = (taxPercent * p.getPrice()*p.getQuantity()) / 100;

		return taxAmount;
	}

	private boolean checkProductDetails(Product p) throws CustomException {

		if (sampleData.containsKey(p.getProductId())) {

			Product originalProduct = sampleData.get(p.getProductId());
			if (originalProduct.getCategory().equals(p.getCategory())) {
				if (originalProduct.getPrice() == p.getPrice()) {
					if (originalProduct.getProductName().equals(p.getProductName())) {
						return true;
					} else
						throw new InvalidProductNameException("Invalid Product name : " + p.getProductName());
				} else
					throw new InvalidPriceException("Price is different for product : " + p.getProductName());

			} else
				throw new InvalidCategoryException("Invalid Category Id.... for product : " + p.getProductName());

		} else
			throw new ProductNotExistsException("Invalid Product Id...." + p.getProductId());
	}

}
