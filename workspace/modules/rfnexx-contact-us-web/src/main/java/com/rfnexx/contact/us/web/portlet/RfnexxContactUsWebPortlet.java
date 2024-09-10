package com.rfnexx.contact.us.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.rfnexx.contact.us.web.constants.RfnexxContactUsWebPortletKeys;
import com.savancys.model.ContactUs;
import com.savancys.service.ContactUsLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=savancys",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RfnexxContactUsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RfnexxContactUsWebPortletKeys.RFNEXXCONTACTUSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RfnexxContactUsWebPortlet extends MVCPortlet {

	public void serveResource(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {
		log.info("1 serveResource");
		String resourceId = req.getResourceID();
		if (resourceId.equalsIgnoreCase("SaveRfnexx")) {
			try {
				saveRfnexxContact(req, resp);
			} catch (PortalException e) {
				log.error(e.getMessage());
			}
		}
	}

	private void saveRfnexxContact(ResourceRequest req, ResourceResponse resp) throws PortalException {
		log.info("4 saveRfnexxContact :: ");
		String fullname = ParamUtil.getString(req, "fullname");
		String street = ParamUtil.getString(req, "street");
		String city = ParamUtil.getString(req, "city");
		String postcode = ParamUtil.getString(req, "postcode");
		String contactPhone = ParamUtil.getString(req, "contactPhone");
		String email = ParamUtil.getString(req, "email");
		String additionalInfo = ParamUtil.getString(req, "additionalInfo");

		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);

		/*
		 * if ((!InputValidator.isValidText(fullname)) ||
		 * (!InputValidator.isValidEmail(email)) ||
		 * (!InputValidator.isValidPhoneNumber(contactPhone))) {
		 * SessionErrors.add((PortletRequest) req, "invalid-name");
		 * SessionErrors.add((PortletRequest) req, "invalid-street");
		 * SessionErrors.add((PortletRequest) req, "invalid-city");
		 * SessionErrors.add((PortletRequest) req, "invalid-postcode");
		 * SessionErrors.add((PortletRequest) req, "invalid-contactPhone");
		 * SessionErrors.add((PortletRequest) req, "invalid-email");
		 * SessionErrors.add((PortletRequest) req, "invalid-additionalInfo"); } else {
		}
		 */
		ContactUsLocalServiceUtil.saveRFNEXxContact(StringPool.BLANK,fullname, street, city, postcode, contactPhone, email,
					additionalInfo, themeDisplay);
	}

	private static final Log log = LogFactoryUtil.getLog(RfnexxContactUsWebPortlet.class);
}