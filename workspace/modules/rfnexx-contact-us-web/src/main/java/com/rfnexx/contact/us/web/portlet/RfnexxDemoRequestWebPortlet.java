package com.rfnexx.contact.us.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.rfnexx.contact.us.web.constants.RfnexxContactUsWebPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=savancys",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RfnexxRequestDemoWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/request-form-demo.jsp",
		"javax.portlet.name=" + RfnexxContactUsWebPortletKeys.RFNEXXDEMOREQUESTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RfnexxDemoRequestWebPortlet extends MVCPortlet {
}