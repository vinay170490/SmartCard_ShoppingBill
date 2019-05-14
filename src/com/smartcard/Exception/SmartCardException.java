package com.smartcard.Exception;

public class SmartCardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SmartCardException(){
		super();
	}
	
	public SmartCardException(String string) {
		System.out.println("Error Reason is : "+ string);
	}

	public SmartCardException(Exception e) {
		System.out.println(e.getMessage() + e.getStackTrace());
	}
}
