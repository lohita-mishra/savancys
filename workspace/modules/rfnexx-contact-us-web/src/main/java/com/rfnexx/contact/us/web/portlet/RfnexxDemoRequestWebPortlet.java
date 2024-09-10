package com.rfnexx.contact.us.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.rfnexx.contact.us.web.constants.RfnexxContactUsWebPortletKeys;
import com.savancys.service.ContactUsLocalServiceUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=savancys",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RfnexxRequestDemoWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/requestFormDemo.jsp",
		"javax.portlet.name=" + RfnexxContactUsWebPortletKeys.RFNEXXDEMOREQUESTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RfnexxDemoRequestWebPortlet extends MVCPortlet {

	public void serveResource(ResourceRequest req, ResourceResponse resp) throws IOException, PortletException {
		log.info("serveResource");
		String resourceId = req.getResourceID();
		if (resourceId.equalsIgnoreCase("requestFormDemo")) {
			try {
				saveRfnexxContact(req, resp);
			} catch (PortalException e) {
				log.error(e.getMessage());
			}
		}
	}

	private void saveRfnexxContact(ResourceRequest req, ResourceResponse resp) throws PortalException {
		log.info("request form demo ");
		String fullname = ParamUtil.getString(req, "fullname");
		String street = ParamUtil.getString(req, "street");
		String city = ParamUtil.getString(req, "city");
		String postcode = ParamUtil.getString(req, "postcode");
		String contactPhone = ParamUtil.getString(req, "contactPhone");
		String email = ParamUtil.getString(req, "email");
		String additionalInfo = ParamUtil.getString(req, "additionalInfo");

		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		ContactUsLocalServiceUtil.saveRFNEXxContact(fullname, street, city, postcode, contactPhone, email,
				additionalInfo, themeDisplay);
	}

	private static final Log log = LogFactoryUtil.getLog(RfnexxDemoRequestWebPortlet.class);

}
