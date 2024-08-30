/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobPostService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobPostService
 * @generated
 */
public class JobPostServiceWrapper
	implements JobPostService, ServiceWrapper<JobPostService> {

	public JobPostServiceWrapper() {
		this(null);
	}

	public JobPostServiceWrapper(JobPostService jobPostService) {
		_jobPostService = jobPostService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobPostService.getOSGiServiceIdentifier();
	}

	@Override
	public JobPostService getWrappedService() {
		return _jobPostService;
	}

	@Override
	public void setWrappedService(JobPostService jobPostService) {
		_jobPostService = jobPostService;
	}

	private JobPostService _jobPostService;

}