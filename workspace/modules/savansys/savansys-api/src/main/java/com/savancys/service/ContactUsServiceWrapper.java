/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactUsService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactUsService
 * @generated
 */
public class ContactUsServiceWrapper
	implements ContactUsService, ServiceWrapper<ContactUsService> {

	public ContactUsServiceWrapper() {
		this(null);
	}

	public ContactUsServiceWrapper(ContactUsService contactUsService) {
		_contactUsService = contactUsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactUsService.getOSGiServiceIdentifier();
	}

	@Override
	public ContactUsService getWrappedService() {
		return _contactUsService;
	}

	@Override
	public void setWrappedService(ContactUsService contactUsService) {
		_contactUsService = contactUsService;
	}

	private ContactUsService _contactUsService;

}