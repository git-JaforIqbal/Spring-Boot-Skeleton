package com.project.citysite.callcentermgm.entity;

public class MainBean {
	
	public String message;

	public String getMessage() {
		return message;
	}

	public MainBean(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MainBean [message=" + message + "]";
	}
	
	
	
}
