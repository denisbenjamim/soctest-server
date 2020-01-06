package org.apache.struts.register.model;

public enum State {
	AZ,CA,FL,KS,NY;
	
	public String toString(){
		switch(valueOf(name())) {
			case AZ : return "Arizona";
			case CA : return "California";
			case FL : return "Florida";
			case KS : return "Kansas";
			case NY : return "New York";
		}
		return super.toString();
	}
}
