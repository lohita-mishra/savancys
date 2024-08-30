/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface JobApplicantFinder {

	public java.util.List<com.savancys.model.JobApplicantDTO>
		getJobApplicantDetailsWithJobPostName(
			Long jobPostId, java.util.Date startDate, java.util.Date endDate);

}