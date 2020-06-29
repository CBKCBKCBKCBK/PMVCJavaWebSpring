package tw.com.pcschool.web.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tw.com.pcschool.web.model.User;

//@Configuration
//@ComponentScan(basePackages = "tw.com.pcschool.web.validation")
public class UserValidator implements Validator{

//	@Bean
//	public ReloadableResourceBundleMessageSource rrbmSource() {
//		ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
//		source.setBasenames("classpath:i18n/message");
//		return source;
//	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday","typeMismatch.user.birthday", "日期格式錯誤");
	}
}
