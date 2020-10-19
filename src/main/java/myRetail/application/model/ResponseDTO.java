package myRetail.application.model;

import java.io.Serializable;

public class ResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	PriceMasterDTO price;
	
	@Override
	public String toString() {
		return "ResponseDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public ResponseDTO() {
		
	}
	public ResponseDTO(int id, String name, PriceMasterDTO price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PriceMasterDTO getPrice() {
		return price;
	}
	public void setPrice(PriceMasterDTO price) {
		this.price = price;
	}
}
