package org.apache.struts.register.model;

public class Person {
	
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private String sport;
	private String gender;
	private Boolean over21;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Boolean getOver21() {
		return over21;
	}
	
	public void setOver21(Boolean over21) {
		this.over21 = over21;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("First Name: "+firstName);
		builder.append("Last Name: "+lastName);
		builder.append("email: "+email);
		builder.append("age: "+age);
		return builder.toString();
	}
}
