package com.savancys.contactus.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.savancys.contactus.web.constants.SavancysContactUsPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=savancys",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SavancysContactUs", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SavancysContactUsPortletKeys.SAVANCYSCONTACTUS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SavancysContactUsPortlet extends MVCPortlet {
	/*
	 * @Reference public SystemConfigDeclaration sytemConfigdDeclaration;
	 * 
	 * @Override public void doView(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws IOException, PortletException { try {
	 * sendEmail("nitesh28rocking@gmail.com", "nitesh.pal@adjecti.com","subject ",
	 * "dsd"); } catch (Exception e) { e.printStackTrace(); }
	 * super.doView(renderRequest, renderResponse); } private void sendEmail(String
	 * toEmail, String fromEmail, String subject, String body) throws Exception {
	 * MailMessage mailMessage = new MailMessage();
	 * System.out.println("Subject:::"+sytemConfigdDeclaration.getSubject());
	 * System.out.println("Body ::: "+sytemConfigdDeclaration.getBody());
	 * System.out.println("ToEmail :: "+sytemConfigdDeclaration.getToEmailAddress())
	 * ;
	 * 
	 * 
	 * String emailTemplatePath = sytemConfigdDeclaration.getBody();
	 * 
	 * TemplateResource templateResource = new URLTemplateResource(
	 * emailTemplatePath, getClass().getResource(emailTemplatePath));
	 * 
	 * 
	 * HashMap<String,String> hashMap=new HashMap<>(); hashMap.put("recipientName",
	 * "Yogendra"); hashMap.put("name", "Nitesh"); hashMap.put("email",
	 * "Adjecti@gmail.com"); hashMap.put("message", "This is a test message");
	 * String replacePlaceholders = replacePlaceholders(emailTemplatePath,hashMap);
	 * System.out.println("replacePlaceholders"+replacePlaceholders);
	 * 
	 * Template template = TemplateManagerUtil.getTemplate(
	 * TemplateConstants.LANG_TYPE_FTL, templateResource, false);
	 * template.put("name", "nitesh"); template.put("email", "Adjecti");
	 * template.put("recipientName", "Rec"); StringWriter out = new StringWriter();
	 * template.processTemplate(out); String emailContent = out.toString();
	 * System.out.println("emailContent"+emailContent);
	 * 
	 * 
	 * 
	 * mailMessage.setTo(new
	 * InternetAddress(sytemConfigdDeclaration.getToEmailAddress()));
	 * mailMessage.setFrom(new InternetAddress("nitesh28rocking@gmail.com"));
	 * mailMessage.setSubject(sytemConfigdDeclaration.getSubject());
	 * mailMessage.setBody(replacePlaceholders); mailMessage.setHTMLFormat(true); //
	 * MailServiceUtil.sendEmail(mailMessage);
	 * 
	 * System.out.println("Email sent successfully " +
	 * sytemConfigdDeclaration.getToEmailAddress()); }
	 * 
	 * private String replacePlaceholders(String template, Map<String, String>
	 * dynamicData) { for (Map.Entry<String, String> entry : dynamicData.entrySet())
	 * { template = template.replace("${" + entry.getKey() + "}", entry.getValue());
	 * } return template; }
	 * 
	 */

}