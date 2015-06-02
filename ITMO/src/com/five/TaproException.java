package com.five;

public class TaproException extends Exception {
	public TaproException() {
		super();
	}

	public TaproException(String response) {
		super(response);
	}
}