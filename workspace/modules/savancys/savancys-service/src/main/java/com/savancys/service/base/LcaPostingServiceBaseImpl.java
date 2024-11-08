/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.savancys.model.LcaPosting;
import com.savancys.service.LcaPostingService;
import com.savancys.service.LcaPostingServiceUtil;
import com.savancys.service.persistence.ContactUsPersistence;
import com.savancys.service.persistence.JobApplicantFinder;
import com.savancys.service.persistence.JobApplicantPersistence;
import com.savancys.service.persistence.JobPostPersistence;
import com.savancys.service.persistence.LcaPostingPersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the lca posting remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.savancys.service.impl.LcaPostingServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.savancys.service.impl.LcaPostingServiceImpl
 * @generated
 */
public abstract class LcaPostingServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, LcaPostingService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>LcaPostingService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LcaPostingServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		LcaPostingServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			LcaPostingService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		lcaPostingService = (LcaPostingService)aopProxy;

		LcaPostingServiceUtil.setService(lcaPostingService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LcaPostingService.class.getName();
	}

	protected Class<?> getModelClass() {
		return LcaPosting.class;
	}

	protected String getModelClassName() {
		return LcaPosting.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = lcaPostingPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected ContactUsPersistence contactUsPersistence;

	@Reference
	protected JobApplicantPersistence jobApplicantPersistence;

	@Reference
	protected JobApplicantFinder jobApplicantFinder;

	@Reference
	protected JobPostPersistence jobPostPersistence;

	@Reference
	protected com.savancys.service.LcaPostingLocalService
		lcaPostingLocalService;

	protected LcaPostingService lcaPostingService;

	@Reference
	protected LcaPostingPersistence lcaPostingPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	private static final Log _log = LogFactoryUtil.getLog(
		LcaPostingServiceBaseImpl.class);

}