package validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bean.Customer;

public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//only customer class is validate
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object targets, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uname", "required.userName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required.fullName", "Field name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pword", "required.pword", "Field name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confPword", "required.confPword", "Field name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favnumber", "required.favnumber", "Field name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Field name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNum", "required.mobileNum", "Field name is required");
		
		Customer cust = (Customer)targets;
		
		if(!(cust.getPword().equals(cust.getConfPword()))){
			errors.rejectValue("pword", "notMatch.pword");
		}
		
		if(cust.getWebFramework().length==0){
			errors.rejectValue("webFramework", "required.webFramework");
		}
		
		if("NONE".equals(cust.getCountry())){
			errors.rejectValue("country", "required.country");
		}
		
	}

}
