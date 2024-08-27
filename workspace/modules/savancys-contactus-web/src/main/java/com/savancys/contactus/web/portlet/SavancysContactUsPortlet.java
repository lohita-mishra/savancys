package com.savancys.contactus.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;
import com.savancys.service.ContactUsLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SavancysContactUs", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SavancysContactUsPortletKeys.SAVANCYSCONTACTUS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SavancysContactUsPortlet extends MVCPortlet {

	/*
	 * private Log log = LogFactoryUtil.getLog(SavancysContactUsPortlet.class);
	 * 
	 * @Reference private ContactUsLocalService contactUsLocalService;
	 * 
	 * public void addContactUs(ActionRequest request, ActionResponse response) {
	 * 
	 * String inquiryType = ParamUtil.getString(request, "inquiryType"); String
	 * firstName = ParamUtil.getString(request, "firstName"); String lastName =
	 * ParamUtil.getString(request, "lastName"); String phoneNumber =
	 * ParamUtil.getString(request, "phoneNumber"); String email =
	 * ParamUtil.getString(request, "email"); String companyName =
	 * ParamUtil.getString(request, "companyName"); String country =
	 * ParamUtil.getString(request, "country"); String additionalInfo =
	 * ParamUtil.getString(request, "additionalInfo");
	 * 
	 * log.info(" -inquiryType-- " + inquiryType + "-firstName-- " + firstName +
	 * "-lastName-- " + lastName + "-phoneNumber-- " + phoneNumber + "-email-- " +
	 * email + "-companyName-- " + companyName + "-country-- " + country +
	 * "-additionalInfo-- " + additionalInfo);
	 * 
	 * contactUsLocalService.addContact(inquiryType, firstName, lastName,
	 * phoneNumber, email, companyName, country, additionalInfo);
	 * 
	 * log.info("added"); }
	 */
}