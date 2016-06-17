package com.codecentric.cvgenerator.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codecentric.cvgenerator.forms.UserLoginForm;

public class UserLoginFormPasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserLoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserLoginForm form = (UserLoginForm)target;
		if (!form.getPassword1().equals(form.getPassword2())){
			errors.rejectValue("password2", "user.error.password.no_match");
		}
		
	}

}
