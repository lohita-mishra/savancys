/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.savancys.model.LcaPosting;
import com.savancys.service.LcaPostingLocalServiceUtil;

/**
 * The extended model base implementation for the LcaPosting service. Represents a row in the &quot;LCA_Posting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LcaPostingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LcaPostingImpl
 * @see LcaPosting
 * @generated
 */
public abstract class LcaPostingBaseImpl
	extends LcaPostingModelImpl implements LcaPosting {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lca posting model instance should use the <code>LcaPosting</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LcaPostingLocalServiceUtil.addLcaPosting(this);
		}
		else {
			LcaPostingLocalServiceUtil.updateLcaPosting(this);
		}
	}

}