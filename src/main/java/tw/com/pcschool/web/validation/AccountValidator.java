package tw.com.pcschool.web.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import tw.com.pcschool.web.model.User;

public class AccountValidator {
	public void validate(User user,Errors errors) {
		String username=user.getUsername();
		if (StringUtils.hasLength(username)) {
			errors.rejectValue("username","","");
		}
	}
}
