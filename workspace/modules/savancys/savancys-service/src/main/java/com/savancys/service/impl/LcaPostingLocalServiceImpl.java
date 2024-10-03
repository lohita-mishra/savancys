/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.savancys.model.LcaPosting;
import com.savancys.service.base.LcaPostingLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.savancys.model.LcaPosting",
	service = AopService.class
)
public class LcaPostingLocalServiceImpl extends LcaPostingLocalServiceBaseImpl {
 
	private Log log = LogFactoryUtil.getLog(ContactUsLocalServiceImpl.class);

	
	public LcaPosting addLcaPosting(long groupId, String designation, String description, 
			String location, String oNetCode) {
		long lcaPostingId = counterLocalService.increment(LcaPosting.class.getName());
		LcaPosting lcaPosting = lcaPostingLocalService.createLcaPosting(lcaPostingId);
		
		//group id 
		lcaPosting.setGroupId(groupId);
		
		lcaPosting.setDesignation(designation);
		lcaPosting.setLocation(location);
		lcaPosting.setONetCode(oNetCode);
		lcaPosting.setDescription(description);
		lcaPosting = lcaPostingLocalService.addLcaPosting(lcaPosting);
		log.info("local contactUs" + lcaPosting);
		return lcaPosting;

	}
	
	/*
	 * public List<LcaPosting> getDesignation(String designation) { List<LcaPosting>
	 * findBydesignation = lcaPostingPersistence.findBydesignation(designation,
	 * QueryUtil.ALL_POS, QueryUtil.ALL_POS); return null; }
	 */

}