package com.retail.checkout.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class CommonUtils {



	public static ResponseEntity<Object> getResponse(Object response, MediaType mediaType) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.AccessControl.ALLOW_ORIGIN, Constants.ASTERISK);
		headers.setContentType(mediaType);
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}

	public static ResponseEntity<String> getResponseString(String response, MediaType mediaType) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.AccessControl.ALLOW_ORIGIN, Constants.ASTERISK);
		headers.setContentType(mediaType);
		return new ResponseEntity<String>(response, headers, HttpStatus.OK);
	}

	public static ResponseEntity<Object> getResponseError(Object e, HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.AccessControl.ALLOW_ORIGIN, Constants.ASTERISK);
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<>(e, headers, httpStatus);
	}












}
