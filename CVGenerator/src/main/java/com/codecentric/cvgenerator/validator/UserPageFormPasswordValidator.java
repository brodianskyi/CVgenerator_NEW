package com.codecentric.cvgenerator.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codecentric.cvgenerator.forms.UserChangePasswordForm;
import com.codecentric.cvgenerator.forms.UserPageForm;

@Component
public class UserPageFormPasswordValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return  UserChangePasswordForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserChangePasswordForm   form = ( UserChangePasswordForm  )target;
		if (!form.getPassword_one().equals(form.getPassword_two())){
			errors.rejectValue("password_two", "user.error.password.no_match");
		}
		
	}

}
