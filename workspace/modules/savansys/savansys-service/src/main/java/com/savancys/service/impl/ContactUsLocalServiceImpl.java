/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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