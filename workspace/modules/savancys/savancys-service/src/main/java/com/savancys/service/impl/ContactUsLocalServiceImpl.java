/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.savancys.model.ContactUs;
import com.savancys.service.base.ContactUsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.savancys.model.ContactUs",
	service = AopService.class
)
public class ContactUsLocalServiceImpl extends ContactUsLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(ContactUsLocalServiceImpl.class); 
	
	public ContactUs addContact(String inquiryType, String firstName, String lastName, String phoneNumber,String email,
			String companyName, String country, String additionalInfo) {
		log.info("local");
		long contactId = counterLocalService.increment(ContactUs.class.getName());
		ContactUs contactUs = contactUsLocalService.createContactUs(contactId);
		contactUs.setInquiryType(inquiryType);
		contactUs.setFirstName(firstName);
		contactUs.setLastName(lastName);
		contactUs.setPhoneNumber(phoneNumber);
		contactUs.setEmail(email);
		contactUs.setCompanyName(companyName);
		contactUs.setCountry(country);
		contactUs.setAdditionalInfo(additionalInfo);
		contactUs = contactUsLocalService.addContactUs(contactUs);
		log.info("local contactUs"+contactUs);
		return contactUs;
		
	}
}