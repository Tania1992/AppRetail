package myRetail.application.model;

import java.io.Serializable;

public class ErrorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	String message;

	public ErrorDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorDTO() {
		
	}
	
}
