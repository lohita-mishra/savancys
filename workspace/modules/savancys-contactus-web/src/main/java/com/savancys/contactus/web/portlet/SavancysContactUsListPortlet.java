package com.savancys.contactus.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;
import com.savancys.model.ContactUs;
import com.savancys.service.ContactUsLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=savancys",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SavancysContactUsList", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view-contact-us.jsp",
		"javax.portlet.name=" + SavancysContactUsPortletKeys.SAVANCYSCONTACTUSLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SavancysContactUsListPortlet extends MVCPortlet {

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		List<ContactUs> contactUsList = ContactUsLocalServiceUtil.getContactUsByGroupId(groupId);
		
		renderRequest.setAttribute("contactUsList", contactUsList);
		
		super.doView(renderRequest, renderResponse);
	}
}