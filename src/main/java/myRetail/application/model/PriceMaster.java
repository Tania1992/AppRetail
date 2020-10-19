package myRetail.application.model;

import java.io.Serializable;

public class PriceMaster implements Serializable{

	
	private static final long serialVersionUID = 1L;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int value;
	String currency;
	
	public PriceMaster(int id, int value, String currency) {
		super();
		this.id = id;
		this.value = value;
		this.currency = currency;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public PriceMaster() {
		
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "{value:" + value + ", currency_code:" + currency + "}";
	}
	
}
