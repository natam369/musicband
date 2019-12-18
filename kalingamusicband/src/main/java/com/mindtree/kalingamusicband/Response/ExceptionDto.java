package com.mindtree.kalingamusicband.Response;

public class ExceptionDto {
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	public ExceptionDto(String message) {
		super();
		this.message = message;
	}

	public ExceptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
