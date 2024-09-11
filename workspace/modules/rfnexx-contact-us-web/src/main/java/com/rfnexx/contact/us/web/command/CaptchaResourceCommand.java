package com.rfnexx.contact.us.web.command;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.rfnexx.contact.us.web.constants.RfnexxContactUsWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + RfnexxContactUsWebPortletKeys.RFNEXXCONTACTUSWEB,
				"javax.portlet.name=" + RfnexxContactUsWebPortletKeys.RFNEXXDEMOREQUESTWEB,
				"mvc.command.name=captcha"
				}, 
		service = MVCResourceCommand.class
)
public class CaptchaResourceCommand implements MVCResourceCommand {

	private final Log logger = LogFactoryUtil.getLog(CaptchaResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		logger.info("capt");
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(resourceResponse);
		try {
			CaptchaUtil.serveImage(httpServletRequest, httpServletResponse);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return false;
	}
}