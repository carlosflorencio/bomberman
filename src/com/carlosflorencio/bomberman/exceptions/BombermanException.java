package com.carlosflorencio.bomberman.exceptions;

public class BombermanException extends Exception {
	public BombermanException() {
	}
	
	public BombermanException(String str) {
		super(str);
		
	}
	
	public BombermanException(String str, Throwable cause) {
		super(str, cause);
		
	}
	
	public BombermanException(Throwable cause) {
		super(cause);
		
	}

}
