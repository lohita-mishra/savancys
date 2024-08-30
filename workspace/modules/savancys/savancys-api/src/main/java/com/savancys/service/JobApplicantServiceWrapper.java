/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobApplicantService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicantService
 * @generated
 */
public class JobApplicantServiceWrapper
	implements JobApplicantService, ServiceWrapper<JobApplicantService> {

	public JobApplicantServiceWrapper() {
		this(null);
	}

	public JobApplicantServiceWrapper(JobApplicantService jobApplicantService) {
		_jobApplicantService = jobApplicantService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobApplicantService.getOSGiServiceIdentifier();
	}

	@Override
	public JobApplicantService getWrappedService() {
		return _jobApplicantService;
	}

	@Override
	public void setWrappedService(JobApplicantService jobApplicantService) {
		_jobApplicantService = jobApplicantService;
	}

	private JobApplicantService _jobApplicantService;

}