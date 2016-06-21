package com.codecentric.cvgenerator.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserLoginForm {
	
	@NotEmpty(message = "Schreiben Sie bitte Ihre Email.")
	@Email(message = "Falsches E-Mail-Format.")
	private String email;
	
	@NotEmpty(message = "Schreiben Sie bitte Ihr Password.")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
