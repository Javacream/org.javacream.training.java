package org.javacream.training.java.basic;

public class Responder{
	
	private String message;
	
	public String ping() {
		
		//throw new UnsupportedOperationException("not yet implemented");
		return message;
	}

	public Responder(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Responder [message=" + message + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
