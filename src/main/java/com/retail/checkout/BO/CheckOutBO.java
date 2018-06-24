package com.retail.checkout.BO;

import org.springframework.http.ResponseEntity;

import com.retail.checkout.exception.CustomException;
import com.retail.checkout.model.CheckoutDetails;

public interface CheckOutBO {
	
	ResponseEntity<Object> generateBill(CheckoutDetails cd) throws CustomException; 

}
