package com.javatechie.exception;

import java.util.Date;

public class ApiError {
	
	private int errorCode;
	private String errorDescription;
	private Date date;
	
	public ApiError(int errorCode, String errorDescription, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.date = date;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
