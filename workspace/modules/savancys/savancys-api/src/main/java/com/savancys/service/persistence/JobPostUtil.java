/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.savancys.model.JobPost;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the job post service. This utility wraps <code>com.savancys.service.persistence.impl.JobPostPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobPostPersistence
 * @generated
 */
public class JobPostUtil {

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
	public static void clearCache(JobPost jobPost) {
		getPersistence().clearCache(jobPost);
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
	public static Map<Serializable, JobPost> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobPost update(JobPost jobPost) {
		return getPersistence().update(jobPost);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobPost update(
		JobPost jobPost, ServiceContext serviceContext) {

		return getPersistence().update(jobPost, serviceContext);
	}

	/**
	 * Returns all the job posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job posts
	 */
	public static List<JobPost> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the job posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of matching job posts
	 */
	public static List<JobPost> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job posts
	 */
	public static List<JobPost> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job posts
	 */
	public static List<JobPost> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByUuid_First(
			String uuid, OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByUuid_First(
		String uuid, OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByUuid_Last(
			String uuid, OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByUuid_Last(
		String uuid, OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the job posts before and after the current job post in the ordered set where uuid = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public static JobPost[] findByUuid_PrevAndNext(
			long jobPostId, String uuid,
			OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUuid_PrevAndNext(
			jobPostId, uuid, orderByComparator);
	}

	/**
	 * Removes all the job posts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of job posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job posts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobPostException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByUUID_G(String uuid, long groupId)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the job post where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the job post that was removed
	 */
	public static JobPost removeByUUID_G(String uuid, long groupId)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of job posts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching job posts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching job posts
	 */
	public static List<JobPost> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of matching job posts
	 */
	public static List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job posts
	 */
	public static List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job posts
	 */
	public static List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the job posts before and after the current job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public static JobPost[] findByUuid_C_PrevAndNext(
			long jobPostId, String uuid, long companyId,
			OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByUuid_C_PrevAndNext(
			jobPostId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the job posts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching job posts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the job posts where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @return the matching job posts
	 */
	public static List<JobPost> findByjobPostName(String jobPostName) {
		return getPersistence().findByjobPostName(jobPostName);
	}

	/**
	 * Returns a range of all the job posts where jobPostName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param jobPostName the job post name
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of matching job posts
	 */
	public static List<JobPost> findByjobPostName(
		String jobPostName, int start, int end) {

		return getPersistence().findByjobPostName(jobPostName, start, end);
	}

	/**
	 * Returns an ordered range of all the job posts where jobPostName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param jobPostName the job post name
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job posts
	 */
	public static List<JobPost> findByjobPostName(
		String jobPostName, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().findByjobPostName(
			jobPostName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the job posts where jobPostName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param jobPostName the job post name
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job posts
	 */
	public static List<JobPost> findByjobPostName(
		String jobPostName, int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByjobPostName(
			jobPostName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByjobPostName_First(
			String jobPostName, OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByjobPostName_First(
			jobPostName, orderByComparator);
	}

	/**
	 * Returns the first job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByjobPostName_First(
		String jobPostName, OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().fetchByjobPostName_First(
			jobPostName, orderByComparator);
	}

	/**
	 * Returns the last job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public static JobPost findByjobPostName_Last(
			String jobPostName, OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByjobPostName_Last(
			jobPostName, orderByComparator);
	}

	/**
	 * Returns the last job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchByjobPostName_Last(
		String jobPostName, OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().fetchByjobPostName_Last(
			jobPostName, orderByComparator);
	}

	/**
	 * Returns the job posts before and after the current job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public static JobPost[] findByjobPostName_PrevAndNext(
			long jobPostId, String jobPostName,
			OrderByComparator<JobPost> orderByComparator)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByjobPostName_PrevAndNext(
			jobPostId, jobPostName, orderByComparator);
	}

	/**
	 * Removes all the job posts where jobPostName = &#63; from the database.
	 *
	 * @param jobPostName the job post name
	 */
	public static void removeByjobPostName(String jobPostName) {
		getPersistence().removeByjobPostName(jobPostName);
	}

	/**
	 * Returns the number of job posts where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @return the number of matching job posts
	 */
	public static int countByjobPostName(String jobPostName) {
		return getPersistence().countByjobPostName(jobPostName);
	}

	/**
	 * Caches the job post in the entity cache if it is enabled.
	 *
	 * @param jobPost the job post
	 */
	public static void cacheResult(JobPost jobPost) {
		getPersistence().cacheResult(jobPost);
	}

	/**
	 * Caches the job posts in the entity cache if it is enabled.
	 *
	 * @param jobPosts the job posts
	 */
	public static void cacheResult(List<JobPost> jobPosts) {
		getPersistence().cacheResult(jobPosts);
	}

	/**
	 * Creates a new job post with the primary key. Does not add the job post to the database.
	 *
	 * @param jobPostId the primary key for the new job post
	 * @return the new job post
	 */
	public static JobPost create(long jobPostId) {
		return getPersistence().create(jobPostId);
	}

	/**
	 * Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post that was removed
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public static JobPost remove(long jobPostId)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().remove(jobPostId);
	}

	public static JobPost updateImpl(JobPost jobPost) {
		return getPersistence().updateImpl(jobPost);
	}

	/**
	 * Returns the job post with the primary key or throws a <code>NoSuchJobPostException</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public static JobPost findByPrimaryKey(long jobPostId)
		throws com.savancys.exception.NoSuchJobPostException {

		return getPersistence().findByPrimaryKey(jobPostId);
	}

	/**
	 * Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post, or <code>null</code> if a job post with the primary key could not be found
	 */
	public static JobPost fetchByPrimaryKey(long jobPostId) {
		return getPersistence().fetchByPrimaryKey(jobPostId);
	}

	/**
	 * Returns all the job posts.
	 *
	 * @return the job posts
	 */
	public static List<JobPost> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of job posts
	 */
	public static List<JobPost> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job posts
	 */
	public static List<JobPost> findAll(
		int start, int end, OrderByComparator<JobPost> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job posts
	 */
	public static List<JobPost> findAll(
		int start, int end, OrderByComparator<JobPost> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the job posts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of job posts.
	 *
	 * @return the number of job posts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobPostPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(JobPostPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile JobPostPersistence _persistence;

}