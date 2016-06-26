package com.codecentric.cvgenerator.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class UserChangePasswordForm {
	
	@NotEmpty(message = "Schreiben Sie bitte Ihr Password.")
	private String password_one;
	@NotEmpty(message = "Schreiben Sie bitte Ihr Password noch einmal.")
	private String password_two;
	
	public String getPassword_one() {
		return password_one;
	}
	public void setPassword_one(String password_one) {
		this.password_one = password_one;
	}
	public String getPassword_two() {
		return password_two;
	}
	public void setPassword_two(String password_two) {
		this.password_two = password_two;
	}
	
	

}
