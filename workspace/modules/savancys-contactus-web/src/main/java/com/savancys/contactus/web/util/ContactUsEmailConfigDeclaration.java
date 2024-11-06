package com.savancys.contactus.web.util;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
@Component(configurationPid = "com.savancys.contactus.web.util.ContactUsEmailConfig", immediate = true, service = ContactUsEmailConfigDeclaration.class)
public class ContactUsEmailConfigDeclaration {

	public String getFromEmailAddress() {
		return contactUsEmailConfig.fromEmailAddress();
	}

	public String getToEmailAddress() {
		return contactUsEmailConfig.toEmailAddress();
	}


	public String getSubject() {
		return contactUsEmailConfig.subject();
	}

	public String getBody() {
		return contactUsEmailConfig.body();
	}

	public String getRecipientName() {
		return contactUsEmailConfig.recipientName();
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		contactUsEmailConfig = ConfigurableUtil.createConfigurable(ContactUsEmailConfig.class, properties);
	}

	private static final Log log = LogFactoryUtil.getLog(ContactUsEmailConfigDeclaration.class);

	private volatile ContactUsEmailConfig contactUsEmailConfig;
}
