package com.tpssoft.retro.dto;

public class MessageResponse {
	private String message;
	private Long id;


	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}