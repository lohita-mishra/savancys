/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.savancys.exception.NoSuchContactUsException;
import com.savancys.model.ContactUs;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the contact us service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactUsUtil
 * @generated
 */
@ProviderType
public interface ContactUsPersistence extends BasePersistence<ContactUs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactUsUtil} to access the contact us persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the contact uses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact uses
	 */
	public java.util.List<ContactUs> findByUuid(String uuid);

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
	public java.util.List<ContactUs> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ContactUs> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

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
	public java.util.List<ContactUs> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public ContactUs findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
				orderByComparator)
		throws NoSuchContactUsException;

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public ContactUs fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public ContactUs findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
				orderByComparator)
		throws NoSuchContactUsException;

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public ContactUs fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

	/**
	 * Returns the contact uses before and after the current contact us in the ordered set where uuid = &#63;.
	 *
	 * @param contactId the primary key of the current contact us
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact us
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public ContactUs[] findByUuid_PrevAndNext(
			long contactId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
				orderByComparator)
		throws NoSuchContactUsException;

	/**
	 * Removes all the contact uses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of contact uses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact uses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the contact us where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchContactUsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public ContactUs findByUUID_G(String uuid, long groupId)
		throws NoSuchContactUsException;

	/**
	 * Returns the contact us where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public ContactUs fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the contact us where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public ContactUs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the contact us where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact us that was removed
	 */
	public ContactUs removeByUUID_G(String uuid, long groupId)
		throws NoSuchContactUsException;

	/**
	 * Returns the number of contact uses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact uses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact uses
	 */
	public java.util.List<ContactUs> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<ContactUs> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ContactUs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

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
	public java.util.List<ContactUs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public ContactUs findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
				orderByComparator)
		throws NoSuchContactUsException;

	/**
	 * Returns the first contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public ContactUs fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us
	 * @throws NoSuchContactUsException if a matching contact us could not be found
	 */
	public ContactUs findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
				orderByComparator)
		throws NoSuchContactUsException;

	/**
	 * Returns the last contact us in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public ContactUs fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

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
	public ContactUs[] findByUuid_C_PrevAndNext(
			long contactId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
				orderByComparator)
		throws NoSuchContactUsException;

	/**
	 * Removes all the contact uses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of contact uses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact uses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the contact us in the entity cache if it is enabled.
	 *
	 * @param contactUs the contact us
	 */
	public void cacheResult(ContactUs contactUs);

	/**
	 * Caches the contact uses in the entity cache if it is enabled.
	 *
	 * @param contactUses the contact uses
	 */
	public void cacheResult(java.util.List<ContactUs> contactUses);

	/**
	 * Creates a new contact us with the primary key. Does not add the contact us to the database.
	 *
	 * @param contactId the primary key for the new contact us
	 * @return the new contact us
	 */
	public ContactUs create(long contactId);

	/**
	 * Removes the contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us that was removed
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public ContactUs remove(long contactId) throws NoSuchContactUsException;

	public ContactUs updateImpl(ContactUs contactUs);

	/**
	 * Returns the contact us with the primary key or throws a <code>NoSuchContactUsException</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us
	 * @throws NoSuchContactUsException if a contact us with the primary key could not be found
	 */
	public ContactUs findByPrimaryKey(long contactId)
		throws NoSuchContactUsException;

	/**
	 * Returns the contact us with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us, or <code>null</code> if a contact us with the primary key could not be found
	 */
	public ContactUs fetchByPrimaryKey(long contactId);

	/**
	 * Returns all the contact uses.
	 *
	 * @return the contact uses
	 */
	public java.util.List<ContactUs> findAll();

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
	public java.util.List<ContactUs> findAll(int start, int end);

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
	public java.util.List<ContactUs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator);

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
	public java.util.List<ContactUs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContactUs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the contact uses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of contact uses.
	 *
	 * @return the number of contact uses
	 */
	public int countAll();

}