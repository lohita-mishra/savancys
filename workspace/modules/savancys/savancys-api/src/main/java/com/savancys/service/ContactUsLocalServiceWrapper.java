/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ContactUsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactUsLocalService
 * @generated
 */
public class ContactUsLocalServiceWrapper
	implements ContactUsLocalService, ServiceWrapper<ContactUsLocalService> {

	public ContactUsLocalServiceWrapper() {
		this(null);
	}

	public ContactUsLocalServiceWrapper(
		ContactUsLocalService contactUsLocalService) {

		_contactUsLocalService = contactUsLocalService;
	}

	@Override
	public com.savancys.model.ContactUs addContact(
		String inquiryType, String firstName, String lastName,
		String phoneNumber, String email, String companyName, String country,
		String additionalInfo) {

		return _contactUsLocalService.addContact(
			inquiryType, firstName, lastName, phoneNumber, email, companyName,
			country, additionalInfo);
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
	@Override
	public com.savancys.model.ContactUs addContactUs(
		com.savancys.model.ContactUs contactUs) {

		return _contactUsLocalService.addContactUs(contactUs);
	}

	/**
	 * Creates a new contact us with the primary key. Does not add the contact us to the database.
	 *
	 * @param contactId the primary key for the new contact us
	 * @return the new contact us
	 */
	@Override
	public com.savancys.model.ContactUs createContactUs(long contactId) {
		return _contactUsLocalService.createContactUs(contactId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.savancys.model.ContactUs deleteContactUs(
		com.savancys.model.ContactUs contactUs) {

		return _contactUsLocalService.deleteContactUs(contactUs);
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
	@Override
	public com.savancys.model.ContactUs deleteContactUs(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.deleteContactUs(contactId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _contactUsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _contactUsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contactUsLocalService.dynamicQuery();
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

		return _contactUsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _contactUsLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _contactUsLocalService.dynamicQuery(
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

		return _contactUsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _contactUsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.savancys.model.ContactUs fetchContactUs(long contactId) {
		return _contactUsLocalService.fetchContactUs(contactId);
	}

	/**
	 * Returns the contact us matching the UUID and group.
	 *
	 * @param uuid the contact us's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact us, or <code>null</code> if a matching contact us could not be found
	 */
	@Override
	public com.savancys.model.ContactUs fetchContactUsByUuidAndGroupId(
		String uuid, long groupId) {

		return _contactUsLocalService.fetchContactUsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _contactUsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the contact us with the primary key.
	 *
	 * @param contactId the primary key of the contact us
	 * @return the contact us
	 * @throws PortalException if a contact us with the primary key could not be found
	 */
	@Override
	public com.savancys.model.ContactUs getContactUs(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.getContactUs(contactId);
	}

	/**
	 * Returns the contact us matching the UUID and group.
	 *
	 * @param uuid the contact us's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contact us
	 * @throws PortalException if a matching contact us could not be found
	 */
	@Override
	public com.savancys.model.ContactUs getContactUsByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.getContactUsByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.savancys.model.ContactUs> getContactUses(
		int start, int end) {

		return _contactUsLocalService.getContactUses(start, end);
	}

	/**
	 * Returns all the contact uses matching the UUID and company.
	 *
	 * @param uuid the UUID of the contact uses
	 * @param companyId the primary key of the company
	 * @return the matching contact uses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.savancys.model.ContactUs>
		getContactUsesByUuidAndCompanyId(String uuid, long companyId) {

		return _contactUsLocalService.getContactUsesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.savancys.model.ContactUs>
		getContactUsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.savancys.model.ContactUs> orderByComparator) {

		return _contactUsLocalService.getContactUsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of contact uses.
	 *
	 * @return the number of contact uses
	 */
	@Override
	public int getContactUsesCount() {
		return _contactUsLocalService.getContactUsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _contactUsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _contactUsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contactUsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.savancys.model.ContactUs saveSapnexxContact(
			String fullname, String phoneNumber, String email,
			String companyName, String additionalInfo,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contactUsLocalService.saveSapnexxContact(
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
	@Override
	public com.savancys.model.ContactUs updateContactUs(
		com.savancys.model.ContactUs contactUs) {

		return _contactUsLocalService.updateContactUs(contactUs);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _contactUsLocalService.getBasePersistence();
	}

	@Override
	public ContactUsLocalService getWrappedService() {
		return _contactUsLocalService;
	}

	@Override
	public void setWrappedService(ContactUsLocalService contactUsLocalService) {
		_contactUsLocalService = contactUsLocalService;
	}

	private ContactUsLocalService _contactUsLocalService;

}