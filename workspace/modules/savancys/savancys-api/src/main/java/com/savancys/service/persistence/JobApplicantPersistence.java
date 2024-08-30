/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.savancys.exception.NoSuchJobApplicantException;
import com.savancys.model.JobApplicant;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicantUtil
 * @generated
 */
@ProviderType
public interface JobApplicantPersistence extends BasePersistence<JobApplicant> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobApplicantUtil} to access the job applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the job applicant in the entity cache if it is enabled.
	 *
	 * @param jobApplicant the job applicant
	 */
	public void cacheResult(JobApplicant jobApplicant);

	/**
	 * Caches the job applicants in the entity cache if it is enabled.
	 *
	 * @param jobApplicants the job applicants
	 */
	public void cacheResult(java.util.List<JobApplicant> jobApplicants);

	/**
	 * Creates a new job applicant with the primary key. Does not add the job applicant to the database.
	 *
	 * @param jobApplicantID the primary key for the new job applicant
	 * @return the new job applicant
	 */
	public JobApplicant create(long jobApplicantID);

	/**
	 * Removes the job applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant that was removed
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	public JobApplicant remove(long jobApplicantID)
		throws NoSuchJobApplicantException;

	public JobApplicant updateImpl(JobApplicant jobApplicant);

	/**
	 * Returns the job applicant with the primary key or throws a <code>NoSuchJobApplicantException</code> if it could not be found.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	public JobApplicant findByPrimaryKey(long jobApplicantID)
		throws NoSuchJobApplicantException;

	/**
	 * Returns the job applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant, or <code>null</code> if a job applicant with the primary key could not be found
	 */
	public JobApplicant fetchByPrimaryKey(long jobApplicantID);

	/**
	 * Returns all the job applicants.
	 *
	 * @return the job applicants
	 */
	public java.util.List<JobApplicant> findAll();

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
	public java.util.List<JobApplicant> findAll(int start, int end);

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
	public java.util.List<JobApplicant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobApplicant>
			orderByComparator);

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
	public java.util.List<JobApplicant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobApplicant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the job applicants from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of job applicants.
	 *
	 * @return the number of job applicants
	 */
	public int countAll();

}