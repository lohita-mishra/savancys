/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LcaPostingService}.
 *
 * @author Brian Wing Shun Chan
 * @see LcaPostingService
 * @generated
 */
public class LcaPostingServiceWrapper
	implements LcaPostingService, ServiceWrapper<LcaPostingService> {

	public LcaPostingServiceWrapper() {
		this(null);
	}

	public LcaPostingServiceWrapper(LcaPostingService lcaPostingService) {
		_lcaPostingService = lcaPostingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lcaPostingService.getOSGiServiceIdentifier();
	}

	@Override
	public LcaPostingService getWrappedService() {
		return _lcaPostingService;
	}

	@Override
	public void setWrappedService(LcaPostingService lcaPostingService) {
		_lcaPostingService = lcaPostingService;
	}

	private LcaPostingService _lcaPostingService;

}