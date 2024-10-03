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

import com.savancys.model.LcaPosting;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LcaPosting. This utility wraps
 * <code>com.savancys.service.impl.LcaPostingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LcaPostingLocalService
 * @generated
 */
public class LcaPostingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.savancys.service.impl.LcaPostingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LcaPosting addLcaPosting(LcaPosting lcaPosting) {
		return getService().addLcaPosting(lcaPosting);
	}

	public static LcaPosting addLcaPosting(
		long groupId, String designation, String description, String location,
		String oNetCode) {

		return getService().addLcaPosting(
			groupId, designation, description, location, oNetCode);
	}

	/**
	 * Creates a new lca posting with the primary key. Does not add the lca posting to the database.
	 *
	 * @param lcaPostingId the primary key for the new lca posting
	 * @return the new lca posting
	 */
	public static LcaPosting createLcaPosting(long lcaPostingId) {
		return getService().createLcaPosting(lcaPostingId);
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
	 * Deletes the lca posting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LcaPostingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lcaPosting the lca posting
	 * @return the lca posting that was removed
	 */
	public static LcaPosting deleteLcaPosting(LcaPosting lcaPosting) {
		return getService().deleteLcaPosting(lcaPosting);
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
	public static LcaPosting deleteLcaPosting(long lcaPostingId)
		throws PortalException {

		return getService().deleteLcaPosting(lcaPostingId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.LcaPostingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.savancys.model.impl.LcaPostingModelImpl</code>.
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

	public static LcaPosting fetchLcaPosting(long lcaPostingId) {
		return getService().fetchLcaPosting(lcaPostingId);
	}

	/**
	 * Returns the lca posting matching the UUID and group.
	 *
	 * @param uuid the lca posting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	public static LcaPosting fetchLcaPostingByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLcaPostingByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the lca posting with the primary key.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting
	 * @throws PortalException if a lca posting with the primary key could not be found
	 */
	public static LcaPosting getLcaPosting(long lcaPostingId)
		throws PortalException {

		return getService().getLcaPosting(lcaPostingId);
	}

	/**
	 * Returns the lca posting matching the UUID and group.
	 *
	 * @param uuid the lca posting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching lca posting
	 * @throws PortalException if a matching lca posting could not be found
	 */
	public static LcaPosting getLcaPostingByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLcaPostingByUuidAndGroupId(uuid, groupId);
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
	public static List<LcaPosting> getLcaPostings(int start, int end) {
		return getService().getLcaPostings(start, end);
	}

	/**
	 * Returns all the lca postings matching the UUID and company.
	 *
	 * @param uuid the UUID of the lca postings
	 * @param companyId the primary key of the company
	 * @return the matching lca postings, or an empty list if no matches were found
	 */
	public static List<LcaPosting> getLcaPostingsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLcaPostingsByUuidAndCompanyId(uuid, companyId);
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
	public static List<LcaPosting> getLcaPostingsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return getService().getLcaPostingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of lca postings.
	 *
	 * @return the number of lca postings
	 */
	public static int getLcaPostingsCount() {
		return getService().getLcaPostingsCount();
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
	public static LcaPosting updateLcaPosting(LcaPosting lcaPosting) {
		return getService().updateLcaPosting(lcaPosting);
	}

	public static LcaPostingLocalService getService() {
		return _service;
	}

	public static void setService(LcaPostingLocalService service) {
		_service = service;
	}

	private static volatile LcaPostingLocalService _service;

}