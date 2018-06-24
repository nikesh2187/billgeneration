package com.retail.checkout.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.retail.checkout.common.Constants;

@ControllerAdvice
@Configuration
public class CheckoutExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckoutExceptionHandler.class);
	

	public CheckoutExceptionHandler() {
	}
	
	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public ResponseEntity<String> handleCustomException(CustomException ce) {
		logger.error(ExceptionUtils.getStackTrace(ce));
		return response(ce.getMessage(), HttpStatus.valueOf(ce.getErrorId()));
	}
	
	private ResponseEntity<String> response(String errorMsg, HttpStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.AccessControl.ALLOW_ORIGIN, Constants.ASTERISK);
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		return new ResponseEntity<>(errorMsg, headers, status);
	}

}
