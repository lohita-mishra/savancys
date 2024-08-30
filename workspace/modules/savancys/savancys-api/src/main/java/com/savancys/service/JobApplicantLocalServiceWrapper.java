/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link JobApplicantLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicantLocalService
 * @generated
 */
public class JobApplicantLocalServiceWrapper
	implements JobApplicantLocalService,
			   ServiceWrapper<JobApplicantLocalService> {

	public JobApplicantLocalServiceWrapper() {
		this(null);
	}

	public JobApplicantLocalServiceWrapper(
		JobApplicantLocalService jobApplicantLocalService) {

		_jobApplicantLocalService = jobApplicantLocalService;
	}

	/**
	 * Adds the job applicant to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobApplicantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobApplicant the job applicant
	 * @return the job applicant that was added
	 */
	@Override
	public com.savancys.model.JobApplicant addJobApplicant(
		com.savancys.model.JobApplicant jobApplicant) {

		return _jobApplicantLocalService.addJobApplicant(jobApplicant);
	}

	/**
	 * Creates a new job applicant with the primary key. Does not add the job applicant to the database.
	 *
	 * @param jobApplicantID the primary key for the new job applicant
	 * @return the new job applicant
	 */
	@Override
	public com.savancys.model.JobApplicant createJobApplicant(
		long jobApplicantID) {

		return _jobApplicantLocalService.createJobApplicant(jobApplicantID);
	}

	@Override
	public com.savancys.model.JobApplicant createJobApplicant(
		String firstName, String lastName, String jobType, String state,
		String email, String phoneNumber, long jobPostId, String message,
		String skills, long fileEntryId, String webAuthorization) {

		return _jobApplicantLocalService.createJobApplicant(
			firstName, lastName, jobType, state, email, phoneNumber, jobPostId,
			message, skills, fileEntryId, webAuthorization);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobApplicantLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the job applicant from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobApplicantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobApplicant the job applicant
	 * @return the job applicant that was removed
	 */
	@Override
	public com.savancys.model.JobApplicant deleteJobApplicant(
		com.savancys.model.JobApplicant jobApplicant) {

		return _jobApplicantLocalService.deleteJobApplicant(jobApplicant);
	}

	/**
	 * Deletes the job applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobApplicantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant that was removed
	 * @throws PortalException if a job applicant with the primary key could not be found
	 */
	@Override
	public com.savancys.model.JobApplicant deleteJobApplicant(
			long jobApplicantID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobApplicantLocalService.deleteJobApplicant(jobApplicantID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobApplicantLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _jobApplicantLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _jobApplicantLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobApplicantLocalService.dynamicQuery();
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

		return _jobApplicantLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.JobApplicantModelImpl</code>.
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

		return _jobApplicantLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.JobApplicantModelImpl</code>.
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

		return _jobApplicantLocalService.dynamicQuery(
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

		return _jobApplicantLocalService.dynamicQueryCount(dynamicQuery);
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

		return _jobApplicantLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.savancys.model.JobApplicant fetchJobApplicant(
		long jobApplicantID) {

		return _jobApplicantLocalService.fetchJobApplicant(jobApplicantID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobApplicantLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.savancys.model.JobApplicantDTO>
		getAppicantsByFilter(
			long jobPostId, java.util.Date startDate, java.util.Date endDate) {

		return _jobApplicantLocalService.getAppicantsByFilter(
			jobPostId, startDate, endDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobApplicantLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job applicant with the primary key.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant
	 * @throws PortalException if a job applicant with the primary key could not be found
	 */
	@Override
	public com.savancys.model.JobApplicant getJobApplicant(long jobApplicantID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobApplicantLocalService.getJobApplicant(jobApplicantID);
	}

	@Override
	public java.util.List<com.savancys.model.JobApplicant>
		getJobApplicantDetailsWithJobPostName(
			Long jobPostId, java.util.Date startDate, java.util.Date endDate) {

		return _jobApplicantLocalService.getJobApplicantDetailsWithJobPostName(
			jobPostId, startDate, endDate);
	}

	/**
	 * Returns a range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @return the range of job applicants
	 */
	@Override
	public java.util.List<com.savancys.model.JobApplicant> getJobApplicants(
		int start, int end) {

		return _jobApplicantLocalService.getJobApplicants(start, end);
	}

	/**
	 * Returns the number of job applicants.
	 *
	 * @return the number of job applicants
	 */
	@Override
	public int getJobApplicantsCount() {
		return _jobApplicantLocalService.getJobApplicantsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobApplicantLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobApplicantLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the job applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobApplicantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobApplicant the job applicant
	 * @return the job applicant that was updated
	 */
	@Override
	public com.savancys.model.JobApplicant updateJobApplicant(
		com.savancys.model.JobApplicant jobApplicant) {

		return _jobApplicantLocalService.updateJobApplicant(jobApplicant);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _jobApplicantLocalService.getBasePersistence();
	}

	@Override
	public JobApplicantLocalService getWrappedService() {
		return _jobApplicantLocalService;
	}

	@Override
	public void setWrappedService(
		JobApplicantLocalService jobApplicantLocalService) {

		_jobApplicantLocalService = jobApplicantLocalService;
	}

	private JobApplicantLocalService _jobApplicantLocalService;

}