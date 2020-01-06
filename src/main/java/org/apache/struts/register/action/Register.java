package org.apache.struts.register.action;

import java.util.Arrays;
import java.util.List;

import org.apache.struts.register.model.*;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private Person personBean;
	
	
	public List<Sport> getSports() {
		return Arrays.asList(Sport.values());
	}
	
	public List<Gender> getGenders() {
		return Arrays.asList(Gender.values());
	}
	
	public List<State> getStates() {
		return Arrays.asList(State.values());
	}
	
	public List<CarModels> getCarModels() {
		return Arrays.asList(CarModels.values());
	}
	
	@Override	
	public String execute() {
		
		return  INPUT;
	}
	
	@Override
	public void validate() {
		if(personBean.getFirstName().isEmpty()) {
			addFieldError("personBean.firstName", "Primeiro nome é requerido.");
		}
		if(personBean.getEmail().isEmpty()) {
			addFieldError("personBean.email", "Email é requerido.");
		}
		if(personBean.getAge() <18) {
			addFieldError("personBean.age", "Idade minima requerida é de 18 anos ou superior.");
		}
	}

	

	public Person getPersonBean() {
		return personBean;
	}


	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}
	
	
}
