/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.savancys.model.ContactUs;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ContactUs. This utility wraps
 * <code>com.savancys.service.impl.ContactUsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactUsLocalService
 * @generated
 */
public class ContactUsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.savancys.service.impl.ContactUsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ContactUs addContact(
		long groupId, String inquiryType, String firstName, String lastName,
		String phoneNumber, String email, String companyName, String country,
		String additionalInfo) {

		return getService().addContact(
			groupId, inquiryType, firstName, lastName, phoneNumber, email,
			companyName, country, additionalInfo);
	}

	/**
	 * Adds the contact us to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactUsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactUs the contact us
	 * @return the contact us that was added
	 */
	public static ContactUs addContactUs(ContactUs contactUs) {
		return getService().addContactUs(contactUs);
	}

	/**
	 * Creates a new contact us with the primary key. Does not add the contact us to the database.
	 *
	 * @param contactId the primary key for the new contact us
	 * @return the new contact us
	 */
	public static ContactUs createContactUs(long contactId) {
		return getService().createContactUs(contactId);
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
	 * Deletes the contact us from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactUsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactUs the contact us
	 * @return the contact us that was removed
	 */
	public static ContactUs deleteContactUs(ContactUs contactUs) {
		return getService().deleteContactUs(contactUs);
	}

	/**
	 * Deletes the contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactUsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us that was removed
	 * @throws PortalException if a contact us with the primary key could not be found
	 */
	public static ContactUs deleteContactUs(long contactId)
		throws PortalException {

		return getService().deleteContactUs(contactId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.ContactUsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.ContactUsModelImpl</code>.
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

	public static ContactUs fetchContactUs(long contactId) {
		return getService().fetchContactUs(contactId);
	}

	/**
	 * Returns the contact us matching the UUID and group.
	 *
	 * @param uuid the contact us's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	public static ContactUs fetchContactUsByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchContactUsByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the contact us with the primary key.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us
	 * @throws PortalException if a contact us with the primary key could not be found
	 */
	public static ContactUs getContactUs(long contactId)
		throws PortalException {

		return getService().getContactUs(contactId);
	}

	public static List<ContactUs> getContactUsByGroupId(long groupId) {
		return getService().getContactUsByGroupId(groupId);
	}

	/**
	 * Returns the contact us matching the UUID and group.
	 *
	 * @param uuid the contact us's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact us
	 * @throws PortalException if a matching contact us could not be found
	 */
	public static ContactUs getContactUsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getContactUsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.ContactUsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @return the range of contact uses
	 */
	public static List<ContactUs> getContactUses(int start, int end) {
		return getService().getContactUses(start, end);
	}

	/**
	 * Returns all the contact uses matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact uses
	 * @param companyId the primary key of the company
	 * @return the matching contact uses, or an empty list if no matches were found
	 */
	public static List<ContactUs> getContactUsesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getContactUsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of contact uses matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact uses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of contact uses
	 * @param end the upper bound of the range of contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching contact uses, or an empty list if no matches were found
	 */
	public static List<ContactUs> getContactUsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ContactUs> orderByComparator) {

		return getService().getContactUsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of contact uses.
	 *
	 * @return the number of contact uses
	 */
	public static int getContactUsesCount() {
		return getService().getContactUsesCount();
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

	public static ContactUs saveRFNEXxContact(
			String type, String fullname, String street, String city,
			String postcode, String phoneNumber, String email,
			String additionalInfo,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().saveRFNEXxContact(
			type, fullname, street, city, postcode, phoneNumber, email,
			additionalInfo, themeDisplay);
	}

	public static ContactUs saveSapnexxContact(
			String fullname, String phoneNumber, String email,
			String companyName, String additionalInfo,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().saveSapnexxContact(
			fullname, phoneNumber, email, companyName, additionalInfo,
			themeDisplay);
	}

	/**
	 * Updates the contact us in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContactUsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contactUs the contact us
	 * @return the contact us that was updated
	 */
	public static ContactUs updateContactUs(ContactUs contactUs) {
		return getService().updateContactUs(contactUs);
	}

	public static ContactUsLocalService getService() {
		return _service;
	}

	public static void setService(ContactUsLocalService service) {
		_service = service;
	}

	private static volatile ContactUsLocalService _service;

}