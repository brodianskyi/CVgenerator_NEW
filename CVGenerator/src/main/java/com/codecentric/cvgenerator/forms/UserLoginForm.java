package com.codecentric.cvgenerator.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLoginForm {
	
	@NotNull
	@NotEmpty(message = "Schreiben Sie bitte Ihr Username.")
	private String name;
	@NotEmpty(message = "Schreiben Sie bitte Ihr Password.")
	private String password1;
	private String password2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
}
