package org.apache.struts.register.model;

public enum CarModels {
	FORD,CHRYSLER,TOYOTA,NISSAN;
	
	public String toString(){
		switch(valueOf(name())) {
			case CHRYSLER : return "Cherysler";
			case FORD : return "Ford";
			case NISSAN : return "Nissan";
			case TOYOTA : return "Toyota";
			
		}
		return super.toString();
	}
}
