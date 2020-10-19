package myRetail.application.model;

import java.io.Serializable;

public class PriceMasterDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	int value;
	String currency_code;
	public PriceMasterDTO(int value, String currency_code) {
		super();
		this.value = value;
		this.currency_code = currency_code;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}


	public PriceMasterDTO() {
		
	}
	
	
}
