package com.savancys.contactus.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;
import com.savancys.service.ContactUsLocalService;

import java.io.IOException;
import java.io.PrintWriter;

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

		log.info(" -inquiryType-- " + inquiryType + "-firstName-- " + firstName + "-lastName-- " + lastName
				+ "-phoneNumber-- " + phoneNumber + "-email-- " + email + "-companyName-- " + companyName
				+ "-country-- " + country + "-additionalInfo-- " + additionalInfo);
		resourceResponse.setContentType("text/html");
		PrintWriter out;
		try {
			contactUsLocalService.addContact(inquiryType, firstName, lastName, phoneNumber, email, companyName, country,
					additionalInfo);
			out = resourceResponse.getWriter();
			out.println("File send successfully");
		} catch (IOException e) {
			log.error(e.getMessage());
		}

		log.info("added");

		return false;
	}
}
