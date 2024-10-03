/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.savancys.model.LcaPosting;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lca posting service. This utility wraps <code>com.savancys.service.persistence.impl.LcaPostingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LcaPostingPersistence
 * @generated
 */
public class LcaPostingUtil {

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
	public static void clearCache(LcaPosting lcaPosting) {
		getPersistence().clearCache(lcaPosting);
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
	public static Map<Serializable, LcaPosting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LcaPosting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LcaPosting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LcaPosting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LcaPosting update(LcaPosting lcaPosting) {
		return getPersistence().update(lcaPosting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LcaPosting update(
		LcaPosting lcaPosting, ServiceContext serviceContext) {

		return getPersistence().update(lcaPosting, serviceContext);
	}

	/**
	 * Returns all the lca postings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lca postings
	 */
	public static List<LcaPosting> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<LcaPosting> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<LcaPosting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<LcaPosting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findByUuid_First(
			String uuid, OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchByUuid_First(
		String uuid, OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findByUuid_Last(
			String uuid, OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchByUuid_Last(
		String uuid, OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the lca postings before and after the current lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param lcaPostingId the primary key of the current lca posting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public static LcaPosting[] findByUuid_PrevAndNext(
			long lcaPostingId, String uuid,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUuid_PrevAndNext(
			lcaPostingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the lca postings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of lca postings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lca postings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLcaPostingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findByUUID_G(String uuid, long groupId)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the lca posting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the lca posting that was removed
	 */
	public static LcaPosting removeByUUID_G(String uuid, long groupId)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of lca postings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lca postings
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lca postings
	 */
	public static List<LcaPosting> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static LcaPosting[] findByUuid_C_PrevAndNext(
			long lcaPostingId, String uuid, long companyId,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			lcaPostingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the lca postings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lca postings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the lca postings where designation = &#63;.
	 *
	 * @param designation the designation
	 * @return the matching lca postings
	 */
	public static List<LcaPosting> findBydesignation(String designation) {
		return getPersistence().findBydesignation(designation);
	}

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
	public static List<LcaPosting> findBydesignation(
		String designation, int start, int end) {

		return getPersistence().findBydesignation(designation, start, end);
	}

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
	public static List<LcaPosting> findBydesignation(
		String designation, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().findBydesignation(
			designation, start, end, orderByComparator);
	}

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
	public static List<LcaPosting> findBydesignation(
		String designation, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydesignation(
			designation, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findBydesignation_First(
			String designation, OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findBydesignation_First(
			designation, orderByComparator);
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchBydesignation_First(
		String designation, OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchBydesignation_First(
			designation, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findBydesignation_Last(
			String designation, OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findBydesignation_Last(
			designation, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchBydesignation_Last(
		String designation, OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchBydesignation_Last(
			designation, orderByComparator);
	}

	/**
	 * Returns the lca postings before and after the current lca posting in the ordered set where designation = &#63;.
	 *
	 * @param lcaPostingId the primary key of the current lca posting
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public static LcaPosting[] findBydesignation_PrevAndNext(
			long lcaPostingId, String designation,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findBydesignation_PrevAndNext(
			lcaPostingId, designation, orderByComparator);
	}

	/**
	 * Removes all the lca postings where designation = &#63; from the database.
	 *
	 * @param designation the designation
	 */
	public static void removeBydesignation(String designation) {
		getPersistence().removeBydesignation(designation);
	}

	/**
	 * Returns the number of lca postings where designation = &#63;.
	 *
	 * @param designation the designation
	 * @return the number of matching lca postings
	 */
	public static int countBydesignation(String designation) {
		return getPersistence().countBydesignation(designation);
	}

	/**
	 * Returns all the lca postings where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @return the matching lca postings
	 */
	public static List<LcaPosting> findBydesignationAndLocation(
		String designation, String location) {

		return getPersistence().findBydesignationAndLocation(
			designation, location);
	}

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
	public static List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end) {

		return getPersistence().findBydesignationAndLocation(
			designation, location, start, end);
	}

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
	public static List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().findBydesignationAndLocation(
			designation, location, start, end, orderByComparator);
	}

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
	public static List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydesignationAndLocation(
			designation, location, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findBydesignationAndLocation_First(
			String designation, String location,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findBydesignationAndLocation_First(
			designation, location, orderByComparator);
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchBydesignationAndLocation_First(
		String designation, String location,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchBydesignationAndLocation_First(
			designation, location, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	public static LcaPosting findBydesignationAndLocation_Last(
			String designation, String location,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findBydesignationAndLocation_Last(
			designation, location, orderByComparator);
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchBydesignationAndLocation_Last(
		String designation, String location,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().fetchBydesignationAndLocation_Last(
			designation, location, orderByComparator);
	}

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
	public static LcaPosting[] findBydesignationAndLocation_PrevAndNext(
			long lcaPostingId, String designation, String location,
			OrderByComparator<LcaPosting> orderByComparator)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findBydesignationAndLocation_PrevAndNext(
			lcaPostingId, designation, location, orderByComparator);
	}

	/**
	 * Removes all the lca postings where designation = &#63; and location = &#63; from the database.
	 *
	 * @param designation the designation
	 * @param location the location
	 */
	public static void removeBydesignationAndLocation(
		String designation, String location) {

		getPersistence().removeBydesignationAndLocation(designation, location);
	}

	/**
	 * Returns the number of lca postings where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @return the number of matching lca postings
	 */
	public static int countBydesignationAndLocation(
		String designation, String location) {

		return getPersistence().countBydesignationAndLocation(
			designation, location);
	}

	/**
	 * Caches the lca posting in the entity cache if it is enabled.
	 *
	 * @param lcaPosting the lca posting
	 */
	public static void cacheResult(LcaPosting lcaPosting) {
		getPersistence().cacheResult(lcaPosting);
	}

	/**
	 * Caches the lca postings in the entity cache if it is enabled.
	 *
	 * @param lcaPostings the lca postings
	 */
	public static void cacheResult(List<LcaPosting> lcaPostings) {
		getPersistence().cacheResult(lcaPostings);
	}

	/**
	 * Creates a new lca posting with the primary key. Does not add the lca posting to the database.
	 *
	 * @param lcaPostingId the primary key for the new lca posting
	 * @return the new lca posting
	 */
	public static LcaPosting create(long lcaPostingId) {
		return getPersistence().create(lcaPostingId);
	}

	/**
	 * Removes the lca posting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting that was removed
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public static LcaPosting remove(long lcaPostingId)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().remove(lcaPostingId);
	}

	public static LcaPosting updateImpl(LcaPosting lcaPosting) {
		return getPersistence().updateImpl(lcaPosting);
	}

	/**
	 * Returns the lca posting with the primary key or throws a <code>NoSuchLcaPostingException</code> if it could not be found.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	public static LcaPosting findByPrimaryKey(long lcaPostingId)
		throws com.savancys.exception.NoSuchLcaPostingException {

		return getPersistence().findByPrimaryKey(lcaPostingId);
	}

	/**
	 * Returns the lca posting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting, or <code>null</code> if a lca posting with the primary key could not be found
	 */
	public static LcaPosting fetchByPrimaryKey(long lcaPostingId) {
		return getPersistence().fetchByPrimaryKey(lcaPostingId);
	}

	/**
	 * Returns all the lca postings.
	 *
	 * @return the lca postings
	 */
	public static List<LcaPosting> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LcaPosting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LcaPosting> findAll(
		int start, int end, OrderByComparator<LcaPosting> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LcaPosting> findAll(
		int start, int end, OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lca postings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lca postings.
	 *
	 * @return the number of lca postings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LcaPostingPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LcaPostingPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LcaPostingPersistence _persistence;

}