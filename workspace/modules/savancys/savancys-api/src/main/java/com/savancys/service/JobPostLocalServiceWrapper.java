/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link JobPostLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobPostLocalService
 * @generated
 */
public class JobPostLocalServiceWrapper
	implements JobPostLocalService, ServiceWrapper<JobPostLocalService> {

	public JobPostLocalServiceWrapper() {
		this(null);
	}

	public JobPostLocalServiceWrapper(JobPostLocalService jobPostLocalService) {
		_jobPostLocalService = jobPostLocalService;
	}

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
	@Override
	public com.savancys.model.JobPost addJobPost(
		com.savancys.model.JobPost jobPost) {

		return _jobPostLocalService.addJobPost(jobPost);
	}

	/**
	 * Creates a new job post with the primary key. Does not add the job post to the database.
	 *
	 * @param jobPostId the primary key for the new job post
	 * @return the new job post
	 */
	@Override
	public com.savancys.model.JobPost createJobPost(long jobPostId) {
		return _jobPostLocalService.createJobPost(jobPostId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPostLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.savancys.model.JobPost deleteJobPost(
		com.savancys.model.JobPost jobPost) {

		return _jobPostLocalService.deleteJobPost(jobPost);
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
	@Override
	public com.savancys.model.JobPost deleteJobPost(long jobPostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPostLocalService.deleteJobPost(jobPostId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPostLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _jobPostLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _jobPostLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobPostLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _jobPostLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _jobPostLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _jobPostLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _jobPostLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _jobPostLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public java.util.List<com.savancys.model.JobPost> fetchActiveJobPosts()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _jobPostLocalService.fetchActiveJobPosts();
	}

	@Override
	public com.savancys.model.JobPost fetchJobPost(long jobPostId) {
		return _jobPostLocalService.fetchJobPost(jobPostId);
	}

	/**
	 * Returns the job post matching the UUID and group.
	 *
	 * @param uuid the job post's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public com.savancys.model.JobPost fetchJobPostByUuidAndGroupId(
		String uuid, long groupId) {

		return _jobPostLocalService.fetchJobPostByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.savancys.model.JobPost> fetchJobPosts(
		int start, int end) {

		return _jobPostLocalService.fetchJobPosts(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobPostLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _jobPostLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobPostLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job post with the primary key.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post
	 * @throws PortalException if a job post with the primary key could not be found
	 */
	@Override
	public com.savancys.model.JobPost getJobPost(long jobPostId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPostLocalService.getJobPost(jobPostId);
	}

	/**
	 * Returns the job post matching the UUID and group.
	 *
	 * @param uuid the job post's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job post
	 * @throws PortalException if a matching job post could not be found
	 */
	@Override
	public com.savancys.model.JobPost getJobPostByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPostLocalService.getJobPostByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.savancys.model.JobPost> getJobPosts(
		int start, int end) {

		return _jobPostLocalService.getJobPosts(start, end);
	}

	/**
	 * Returns all the job posts matching the UUID and company.
	 *
	 * @param uuid the UUID of the job posts
	 * @param companyId the primary key of the company
	 * @return the matching job posts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.savancys.model.JobPost>
		getJobPostsByUuidAndCompanyId(String uuid, long companyId) {

		return _jobPostLocalService.getJobPostsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.savancys.model.JobPost>
		getJobPostsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.savancys.model.JobPost> orderByComparator) {

		return _jobPostLocalService.getJobPostsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of job posts.
	 *
	 * @return the number of job posts
	 */
	@Override
	public int getJobPostsCount() {
		return _jobPostLocalService.getJobPostsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobPostLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPostLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.savancys.model.JobPost saveOrUpdateJobPost(
		Long id, String jobPostName, String experience, String qualification,
		String location, String skills, String description, String salary,
		Boolean active) {

		return _jobPostLocalService.saveOrUpdateJobPost(
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
	@Override
	public com.savancys.model.JobPost updateJobPost(
		com.savancys.model.JobPost jobPost) {

		return _jobPostLocalService.updateJobPost(jobPost);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _jobPostLocalService.getBasePersistence();
	}

	@Override
	public JobPostLocalService getWrappedService() {
		return _jobPostLocalService;
	}

	@Override
	public void setWrappedService(JobPostLocalService jobPostLocalService) {
		_jobPostLocalService = jobPostLocalService;
	}

	private JobPostLocalService _jobPostLocalService;

}