/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.savancys.exception.NoSuchLcaPostingException;
import com.savancys.model.LcaPosting;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lca posting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LcaPostingUtil
 * @generated
 */
@ProviderType
public interface LcaPostingPersistence extends BasePersistence<LcaPosting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LcaPostingUtil} to access the lca posting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lca postings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid(String uuid);

	/**
	 * Returns a range of all the lca postings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @return the range of matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the lca postings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lca postings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the lca postings before and after the current lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param lcaPostingId the primary key of the current lca posting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public LcaPosting[] findByUuid_PrevAndNext(
			long lcaPostingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Removes all the lca postings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of lca postings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lca postings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLcaPostingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findByUUID_G(String uuid, long groupId)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the lca posting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the lca posting that was removed
	 */
	public LcaPosting removeByUUID_G(String uuid, long groupId)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the number of lca postings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lca postings
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @return the range of matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the lca postings before and after the current lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param lcaPostingId the primary key of the current lca posting
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public LcaPosting[] findByUuid_C_PrevAndNext(
			long lcaPostingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Removes all the lca postings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lca postings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the lca postings where designation = &#63;.
	 *
	 * @param designation the designation
	 * @return the matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignation(String designation);

	/**
	 * Returns a range of all the lca postings where designation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param designation the designation
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @return the range of matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignation(
		String designation, int start, int end);

	/**
	 * Returns an ordered range of all the lca postings where designation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param designation the designation
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignation(
		String designation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lca postings where designation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param designation the designation
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignation(
		String designation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findBydesignation_First(
			String designation,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchBydesignation_First(
		String designation,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findBydesignation_Last(
			String designation,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchBydesignation_Last(
		String designation,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the lca postings before and after the current lca posting in the ordered set where designation = &#63;.
	 *
	 * @param lcaPostingId the primary key of the current lca posting
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public LcaPosting[] findBydesignation_PrevAndNext(
			long lcaPostingId, String designation,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Removes all the lca postings where designation = &#63; from the database.
	 *
	 * @param designation the designation
	 */
	public void removeBydesignation(String designation);

	/**
	 * Returns the number of lca postings where designation = &#63;.
	 *
	 * @param designation the designation
	 * @return the number of matching lca postings
	 */
	public int countBydesignation(String designation);

	/**
	 * Returns all the lca postings where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @return the matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignationAndLocation(
		String designation, String location);

	/**
	 * Returns a range of all the lca postings where designation = &#63; and location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @return the range of matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end);

	/**
	 * Returns an ordered range of all the lca postings where designation = &#63; and location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lca postings where designation = &#63; and location = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lca postings
	 */
	public java.util.List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findBydesignationAndLocation_First(
			String designation, String location,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchBydesignationAndLocation_First(
		String designation, String location,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public LcaPosting findBydesignationAndLocation_Last(
			String designation, String location,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public LcaPosting fetchBydesignationAndLocation_Last(
		String designation, String location,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns the lca postings before and after the current lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param lcaPostingId the primary key of the current lca posting
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public LcaPosting[] findBydesignationAndLocation_PrevAndNext(
			long lcaPostingId, String designation, String location,
			com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
				orderByComparator)
		throws NoSuchLcaPostingException;

	/**
	 * Removes all the lca postings where designation = &#63; and location = &#63; from the database.
	 *
	 * @param designation the designation
	 * @param location the location
	 */
	public void removeBydesignationAndLocation(
		String designation, String location);

	/**
	 * Returns the number of lca postings where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @return the number of matching lca postings
	 */
	public int countBydesignationAndLocation(
		String designation, String location);

	/**
	 * Caches the lca posting in the entity cache if it is enabled.
	 *
	 * @param lcaPosting the lca posting
	 */
	public void cacheResult(LcaPosting lcaPosting);

	/**
	 * Caches the lca postings in the entity cache if it is enabled.
	 *
	 * @param lcaPostings the lca postings
	 */
	public void cacheResult(java.util.List<LcaPosting> lcaPostings);

	/**
	 * Creates a new lca posting with the primary key. Does not add the lca posting to the database.
	 *
	 * @param lcaPostingId the primary key for the new lca posting
	 * @return the new lca posting
	 */
	public LcaPosting create(long lcaPostingId);

	/**
	 * Removes the lca posting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting that was removed
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public LcaPosting remove(long lcaPostingId)
		throws NoSuchLcaPostingException;

	public LcaPosting updateImpl(LcaPosting lcaPosting);

	/**
	 * Returns the lca posting with the primary key or throws a <code>NoSuchLcaPostingException</code> if it could not be found.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public LcaPosting findByPrimaryKey(long lcaPostingId)
		throws NoSuchLcaPostingException;

	/**
	 * Returns the lca posting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting, or <code>null</code> if a lca posting with the primary key could not be found
	 */
	public LcaPosting fetchByPrimaryKey(long lcaPostingId);

	/**
	 * Returns all the lca postings.
	 *
	 * @return the lca postings
	 */
	public java.util.List<LcaPosting> findAll();

	/**
	 * Returns a range of all the lca postings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @return the range of lca postings
	 */
	public java.util.List<LcaPosting> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lca postings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lca postings
	 */
	public java.util.List<LcaPosting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lca postings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lca postings
	 */
	public java.util.List<LcaPosting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LcaPosting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lca postings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lca postings.
	 *
	 * @return the number of lca postings
	 */
	public int countAll();

}