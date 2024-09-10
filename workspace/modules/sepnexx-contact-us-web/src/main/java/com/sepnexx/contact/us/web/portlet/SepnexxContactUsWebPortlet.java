package com.sepnexx.contact.us.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sapnexx.common.validator.util.InputValidator;
import com.savancys.service.ContactUsLocalServiceUtil;
import com.sepnexx.contact.us.web.constants.SepnexxContactUsWebPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SepnexxContactUsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SepnexxContactUsWebPortletKeys.SEPNEXXCONTACTUSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SepnexxContactUsWebPortlet extends MVCPortlet {

	public void serveResource(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {
		log.info("1 serveResource");
		String resourceId = req.getResourceID();
		if (resourceId.equalsIgnoreCase("SaveSepnexx")) {			
			try {
				saveSapnexxContact(req, resp);
			} catch (PortalException e) {
				log.error(e.getMessage());
			}
			
		}
	}

	private void saveSapnexxContact(ResourceRequest req, ResourceResponse resp) throws PortalException {
		log.info("4 saveSapnexxContact :: " + ContactUsLocalServiceUtil.getContactUsesCount());
		String fullname = ParamUtil.getString(req, "fullname");
		String email = ParamUtil.getString(req, "email");
		String phoneNumber = ParamUtil.getString(req, "phoneNumber");
		String companyName = ParamUtil.getString(req, "companyName");
		String additionalInfo = ParamUtil.getString(req, "additionalInfo");

		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		
		if((!InputValidator.isValidText(fullname)) || (!InputValidator.isValidPhoneNumber(phoneNumber)) || !InputValidator.isValidEmail(email) ||!InputValidator.isValidText(companyName)){
			SessionErrors.add((PortletRequest) req, "invalid-name");
			SessionErrors.add((PortletRequest) req, "invalid-mobile");
			SessionErrors.add((PortletRequest) req, "invalid-email");
			SessionErrors.add((PortletRequest) req, "invalid-company-name");
		}else{	
			
			ContactUsLocalServiceUtil.saveSapnexxContact(fullname, phoneNumber, email, companyName, additionalInfo,
					themeDisplay);
			
			}
		
		/*if (!InputValidator.isValidText(fullname)) {
			log.info("Invalid name");
			SessionErrors.add((PortletRequest) req, "invalid-name");
			
		} else if (!InputValidator.isValidPhoneNumber(phoneNumber)) {	
			log.info("Invalid phone number");
			SessionErrors.add((PortletRequest) req, "invalid-mobile");
			
		}else if(!InputValidator.isValidEmail(email)) {
			log.info("Invalid Email");
			SessionErrors.add((PortletRequest) req, "invalid-email");
			
		} else if(!InputValidator.isValidCompanyName(companyName)) {
			log.info("Invalid company name");
			SessionErrors.add((PortletRequest) req, "invalid-company-name");
			
		}*/
		
	}
	

	private static final Log log = LogFactoryUtil.getLog(SepnexxContactUsWebPortlet.class);

}