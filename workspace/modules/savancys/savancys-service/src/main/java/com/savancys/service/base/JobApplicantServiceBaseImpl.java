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

import com.savancys.model.JobApplicant;
import com.savancys.service.JobApplicantService;
import com.savancys.service.JobApplicantServiceUtil;
import com.savancys.service.persistence.ContactUsPersistence;
import com.savancys.service.persistence.JobApplicantFinder;
import com.savancys.service.persistence.JobApplicantPersistence;
import com.savancys.service.persistence.JobPostPersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the job applicant remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.savancys.service.impl.JobApplicantServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.savancys.service.impl.JobApplicantServiceImpl
 * @generated
 */
public abstract class JobApplicantServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, JobApplicantService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>JobApplicantService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>JobApplicantServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		JobApplicantServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			JobApplicantService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		jobApplicantService = (JobApplicantService)aopProxy;

		JobApplicantServiceUtil.setService(jobApplicantService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return JobApplicantService.class.getName();
	}

	protected Class<?> getModelClass() {
		return JobApplicant.class;
	}

	protected String getModelClassName() {
		return JobApplicant.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = jobApplicantPersistence.getDataSource();

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
	protected com.savancys.service.JobApplicantLocalService
		jobApplicantLocalService;

	protected JobApplicantService jobApplicantService;

	@Reference
	protected JobApplicantPersistence jobApplicantPersistence;

	@Reference
	protected JobApplicantFinder jobApplicantFinder;

	@Reference
	protected JobPostPersistence jobPostPersistence;

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

	private static final Log _log = LogFactoryUtil.getLog(
		JobApplicantServiceBaseImpl.class);

}