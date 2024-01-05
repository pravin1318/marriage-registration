package com.Spring.Response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class response<T> implements Serializable {
	private HttpStatus code;
	private String message;
	private Object object;
	public HttpStatus getCode() {
		return code;
	}
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public response(HttpStatus code, String message, Object object) {
		super();
		this.code = code;
		this.message = message;
		this.object = object;
	}
	public response() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
