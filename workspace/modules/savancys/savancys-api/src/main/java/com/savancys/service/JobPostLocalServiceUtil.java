/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.savancys.model.JobPost;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for JobPost. This utility wraps
 * <code>com.savancys.service.impl.JobPostLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see JobPostLocalService
 * @generated
 */
public class JobPostLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.savancys.service.impl.JobPostLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the job post to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPost the job post
	 * @return the job post that was added
	 */
	public static JobPost addJobPost(JobPost jobPost) {
		return getService().addJobPost(jobPost);
	}

	/**
	 * Creates a new job post with the primary key. Does not add the job post to the database.
	 *
	 * @param jobPostId the primary key for the new job post
	 * @return the new job post
	 */
	public static JobPost createJobPost(long jobPostId) {
		return getService().createJobPost(jobPostId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the job post from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPost the job post
	 * @return the job post that was removed
	 */
	public static JobPost deleteJobPost(JobPost jobPost) {
		return getService().deleteJobPost(jobPost);
	}

	/**
	 * Deletes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post that was removed
	 * @throws PortalException if a job post with the primary key could not be found
	 */
	public static JobPost deleteJobPost(long jobPostId) throws PortalException {
		return getService().deleteJobPost(jobPostId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static List<JobPost> fetchActiveJobPosts() throws SystemException {
		return getService().fetchActiveJobPosts();
	}

	public static JobPost fetchJobPost(long jobPostId) {
		return getService().fetchJobPost(jobPostId);
	}

	/**
	 * Returns the job post matching the UUID and group.
	 *
	 * @param uuid the job post's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	public static JobPost fetchJobPostByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchJobPostByUuidAndGroupId(uuid, groupId);
	}

	public static List<JobPost> fetchJobPosts(int start, int end) {
		return getService().fetchJobPosts(start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job post with the primary key.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post
	 * @throws PortalException if a job post with the primary key could not be found
	 */
	public static JobPost getJobPost(long jobPostId) throws PortalException {
		return getService().getJobPost(jobPostId);
	}

	/**
	 * Returns the job post matching the UUID and group.
	 *
	 * @param uuid the job post's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job post
	 * @throws PortalException if a matching job post could not be found
	 */
	public static JobPost getJobPostByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getJobPostByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of job posts
	 */
	public static List<JobPost> getJobPosts(int start, int end) {
		return getService().getJobPosts(start, end);
	}

	/**
	 * Returns all the job posts matching the UUID and company.
	 *
	 * @param uuid the UUID of the job posts
	 * @param companyId the primary key of the company
	 * @return the matching job posts, or an empty list if no matches were found
	 */
	public static List<JobPost> getJobPostsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getJobPostsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of job posts matching the UUID and company.
	 *
	 * @param uuid the UUID of the job posts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching job posts, or an empty list if no matches were found
	 */
	public static List<JobPost> getJobPostsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return getService().getJobPostsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of job posts.
	 *
	 * @return the number of job posts
	 */
	public static int getJobPostsCount() {
		return getService().getJobPostsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static JobPost saveOrUpdateJobPost(
		Long id, String jobPostName, String experience, String qualification,
		String location, String skills, String description, String salary,
		Boolean active) {

		return getService().saveOrUpdateJobPost(
			id, jobPostName, experience, qualification, location, skills,
			description, salary, active);
	}

	/**
	 * Updates the job post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPostLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPost the job post
	 * @return the job post that was updated
	 */
	public static JobPost updateJobPost(JobPost jobPost) {
		return getService().updateJobPost(jobPost);
	}

	public static JobPostLocalService getService() {
		return _service;
	}

	public static void setService(JobPostLocalService service) {
		_service = service;
	}

	private static volatile JobPostLocalService _service;

}