package com.savancys.contactus.web.commands;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;
import com.savancys.contactus.web.util.ContactUsEmailConfig;
import com.savancys.contactus.web.util.ContactUsEmailConfigDeclaration;
import com.savancys.model.ContactUs;
import com.savancys.service.ContactUsLocalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
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
	private ContactUsEmailConfigDeclaration sytemConfigdDeclaration;

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

			long groupId = themeDisplay.getScopeGroupId();
			ContactUs contact = contactUsLocalService.addContact(groupId, inquiryType, firstName, lastName, phoneNumber,
					email, companyName, country, additionalInfo);

			jsonResponse.put("status", "success");
			jsonResponse.put("message", "Successfully submitted.");
			out.print(jsonResponse.toString());
			out.flush();

			log.info("Form processed successfully.");
			if (Validator.isNotNull(contact)) {
				log.info("---");

				sendMail(contact);
//				SapnexxMail.sendMail("nitesh","pal","kumar","message");
			}

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

	private String replacePlaceholders(String template, Map<String, String> dynamicData) {
		for (Map.Entry<String, String> entry : dynamicData.entrySet()) {
			template = template.replace("${" + entry.getKey() + "}", entry.getValue());
		}
		return template;
	}

	public void sendMail(ContactUs contactUs) {
		log.info("callleddd..");
		System.out.println("Subject:::" + sytemConfigdDeclaration.getSubject());
		System.out.println("Body ::: " + sytemConfigdDeclaration.getBody());
		System.out.println("ToEmail :: " + sytemConfigdDeclaration.getToEmailAddress());
		System.out.println("From Email ::" + sytemConfigdDeclaration.getFromEmailAddress());

		try {
			String body = sytemConfigdDeclaration.getBody();
			String subject = sytemConfigdDeclaration.getSubject();
			String fromEmail = sytemConfigdDeclaration.getFromEmailAddress();
			String toEmail = sytemConfigdDeclaration.getToEmailAddress();
			String recipientName =  sytemConfigdDeclaration.getRecipientName();
			String name = contactUs.getFirstName() + " " + contactUs.getLastName();
			HashMap<String, String> hashMap = new HashMap<>();
			hashMap.put("recepientName", recipientName);
			hashMap.put("name", name);
			hashMap.put("email", contactUs.getEmail());
			hashMap.put("mobile", contactUs.getPhoneNumber());
			hashMap.put("country", contactUs.getCountry());
			hashMap.put("inquiry", contactUs.getInquiryType());
			hashMap.put("company", contactUs.getCompanyName());
			hashMap.put("message", contactUs.getAdditionalInfo());

			MailMessage mailMessage = new MailMessage();

			String subjectContent = replacePlaceholders(subject, hashMap);
			String replacePlaceholders = replacePlaceholders(body, hashMap);
			mailMessage.setTo(new InternetAddress(toEmail));
			mailMessage.setFrom(new InternetAddress(fromEmail));
			mailMessage.setSubject(subjectContent);
			mailMessage.setBody(replacePlaceholders);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			log.info("Mail sent Successfully to " + toEmail + " for " + name);

		} catch (Exception e) {
			log.error("Mail not sent becuase : " + e.getMessage());
			e.getMessage();
		}

	}

	@Reference
	protected Portal portal;
}
