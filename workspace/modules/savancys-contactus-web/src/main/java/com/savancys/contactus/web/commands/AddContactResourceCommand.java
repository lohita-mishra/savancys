package com.savancys.contactus.web.commands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;
import com.savancys.service.ContactUsLocalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		String captchaFormValue = ParamUtil.getString(resourceRequest, "captchaText");
		HttpSession httpSession = getHttpSession(httpServletRequest);
		String captchaText = getCaptchaValueFromSession(httpSession);
		log.info("captchaFormValue: " + captchaFormValue);
		log.info("captchaText: " + captchaText);

		try (PrintWriter out = resourceResponse.getWriter()) {
			if (!captchaText.equals(captchaFormValue)) {
				jsonResponse.put("status", "error");
				jsonResponse.put("message", "CAPTCHA verification failed.");
				log.error("CAPTCHA verification failed.");
				log.info("jsonResponse" + jsonResponse.toString());
				out.print(jsonResponse.toString());
				out.flush();
				return false;
			}

			String inquiryType = ParamUtil.getString(resourceRequest, "inquiryType");
			String firstName = ParamUtil.getString(resourceRequest, "firstName");
			String lastName = ParamUtil.getString(resourceRequest, "lastName");
			String phoneNumber = ParamUtil.getString(resourceRequest, "phoneNumber");
			String email = ParamUtil.getString(resourceRequest, "email");
			String companyName = ParamUtil.getString(resourceRequest, "companyName");
			String country = ParamUtil.getString(resourceRequest, "country");
			String additionalInfo = ParamUtil.getString(resourceRequest, "additionalInfo");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
			long groupId = themeDisplay.getScopeGroupId();
			contactUsLocalService.addContact(groupId, inquiryType, firstName, lastName, phoneNumber, email, companyName,
					country, additionalInfo);
			}catch(Exception e) {
				log.info("err"+e.getMessage());
			}
			jsonResponse.put("status", "success");
			jsonResponse.put("message", "Successfully submitted.");

			out.print(jsonResponse.toString());
			out.flush();

			log.info("Form processed successfully.");
		} catch (IOException e) {
			log.error("Error writing JSON response: " + e.getMessage());
		} catch (Exception e) {
			log.error("Error while adding contact: " + e.getMessage());
		}

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
	private String getCaptchaValueFromSession(HttpSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
	}

	private HttpSession getHttpSession(HttpServletRequest httpServletRequest) {
		HttpServletRequest originalHttpServletRequest = portal.getOriginalServletRequest(httpServletRequest);

		return originalHttpServletRequest.getSession();
	}

	@Reference
	protected Portal portal;
}
