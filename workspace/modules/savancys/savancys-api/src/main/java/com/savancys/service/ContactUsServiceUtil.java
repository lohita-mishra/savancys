/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

/**
 * Provides the remote service utility for ContactUs. This utility wraps
 * <code>com.savancys.service.impl.ContactUsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ContactUsService
 * @generated
 */
public class ContactUsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.savancys.service.impl.ContactUsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String saveSapnexxContact(
		java.lang.String fullname, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String companyName,
		java.lang.String additionalInfo) {

		return getService().saveSapnexxContact(
			fullname, phoneNumber, email, companyName, additionalInfo);
	}

	public static ContactUsService getService() {
		return _service;
	}

	public static void setService(ContactUsService service) {
		_service = service;
	}

	private static volatile ContactUsService _service;

}