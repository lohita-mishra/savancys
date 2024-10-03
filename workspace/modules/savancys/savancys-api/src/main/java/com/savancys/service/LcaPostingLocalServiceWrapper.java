/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LcaPostingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LcaPostingLocalService
 * @generated
 */
public class LcaPostingLocalServiceWrapper
	implements LcaPostingLocalService, ServiceWrapper<LcaPostingLocalService> {

	public LcaPostingLocalServiceWrapper() {
		this(null);
	}

	public LcaPostingLocalServiceWrapper(
		LcaPostingLocalService lcaPostingLocalService) {

		_lcaPostingLocalService = lcaPostingLocalService;
	}

	/**
	 * Adds the lca posting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LcaPostingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lcaPosting the lca posting
	 * @return the lca posting that was added
	 */
	@Override
	public com.savancys.model.LcaPosting addLcaPosting(
		com.savancys.model.LcaPosting lcaPosting) {

		return _lcaPostingLocalService.addLcaPosting(lcaPosting);
	}

	@Override
	public com.savancys.model.LcaPosting addLcaPosting(
		long groupId, String designation, String description, String location,
		String oNetCode) {

		return _lcaPostingLocalService.addLcaPosting(
			groupId, designation, description, location, oNetCode);
	}

	/**
	 * Creates a new lca posting with the primary key. Does not add the lca posting to the database.
	 *
	 * @param lcaPostingId the primary key for the new lca posting
	 * @return the new lca posting
	 */
	@Override
	public com.savancys.model.LcaPosting createLcaPosting(long lcaPostingId) {
		return _lcaPostingLocalService.createLcaPosting(lcaPostingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lcaPostingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the lca posting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LcaPostingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lcaPosting the lca posting
	 * @return the lca posting that was removed
	 */
	@Override
	public com.savancys.model.LcaPosting deleteLcaPosting(
		com.savancys.model.LcaPosting lcaPosting) {

		return _lcaPostingLocalService.deleteLcaPosting(lcaPosting);
	}

	/**
	 * Deletes the lca posting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LcaPostingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting that was removed
	 * @throws PortalException if a lca posting with the primary key could not be found
	 */
	@Override
	public com.savancys.model.LcaPosting deleteLcaPosting(long lcaPostingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lcaPostingLocalService.deleteLcaPosting(lcaPostingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lcaPostingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _lcaPostingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _lcaPostingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lcaPostingLocalService.dynamicQuery();
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

		return _lcaPostingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.LcaPostingModelImpl</code>.
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

		return _lcaPostingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.LcaPostingModelImpl</code>.
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

		return _lcaPostingLocalService.dynamicQuery(
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

		return _lcaPostingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lcaPostingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.savancys.model.LcaPosting fetchLcaPosting(long lcaPostingId) {
		return _lcaPostingLocalService.fetchLcaPosting(lcaPostingId);
	}

	/**
	 * Returns the lca posting matching the UUID and group.
	 *
	 * @param uuid the lca posting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public com.savancys.model.LcaPosting fetchLcaPostingByUuidAndGroupId(
		String uuid, long groupId) {

		return _lcaPostingLocalService.fetchLcaPostingByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lcaPostingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _lcaPostingLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lcaPostingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lca posting with the primary key.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting
	 * @throws PortalException if a lca posting with the primary key could not be found
	 */
	@Override
	public com.savancys.model.LcaPosting getLcaPosting(long lcaPostingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lcaPostingLocalService.getLcaPosting(lcaPostingId);
	}

	/**
	 * Returns the lca posting matching the UUID and group.
	 *
	 * @param uuid the lca posting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching lca posting
	 * @throws PortalException if a matching lca posting could not be found
	 */
	@Override
	public com.savancys.model.LcaPosting getLcaPostingByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lcaPostingLocalService.getLcaPostingByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the lca postings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.LcaPostingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @return the range of lca postings
	 */
	@Override
	public java.util.List<com.savancys.model.LcaPosting> getLcaPostings(
		int start, int end) {

		return _lcaPostingLocalService.getLcaPostings(start, end);
	}

	/**
	 * Returns all the lca postings matching the UUID and company.
	 *
	 * @param uuid the UUID of the lca postings
	 * @param companyId the primary key of the company
	 * @return the matching lca postings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.savancys.model.LcaPosting>
		getLcaPostingsByUuidAndCompanyId(String uuid, long companyId) {

		return _lcaPostingLocalService.getLcaPostingsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of lca postings matching the UUID and company.
	 *
	 * @param uuid the UUID of the lca postings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of lca postings
	 * @param end the upper bound of the range of lca postings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching lca postings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.savancys.model.LcaPosting>
		getLcaPostingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.savancys.model.LcaPosting> orderByComparator) {

		return _lcaPostingLocalService.getLcaPostingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of lca postings.
	 *
	 * @return the number of lca postings
	 */
	@Override
	public int getLcaPostingsCount() {
		return _lcaPostingLocalService.getLcaPostingsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lcaPostingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lcaPostingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the lca posting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LcaPostingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lcaPosting the lca posting
	 * @return the lca posting that was updated
	 */
	@Override
	public com.savancys.model.LcaPosting updateLcaPosting(
		com.savancys.model.LcaPosting lcaPosting) {

		return _lcaPostingLocalService.updateLcaPosting(lcaPosting);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _lcaPostingLocalService.getBasePersistence();
	}

	@Override
	public LcaPostingLocalService getWrappedService() {
		return _lcaPostingLocalService;
	}

	@Override
	public void setWrappedService(
		LcaPostingLocalService lcaPostingLocalService) {

		_lcaPostingLocalService = lcaPostingLocalService;
	}

	private LcaPostingLocalService _lcaPostingLocalService;

}