/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.savancys.exception.NoSuchJobPostException;
import com.savancys.model.JobPost;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobPostUtil
 * @generated
 */
@ProviderType
public interface JobPostPersistence extends BasePersistence<JobPost> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobPostUtil} to access the job post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the job posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job posts
	 */
	public java.util.List<JobPost> findByUuid(String uuid);

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
	public java.util.List<JobPost> findByUuid(String uuid, int start, int end);

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
	public java.util.List<JobPost> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

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
	public java.util.List<JobPost> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Returns the first job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

	/**
	 * Returns the last job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Returns the last job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

	/**
	 * Returns the job posts before and after the current job post in the ordered set where uuid = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public JobPost[] findByUuid_PrevAndNext(
			long jobPostId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Removes all the job posts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of job posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job posts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobPostException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByUUID_G(String uuid, long groupId)
		throws NoSuchJobPostException;

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the job post where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the job post that was removed
	 */
	public JobPost removeByUUID_G(String uuid, long groupId)
		throws NoSuchJobPostException;

	/**
	 * Returns the number of job posts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching job posts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching job posts
	 */
	public java.util.List<JobPost> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

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
	public java.util.List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Returns the first job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

	/**
	 * Returns the last job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Returns the last job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

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
	public JobPost[] findByUuid_C_PrevAndNext(
			long jobPostId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Removes all the job posts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching job posts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the job posts where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @return the matching job posts
	 */
	public java.util.List<JobPost> findByjobPostName(String jobPostName);

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
	public java.util.List<JobPost> findByjobPostName(
		String jobPostName, int start, int end);

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
	public java.util.List<JobPost> findByjobPostName(
		String jobPostName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

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
	public java.util.List<JobPost> findByjobPostName(
		String jobPostName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByjobPostName_First(
			String jobPostName,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Returns the first job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByjobPostName_First(
		String jobPostName,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

	/**
	 * Returns the last job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	public JobPost findByjobPostName_Last(
			String jobPostName,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Returns the last job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public JobPost fetchByjobPostName_Last(
		String jobPostName,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

	/**
	 * Returns the job posts before and after the current job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public JobPost[] findByjobPostName_PrevAndNext(
			long jobPostId, String jobPostName,
			com.liferay.portal.kernel.util.OrderByComparator<JobPost>
				orderByComparator)
		throws NoSuchJobPostException;

	/**
	 * Removes all the job posts where jobPostName = &#63; from the database.
	 *
	 * @param jobPostName the job post name
	 */
	public void removeByjobPostName(String jobPostName);

	/**
	 * Returns the number of job posts where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @return the number of matching job posts
	 */
	public int countByjobPostName(String jobPostName);

	/**
	 * Caches the job post in the entity cache if it is enabled.
	 *
	 * @param jobPost the job post
	 */
	public void cacheResult(JobPost jobPost);

	/**
	 * Caches the job posts in the entity cache if it is enabled.
	 *
	 * @param jobPosts the job posts
	 */
	public void cacheResult(java.util.List<JobPost> jobPosts);

	/**
	 * Creates a new job post with the primary key. Does not add the job post to the database.
	 *
	 * @param jobPostId the primary key for the new job post
	 * @return the new job post
	 */
	public JobPost create(long jobPostId);

	/**
	 * Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post that was removed
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public JobPost remove(long jobPostId) throws NoSuchJobPostException;

	public JobPost updateImpl(JobPost jobPost);

	/**
	 * Returns the job post with the primary key or throws a <code>NoSuchJobPostException</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	public JobPost findByPrimaryKey(long jobPostId)
		throws NoSuchJobPostException;

	/**
	 * Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post, or <code>null</code> if a job post with the primary key could not be found
	 */
	public JobPost fetchByPrimaryKey(long jobPostId);

	/**
	 * Returns all the job posts.
	 *
	 * @return the job posts
	 */
	public java.util.List<JobPost> findAll();

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
	public java.util.List<JobPost> findAll(int start, int end);

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
	public java.util.List<JobPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator);

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
	public java.util.List<JobPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the job posts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of job posts.
	 *
	 * @return the number of job posts
	 */
	public int countAll();

}