/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the JobApplicant service. Represents a row in the &quot;JobApplicant&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicantModel
 * @generated
 */
@ImplementationClassName("com.savancys.model.impl.JobApplicantImpl")
@ProviderType
public interface JobApplicant extends JobApplicantModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.savancys.model.impl.JobApplicantImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<JobApplicant, Long> JOB_APPLICANT_ID_ACCESSOR =
		new Accessor<JobApplicant, Long>() {

			@Override
			public Long get(JobApplicant jobApplicant) {
				return jobApplicant.getJobApplicantID();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<JobApplicant> getTypeClass() {
				return JobApplicant.class;
			}

		};

}