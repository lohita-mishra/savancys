/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.savancys.model.ContactUs;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the contact us service. This utility wraps <code>com.savancys.service.persistence.impl.ContactUsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactUsPersistence
 * @generated
 */
public class ContactUsUtil {

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
	public static void clearCache(ContactUs contactUs) {
		getPersistence().clearCache(contactUs);
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
	public static Map<Serializable, ContactUs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ContactUs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactUs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactUs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ContactUs update(ContactUs contactUs) {
		return getPersistence().update(contactUs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ContactUs update(
		ContactUs contactUs, ServiceContext serviceContext) {

		return getPersistence().update(contactUs, serviceContext);
	}

	/**
	 * Returns all the contact uses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact uses
	 */
	public static List<ContactUs> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the contact uses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @return the range of matching contact uses
	 */
	public static List<ContactUs> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the contact uses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact uses
	 */
	public static List<ContactUs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact uses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact uses
	 */
	public static List<ContactUs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ContactUs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByUuid_First(
			String uuid, OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByUuid_First(
		String uuid, OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByUuid_Last(
			String uuid, OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByUuid_Last(
		String uuid, OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the contact uses before and after the current contact us in the ordered set where uuid = &#63;.
	 *
	 * @param contactId the primary key of the current contact us
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact us
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public static ContactUs[] findByUuid_PrevAndNext(
			long contactId, String uuid,
			OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUuid_PrevAndNext(
			contactId, uuid, orderByComparator);
	}

	/**
	 * Removes all the contact uses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of contact uses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact uses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the contact us where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchContactUsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByUUID_G(String uuid, long groupId)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the contact us where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the contact us where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the contact us where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact us that was removed
	 */
	public static ContactUs removeByUUID_G(String uuid, long groupId)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of contact uses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact uses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact uses
	 */
	public static List<ContactUs> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @return the range of matching contact uses
	 */
	public static List<ContactUs> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact uses
	 */
	public static List<ContactUs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact uses
	 */
	public static List<ContactUs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactUs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the contact uses before and after the current contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param contactId the primary key of the current contact us
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact us
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public static ContactUs[] findByUuid_C_PrevAndNext(
			long contactId, String uuid, long companyId,
			OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			contactId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the contact uses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact uses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the contact uses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contact uses
	 */
	public static List<ContactUs> findByContactUsByGroupId(long groupId) {
		return getPersistence().findByContactUsByGroupId(groupId);
	}

	/**
	 * Returns a range of all the contact uses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @return the range of matching contact uses
	 */
	public static List<ContactUs> findByContactUsByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByContactUsByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the contact uses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact uses
	 */
	public static List<ContactUs> findByContactUsByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().findByContactUsByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact uses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching contact uses
	 */
	public static List<ContactUs> findByContactUsByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ContactUs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByContactUsByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first contact us in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByContactUsByGroupId_First(
			long groupId, OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByContactUsByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the first contact us in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByContactUsByGroupId_First(
		long groupId, OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().fetchByContactUsByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last contact us in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public static ContactUs findByContactUsByGroupId_Last(
			long groupId, OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByContactUsByGroupId_Last(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last contact us in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchByContactUsByGroupId_Last(
		long groupId, OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().fetchByContactUsByGroupId_Last(
			groupId, orderByComparator);
	}

	/**
	 * Returns the contact uses before and after the current contact us in the ordered set where groupId = &#63;.
	 *
	 * @param contactId the primary key of the current contact us
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact us
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public static ContactUs[] findByContactUsByGroupId_PrevAndNext(
			long contactId, long groupId,
			OrderByComparator<ContactUs> orderByComparator)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByContactUsByGroupId_PrevAndNext(
			contactId, groupId, orderByComparator);
	}

	/**
	 * Removes all the contact uses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByContactUsByGroupId(long groupId) {
		getPersistence().removeByContactUsByGroupId(groupId);
	}

	/**
	 * Returns the number of contact uses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contact uses
	 */
	public static int countByContactUsByGroupId(long groupId) {
		return getPersistence().countByContactUsByGroupId(groupId);
	}

	/**
	 * Caches the contact us in the entity cache if it is enabled.
	 *
	 * @param contactUs the contact us
	 */
	public static void cacheResult(ContactUs contactUs) {
		getPersistence().cacheResult(contactUs);
	}

	/**
	 * Caches the contact uses in the entity cache if it is enabled.
	 *
	 * @param contactUses the contact uses
	 */
	public static void cacheResult(List<ContactUs> contactUses) {
		getPersistence().cacheResult(contactUses);
	}

	/**
	 * Creates a new contact us with the primary key. Does not add the contact us to the database.
	 *
	 * @param contactId the primary key for the new contact us
	 * @return the new contact us
	 */
	public static ContactUs create(long contactId) {
		return getPersistence().create(contactId);
	}

	/**
	 * Removes the contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us that was removed
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public static ContactUs remove(long contactId)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().remove(contactId);
	}

	public static ContactUs updateImpl(ContactUs contactUs) {
		return getPersistence().updateImpl(contactUs);
	}

	/**
	 * Returns the contact us with the primary key or throws a <code>NoSuchContactUsException</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public static ContactUs findByPrimaryKey(long contactId)
		throws com.savancys.exception.NoSuchContactUsException {

		return getPersistence().findByPrimaryKey(contactId);
	}

	/**
	 * Returns the contact us with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us, or <code>null</code> if a contact us with the primary key could not be found
	 */
	public static ContactUs fetchByPrimaryKey(long contactId) {
		return getPersistence().fetchByPrimaryKey(contactId);
	}

	/**
	 * Returns all the contact uses.
	 *
	 * @return the contact uses
	 */
	public static List<ContactUs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @return the range of contact uses
	 */
	public static List<ContactUs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact uses
	 */
	public static List<ContactUs> findAll(
		int start, int end, OrderByComparator<ContactUs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contact uses
	 */
	public static List<ContactUs> findAll(
		int start, int end, OrderByComparator<ContactUs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the contact uses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of contact uses.
	 *
	 * @return the number of contact uses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ContactUsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ContactUsPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ContactUsPersistence _persistence;

}