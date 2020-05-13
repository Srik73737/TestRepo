package com.srik.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseDetails<T> {
	
	private HttpStatus status;
	private String errorMessage;
	private String errorDetails;
	private List<T> result;
	
	
	
	public ResponseDetails() {
		super();
	}

	public ResponseDetails(HttpStatus status, String errorMessage, String errorDetails, List<T> result) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
		this.result = result;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	

}
