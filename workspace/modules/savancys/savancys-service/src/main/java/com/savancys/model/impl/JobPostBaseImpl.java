/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.savancys.model.JobPost;
import com.savancys.service.JobPostLocalServiceUtil;

/**
 * The extended model base implementation for the JobPost service. Represents a row in the &quot;JobPost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobPostImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobPostImpl
 * @see JobPost
 * @generated
 */
public abstract class JobPostBaseImpl
	extends JobPostModelImpl implements JobPost {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a job post model instance should use the <code>JobPost</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			JobPostLocalServiceUtil.addJobPost(this);
		}
		else {
			JobPostLocalServiceUtil.updateJobPost(this);
		}
	}

}