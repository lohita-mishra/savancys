package com.rfnexx.contact.us.web.command;

import com.liferay.petra.string.StringPool;
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
import com.rfnexx.contact.us.web.constants.RfnexxContactUsWebPortletKeys;
import com.savancys.service.ContactUsLocalServiceUtil;

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

@Component(property = { "javax.portlet.name=" + RfnexxContactUsWebPortletKeys.RFNEXXCONTACTUSWEB,
		"mvc.command.name=SaveRfnexx" }, service = MVCResourceCommand.class)
public class AddContactUsResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest req, ResourceResponse resp)
			throws PortletException {
		log.info("conatact us ");

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(req);
		String captchaFormValue = ParamUtil.getString(req, "captchaText");
		HttpSession httpSession = getHttpSession(httpServletRequest);
		String captchaText = getCaptchaValueFromSession(httpSession);
		log.info("captchaFormValue: " + captchaFormValue);
		log.info("captchaText: " + captchaText);

		try (PrintWriter out = resp.getWriter()) {
			if (!captchaText.equals(captchaFormValue)) {
				jsonResponse.put("status", "error");
				jsonResponse.put("message", "CAPTCHA verification failed.");
				log.error("CAPTCHA verification failed.");
				log.info("jsonResponse" + jsonResponse.toString());
				out.print(jsonResponse.toString());
				out.flush();
				return false;
			}

			String fullname = ParamUtil.getString(req, "fullname");
			String street = ParamUtil.getString(req, "street");
			String city = ParamUtil.getString(req, "city");
			String postcode = ParamUtil.getString(req, "postcode");
			String contactPhone = ParamUtil.getString(req, "contactPhone");
			String email = ParamUtil.getString(req, "email");
			String additionalInfo = ParamUtil.getString(req, "additionalInfo");

			ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
			ContactUsLocalServiceUtil.saveRFNEXxContact(StringPool.BLANK,fullname, street, city, postcode, contactPhone, email,
					additionalInfo, themeDisplay);

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
	
	private static final Log log = LogFactoryUtil.getLog(AddContactUsResourceCommand.class);

}