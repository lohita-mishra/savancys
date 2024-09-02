package com.sapnexx.common.validator.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

@Component(service = InputValidator.class)
public class InputValidator {

	// Validate text field and text area (common validation: alphabetic characters)
    public static boolean isValidText(String input) {    	
    	if(input == null ) {return false;}
    	String inputregex="^[a-zA-Z]*$";
        return input.matches(inputregex);
    }

    public static boolean isValidCompanyName(String input) {
    	
        // Perform common validation logic for text field and text area (only alphabetic characters allowed)
        return input.matches("^[a-zA-Z]*$");
    }

    // Validate text area with maximum length of 300 characters
    public static boolean isValidTextArea(String input) {
        // Perform validation logic for text area (maximum 300 characters)
        return isValidText(input) && input.length() <= 300;
    }

    // Validate email address
    public static boolean isValidEmail(String email) {
    	if(email == null ) {return false;}
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

   
    // Validate phone number
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) return false;
        String regex = "^[0-9]{10}$";
        return phoneNumber.matches(regex);
    }

    private boolean validateText(String input, String fieldName, ActionRequest actionRequest) {
	    if (input == null) {
	        SessionErrors.add(actionRequest, "empty-" + fieldName);
	        return false;
	    }
	    
	    if (!input.matches("^(?!.*[<>;\"'&%#@\\$]).*$")) {
	        SessionErrors.add(actionRequest, "invalid-" + fieldName);
	        return false;
	    }
	    return true;
	}
    
    private static final Log log = LogFactoryUtil.getLog(InputValidator.class.getName());
}
