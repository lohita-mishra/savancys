/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.savancys.model.JobApplicant;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the job applicant service. This utility wraps <code>com.savancys.service.persistence.impl.JobApplicantPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicantPersistence
 * @generated
 */
public class JobApplicantUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(JobApplicant jobApplicant) {
		getPersistence().clearCache(jobApplicant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, JobApplicant> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobApplicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobApplicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobApplicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobApplicant> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobApplicant update(JobApplicant jobApplicant) {
		return getPersistence().update(jobApplicant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobApplicant update(
		JobApplicant jobApplicant, ServiceContext serviceContext) {

		return getPersistence().update(jobApplicant, serviceContext);
	}

	/**
	 * Caches the job applicant in the entity cache if it is enabled.
	 *
	 * @param jobApplicant the job applicant
	 */
	public static void cacheResult(JobApplicant jobApplicant) {
		getPersistence().cacheResult(jobApplicant);
	}

	/**
	 * Caches the job applicants in the entity cache if it is enabled.
	 *
	 * @param jobApplicants the job applicants
	 */
	public static void cacheResult(List<JobApplicant> jobApplicants) {
		getPersistence().cacheResult(jobApplicants);
	}

	/**
	 * Creates a new job applicant with the primary key. Does not add the job applicant to the database.
	 *
	 * @param jobApplicantID the primary key for the new job applicant
	 * @return the new job applicant
	 */
	public static JobApplicant create(long jobApplicantID) {
		return getPersistence().create(jobApplicantID);
	}

	/**
	 * Removes the job applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant that was removed
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	public static JobApplicant remove(long jobApplicantID)
		throws com.savancys.exception.NoSuchJobApplicantException {

		return getPersistence().remove(jobApplicantID);
	}

	public static JobApplicant updateImpl(JobApplicant jobApplicant) {
		return getPersistence().updateImpl(jobApplicant);
	}

	/**
	 * Returns the job applicant with the primary key or throws a <code>NoSuchJobApplicantException</code> if it could not be found.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	public static JobApplicant findByPrimaryKey(long jobApplicantID)
		throws com.savancys.exception.NoSuchJobApplicantException {

		return getPersistence().findByPrimaryKey(jobApplicantID);
	}

	/**
	 * Returns the job applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant, or <code>null</code> if a job applicant with the primary key could not be found
	 */
	public static JobApplicant fetchByPrimaryKey(long jobApplicantID) {
		return getPersistence().fetchByPrimaryKey(jobApplicantID);
	}

	/**
	 * Returns all the job applicants.
	 *
	 * @return the job applicants
	 */
	public static List<JobApplicant> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @return the range of job applicants
	 */
	public static List<JobApplicant> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job applicants
	 */
	public static List<JobApplicant> findAll(
		int start, int end, OrderByComparator<JobApplicant> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job applicants
	 */
	public static List<JobApplicant> findAll(
		int start, int end, OrderByComparator<JobApplicant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the job applicants from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of job applicants.
	 *
	 * @return the number of job applicants
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobApplicantPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(JobApplicantPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile JobApplicantPersistence _persistence;

}