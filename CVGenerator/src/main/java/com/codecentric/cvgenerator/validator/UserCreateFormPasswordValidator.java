package com.codecentric.cvgenerator.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codecentric.cvgenerator.api.entities.User;
import com.codecentric.cvgenerator.forms.UserCreateForm;
import com.codecentric.cvgenerator.forms.UserLoginForm;

@Component
public class UserCreateFormPasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserCreateForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCreateForm form = (UserCreateForm)target;
		if (!form.getPassword_one().equals(form.getPassword_two())){
			errors.rejectValue("password_two", "user.error.password.no_match");
		}
		
	}

}
