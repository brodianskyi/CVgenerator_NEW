package com.codecentric.cvgenerator.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;


import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codecentric.cvgenerator.forms.UserLoginForm;

public class UserLoginFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserLoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserLoginForm form = (UserLoginForm)target;
		
		
	}

	
	
}
