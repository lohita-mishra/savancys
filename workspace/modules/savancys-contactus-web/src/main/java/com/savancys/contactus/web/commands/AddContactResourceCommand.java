package com.savancys.contactus.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sapnexx.common.validator.util.InputValidator;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;
import com.savancys.service.ContactUsLocalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + SavancysContactUsPortletKeys.SAVANCYSCONTACTUS,
		"mvc.command.name=addContactUs" }, service = MVCResourceCommand.class)
public class AddContactResourceCommand implements MVCResourceCommand {

	private Log log = LogFactoryUtil.getLog(AddContactResourceCommand.class);

	@Reference
	private ContactUsLocalService contactUsLocalService;

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		log.info("serve resource");
		String inquiryType = ParamUtil.getString(resourceRequest, "inquiryType");
		String firstName = ParamUtil.getString(resourceRequest, "firstName");
		String lastName = ParamUtil.getString(resourceRequest, "lastName");
		String phoneNumber = ParamUtil.getString(resourceRequest, "phoneNumber");
		String email = ParamUtil.getString(resourceRequest, "email");
		String companyName = ParamUtil.getString(resourceRequest, "companyName");
		String country = ParamUtil.getString(resourceRequest, "country");
		String additionalInfo = ParamUtil.getString(resourceRequest, "additionalInfo");
		resourceResponse.setContentType("text/html");
		PrintWriter out;
		try {
			contactUsLocalService.addContact(inquiryType, firstName, lastName, phoneNumber, email, companyName, country,
					additionalInfo);
			out = resourceResponse.getWriter();
			out.println("successfully submitted.");
		} catch (IOException e) {
			log.error(e.getMessage());
		}

		log.info("added");

		return false;
	}
	/*
	 * // Method to validate input fields private Map<String, String>
	 * validateFields(String firstName, String lastName, String phoneNumber, String
	 * email, String country, String additionalInfo) { Map<String, String> errors =
	 * new HashMap<>();
	 * 
	 * // Check if each field is required and valid if
	 * (!InputValidator.isFieldRequired(firstName)) {
	 * errors.put("required-firstName", "First name is required"); } else if
	 * (!InputValidator.isValidText(firstName)) { errors.put("invalid-firstName",
	 * "First name is invalid"); }
	 * 
	 * if (!InputValidator.isFieldRequired(lastName)) {
	 * errors.put("required-lastName", "Last name is required"); } else if
	 * (!InputValidator.isValidText(lastName)) { errors.put("invalid-lastName",
	 * "Last name is invalid"); }
	 * 
	 * if (!InputValidator.isFieldRequired(phoneNumber)) {
	 * errors.put("required-phoneNumber", "Phone number is required"); } else if
	 * (!InputValidator.isValidGlobalPhoneNumber(phoneNumber)) {
	 * errors.put("invalid-phoneNumber", "Phone number is invalid"); }
	 * 
	 * if (!InputValidator.isFieldRequired(email)) { errors.put("required-email",
	 * "Email is required"); } else if (!InputValidator.isValidEmail(email)) {
	 * errors.put("invalid-email", "Email is invalid"); }
	 * 
	 * if (!InputValidator.isFieldRequired(country)) {
	 * errors.put("required-country", "Country is required"); } else if
	 * (!InputValidator.isValidText(country)) { errors.put("invalid-country",
	 * "Country is invalid"); }
	 * 
	 * if (!InputValidator.isValidTextArea(additionalInfo)) {
	 * errors.put("invalid-additionalInfo", "Additional info is invalid"); }
	 * 
	 * return errors; }
	 */
}
