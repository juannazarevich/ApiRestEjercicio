package com.juannaza.exam.exceptions.model;

public class ErrorInfo {

	public final String errorCode;
    public final String errorMessage;
    
    public ErrorInfo(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
