package org.apache.struts.helloworld.model;

public class MessageStore {
	private String message;
	
	public MessageStore() {
		this.message = "Hello Struts User";
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public String toString() {
	    return message + " (from toString)";
	}
}
