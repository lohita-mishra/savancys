/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.savancys.exception.NoSuchLcaPostingException;
import com.savancys.model.LcaPosting;
import com.savancys.model.LcaPostingTable;
import com.savancys.model.impl.LcaPostingImpl;
import com.savancys.model.impl.LcaPostingModelImpl;
import com.savancys.service.persistence.LcaPostingPersistence;
import com.savancys.service.persistence.LcaPostingUtil;
import com.savancys.service.persistence.impl.constants.sysPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the lca posting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LcaPostingPersistence.class)
public class LcaPostingPersistenceImpl
	extends BasePersistenceImpl<LcaPosting> implements LcaPostingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LcaPostingUtil</code> to access the lca posting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LcaPostingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the lca postings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lca postings
	 */
	@Override
	public List<LcaPosting> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LcaPosting> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<LcaPosting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<LcaPosting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<LcaPosting> list = null;

		if (useFinderCache) {
			list = (List<LcaPosting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LcaPosting lcaPosting : list) {
					if (!uuid.equals(lcaPosting.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<LcaPosting>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting findByUuid_First(
			String uuid, OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchByUuid_First(uuid, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchByUuid_First(
		String uuid, OrderByComparator<LcaPosting> orderByComparator) {

		List<LcaPosting> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting findByUuid_Last(
			String uuid, OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchByUuid_Last(uuid, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchByUuid_Last(
		String uuid, OrderByComparator<LcaPosting> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LcaPosting> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LcaPosting[] findByUuid_PrevAndNext(
			long lcaPostingId, String uuid,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		uuid = Objects.toString(uuid, "");

		LcaPosting lcaPosting = findByPrimaryKey(lcaPostingId);

		Session session = null;

		try {
			session = openSession();

			LcaPosting[] array = new LcaPostingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, lcaPosting, uuid, orderByComparator, true);

			array[1] = lcaPosting;

			array[2] = getByUuid_PrevAndNext(
				session, lcaPosting, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LcaPosting getByUuid_PrevAndNext(
		Session session, LcaPosting lcaPosting, String uuid,
		OrderByComparator<LcaPosting> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lcaPosting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LcaPosting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lca postings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LcaPosting lcaPosting :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lcaPosting);
		}
	}

	/**
	 * Returns the number of lca postings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lca postings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LCAPOSTING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"lcaPosting.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(lcaPosting.uuid IS NULL OR lcaPosting.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLcaPostingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting findByUUID_G(String uuid, long groupId)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchByUUID_G(uuid, groupId);

		if (lcaPosting == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLcaPostingException(sb.toString());
		}

		return lcaPosting;
	}

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the lca posting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof LcaPosting) {
			LcaPosting lcaPosting = (LcaPosting)result;

			if (!Objects.equals(uuid, lcaPosting.getUuid()) ||
				(groupId != lcaPosting.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<LcaPosting> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LcaPosting lcaPosting = list.get(0);

					result = lcaPosting;

					cacheResult(lcaPosting);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LcaPosting)result;
		}
	}

	/**
	 * Removes the lca posting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the lca posting that was removed
	 */
	@Override
	public LcaPosting removeByUUID_G(String uuid, long groupId)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = findByUUID_G(uuid, groupId);

		return remove(lcaPosting);
	}

	/**
	 * Returns the number of lca postings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lca postings
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LCAPOSTING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"lcaPosting.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(lcaPosting.uuid IS NULL OR lcaPosting.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"lcaPosting.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lca postings
	 */
	@Override
	public List<LcaPosting> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<LcaPosting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<LcaPosting> list = null;

		if (useFinderCache) {
			list = (List<LcaPosting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LcaPosting lcaPosting : list) {
					if (!uuid.equals(lcaPosting.getUuid()) ||
						(companyId != lcaPosting.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<LcaPosting>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LcaPosting findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the first lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LcaPosting> orderByComparator) {

		List<LcaPosting> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LcaPosting findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the last lca posting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LcaPosting> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LcaPosting> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LcaPosting[] findByUuid_C_PrevAndNext(
			long lcaPostingId, String uuid, long companyId,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		uuid = Objects.toString(uuid, "");

		LcaPosting lcaPosting = findByPrimaryKey(lcaPostingId);

		Session session = null;

		try {
			session = openSession();

			LcaPosting[] array = new LcaPostingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, lcaPosting, uuid, companyId, orderByComparator, true);

			array[1] = lcaPosting;

			array[2] = getByUuid_C_PrevAndNext(
				session, lcaPosting, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LcaPosting getByUuid_C_PrevAndNext(
		Session session, LcaPosting lcaPosting, String uuid, long companyId,
		OrderByComparator<LcaPosting> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lcaPosting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LcaPosting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lca postings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LcaPosting lcaPosting :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lcaPosting);
		}
	}

	/**
	 * Returns the number of lca postings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lca postings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LCAPOSTING_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"lcaPosting.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(lcaPosting.uuid IS NULL OR lcaPosting.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"lcaPosting.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBydesignation;
	private FinderPath _finderPathWithoutPaginationFindBydesignation;
	private FinderPath _finderPathCountBydesignation;

	/**
	 * Returns all the lca postings where designation = &#63;.
	 *
	 * @param designation the designation
	 * @return the matching lca postings
	 */
	@Override
	public List<LcaPosting> findBydesignation(String designation) {
		return findBydesignation(
			designation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LcaPosting> findBydesignation(
		String designation, int start, int end) {

		return findBydesignation(designation, start, end, null);
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
	@Override
	public List<LcaPosting> findBydesignation(
		String designation, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return findBydesignation(
			designation, start, end, orderByComparator, true);
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
	@Override
	public List<LcaPosting> findBydesignation(
		String designation, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		designation = Objects.toString(designation, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydesignation;
				finderArgs = new Object[] {designation};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydesignation;
			finderArgs = new Object[] {
				designation, start, end, orderByComparator
			};
		}

		List<LcaPosting> list = null;

		if (useFinderCache) {
			list = (List<LcaPosting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LcaPosting lcaPosting : list) {
					if (!designation.equals(lcaPosting.getDesignation())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

			boolean bindDesignation = false;

			if (designation.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATION_DESIGNATION_3);
			}
			else {
				bindDesignation = true;

				sb.append(_FINDER_COLUMN_DESIGNATION_DESIGNATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignation) {
					queryPos.add(designation);
				}

				list = (List<LcaPosting>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting findBydesignation_First(
			String designation, OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchBydesignation_First(
			designation, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designation=");
		sb.append(designation);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchBydesignation_First(
		String designation, OrderByComparator<LcaPosting> orderByComparator) {

		List<LcaPosting> list = findBydesignation(
			designation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting
	 * @throws NoSuchLcaPostingException if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting findBydesignation_Last(
			String designation, OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchBydesignation_Last(
			designation, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designation=");
		sb.append(designation);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63;.
	 *
	 * @param designation the designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchBydesignation_Last(
		String designation, OrderByComparator<LcaPosting> orderByComparator) {

		int count = countBydesignation(designation);

		if (count == 0) {
			return null;
		}

		List<LcaPosting> list = findBydesignation(
			designation, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LcaPosting[] findBydesignation_PrevAndNext(
			long lcaPostingId, String designation,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		designation = Objects.toString(designation, "");

		LcaPosting lcaPosting = findByPrimaryKey(lcaPostingId);

		Session session = null;

		try {
			session = openSession();

			LcaPosting[] array = new LcaPostingImpl[3];

			array[0] = getBydesignation_PrevAndNext(
				session, lcaPosting, designation, orderByComparator, true);

			array[1] = lcaPosting;

			array[2] = getBydesignation_PrevAndNext(
				session, lcaPosting, designation, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LcaPosting getBydesignation_PrevAndNext(
		Session session, LcaPosting lcaPosting, String designation,
		OrderByComparator<LcaPosting> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

		boolean bindDesignation = false;

		if (designation.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESIGNATION_DESIGNATION_3);
		}
		else {
			bindDesignation = true;

			sb.append(_FINDER_COLUMN_DESIGNATION_DESIGNATION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDesignation) {
			queryPos.add(designation);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lcaPosting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LcaPosting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lca postings where designation = &#63; from the database.
	 *
	 * @param designation the designation
	 */
	@Override
	public void removeBydesignation(String designation) {
		for (LcaPosting lcaPosting :
				findBydesignation(
					designation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lcaPosting);
		}
	}

	/**
	 * Returns the number of lca postings where designation = &#63;.
	 *
	 * @param designation the designation
	 * @return the number of matching lca postings
	 */
	@Override
	public int countBydesignation(String designation) {
		designation = Objects.toString(designation, "");

		FinderPath finderPath = _finderPathCountBydesignation;

		Object[] finderArgs = new Object[] {designation};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LCAPOSTING_WHERE);

			boolean bindDesignation = false;

			if (designation.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATION_DESIGNATION_3);
			}
			else {
				bindDesignation = true;

				sb.append(_FINDER_COLUMN_DESIGNATION_DESIGNATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignation) {
					queryPos.add(designation);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DESIGNATION_DESIGNATION_2 =
		"lcaPosting.designation = ?";

	private static final String _FINDER_COLUMN_DESIGNATION_DESIGNATION_3 =
		"(lcaPosting.designation IS NULL OR lcaPosting.designation = '')";

	private FinderPath _finderPathWithPaginationFindBydesignationAndLocation;
	private FinderPath _finderPathWithoutPaginationFindBydesignationAndLocation;
	private FinderPath _finderPathCountBydesignationAndLocation;

	/**
	 * Returns all the lca postings where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @return the matching lca postings
	 */
	@Override
	public List<LcaPosting> findBydesignationAndLocation(
		String designation, String location) {

		return findBydesignationAndLocation(
			designation, location, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end) {

		return findBydesignationAndLocation(
			designation, location, start, end, null);
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
	@Override
	public List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator) {

		return findBydesignationAndLocation(
			designation, location, start, end, orderByComparator, true);
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
	@Override
	public List<LcaPosting> findBydesignationAndLocation(
		String designation, String location, int start, int end,
		OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		designation = Objects.toString(designation, "");
		location = Objects.toString(location, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydesignationAndLocation;
				finderArgs = new Object[] {designation, location};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydesignationAndLocation;
			finderArgs = new Object[] {
				designation, location, start, end, orderByComparator
			};
		}

		List<LcaPosting> list = null;

		if (useFinderCache) {
			list = (List<LcaPosting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LcaPosting lcaPosting : list) {
					if (!designation.equals(lcaPosting.getDesignation()) ||
						!location.equals(lcaPosting.getLocation())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

			boolean bindDesignation = false;

			if (designation.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_3);
			}
			else {
				bindDesignation = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_2);
			}

			boolean bindLocation = false;

			if (location.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignation) {
					queryPos.add(designation);
				}

				if (bindLocation) {
					queryPos.add(location);
				}

				list = (List<LcaPosting>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LcaPosting findBydesignationAndLocation_First(
			String designation, String location,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchBydesignationAndLocation_First(
			designation, location, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designation=");
		sb.append(designation);

		sb.append(", location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the first lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchBydesignationAndLocation_First(
		String designation, String location,
		OrderByComparator<LcaPosting> orderByComparator) {

		List<LcaPosting> list = findBydesignationAndLocation(
			designation, location, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LcaPosting findBydesignationAndLocation_Last(
			String designation, String location,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchBydesignationAndLocation_Last(
			designation, location, orderByComparator);

		if (lcaPosting != null) {
			return lcaPosting;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designation=");
		sb.append(designation);

		sb.append(", location=");
		sb.append(location);

		sb.append("}");

		throw new NoSuchLcaPostingException(sb.toString());
	}

	/**
	 * Returns the last lca posting in the ordered set where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lca posting, or <code>null</code> if a matching lca posting could not be found
	 */
	@Override
	public LcaPosting fetchBydesignationAndLocation_Last(
		String designation, String location,
		OrderByComparator<LcaPosting> orderByComparator) {

		int count = countBydesignationAndLocation(designation, location);

		if (count == 0) {
			return null;
		}

		List<LcaPosting> list = findBydesignationAndLocation(
			designation, location, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LcaPosting[] findBydesignationAndLocation_PrevAndNext(
			long lcaPostingId, String designation, String location,
			OrderByComparator<LcaPosting> orderByComparator)
		throws NoSuchLcaPostingException {

		designation = Objects.toString(designation, "");
		location = Objects.toString(location, "");

		LcaPosting lcaPosting = findByPrimaryKey(lcaPostingId);

		Session session = null;

		try {
			session = openSession();

			LcaPosting[] array = new LcaPostingImpl[3];

			array[0] = getBydesignationAndLocation_PrevAndNext(
				session, lcaPosting, designation, location, orderByComparator,
				true);

			array[1] = lcaPosting;

			array[2] = getBydesignationAndLocation_PrevAndNext(
				session, lcaPosting, designation, location, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LcaPosting getBydesignationAndLocation_PrevAndNext(
		Session session, LcaPosting lcaPosting, String designation,
		String location, OrderByComparator<LcaPosting> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LCAPOSTING_WHERE);

		boolean bindDesignation = false;

		if (designation.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_3);
		}
		else {
			bindDesignation = true;

			sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_2);
		}

		boolean bindLocation = false;

		if (location.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_3);
		}
		else {
			bindLocation = true;

			sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LcaPostingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDesignation) {
			queryPos.add(designation);
		}

		if (bindLocation) {
			queryPos.add(location);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lcaPosting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LcaPosting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lca postings where designation = &#63; and location = &#63; from the database.
	 *
	 * @param designation the designation
	 * @param location the location
	 */
	@Override
	public void removeBydesignationAndLocation(
		String designation, String location) {

		for (LcaPosting lcaPosting :
				findBydesignationAndLocation(
					designation, location, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lcaPosting);
		}
	}

	/**
	 * Returns the number of lca postings where designation = &#63; and location = &#63;.
	 *
	 * @param designation the designation
	 * @param location the location
	 * @return the number of matching lca postings
	 */
	@Override
	public int countBydesignationAndLocation(
		String designation, String location) {

		designation = Objects.toString(designation, "");
		location = Objects.toString(location, "");

		FinderPath finderPath = _finderPathCountBydesignationAndLocation;

		Object[] finderArgs = new Object[] {designation, location};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LCAPOSTING_WHERE);

			boolean bindDesignation = false;

			if (designation.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_3);
			}
			else {
				bindDesignation = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_2);
			}

			boolean bindLocation = false;

			if (location.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_3);
			}
			else {
				bindLocation = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignation) {
					queryPos.add(designation);
				}

				if (bindLocation) {
					queryPos.add(location);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_2 =
			"lcaPosting.designation = ? AND ";

	private static final String
		_FINDER_COLUMN_DESIGNATIONANDLOCATION_DESIGNATION_3 =
			"(lcaPosting.designation IS NULL OR lcaPosting.designation = '') AND ";

	private static final String
		_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_2 =
			"lcaPosting.location = ?";

	private static final String
		_FINDER_COLUMN_DESIGNATIONANDLOCATION_LOCATION_3 =
			"(lcaPosting.location IS NULL OR lcaPosting.location = '')";

	public LcaPostingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LcaPosting.class);

		setModelImplClass(LcaPostingImpl.class);
		setModelPKClass(long.class);

		setTable(LcaPostingTable.INSTANCE);
	}

	/**
	 * Caches the lca posting in the entity cache if it is enabled.
	 *
	 * @param lcaPosting the lca posting
	 */
	@Override
	public void cacheResult(LcaPosting lcaPosting) {
		entityCache.putResult(
			LcaPostingImpl.class, lcaPosting.getPrimaryKey(), lcaPosting);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {lcaPosting.getUuid(), lcaPosting.getGroupId()},
			lcaPosting);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lca postings in the entity cache if it is enabled.
	 *
	 * @param lcaPostings the lca postings
	 */
	@Override
	public void cacheResult(List<LcaPosting> lcaPostings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lcaPostings.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LcaPosting lcaPosting : lcaPostings) {
			if (entityCache.getResult(
					LcaPostingImpl.class, lcaPosting.getPrimaryKey()) == null) {

				cacheResult(lcaPosting);
			}
		}
	}

	/**
	 * Clears the cache for all lca postings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LcaPostingImpl.class);

		finderCache.clearCache(LcaPostingImpl.class);
	}

	/**
	 * Clears the cache for the lca posting.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LcaPosting lcaPosting) {
		entityCache.removeResult(LcaPostingImpl.class, lcaPosting);
	}

	@Override
	public void clearCache(List<LcaPosting> lcaPostings) {
		for (LcaPosting lcaPosting : lcaPostings) {
			entityCache.removeResult(LcaPostingImpl.class, lcaPosting);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LcaPostingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LcaPostingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LcaPostingModelImpl lcaPostingModelImpl) {

		Object[] args = new Object[] {
			lcaPostingModelImpl.getUuid(), lcaPostingModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, lcaPostingModelImpl);
	}

	/**
	 * Creates a new lca posting with the primary key. Does not add the lca posting to the database.
	 *
	 * @param lcaPostingId the primary key for the new lca posting
	 * @return the new lca posting
	 */
	@Override
	public LcaPosting create(long lcaPostingId) {
		LcaPosting lcaPosting = new LcaPostingImpl();

		lcaPosting.setNew(true);
		lcaPosting.setPrimaryKey(lcaPostingId);

		String uuid = PortalUUIDUtil.generate();

		lcaPosting.setUuid(uuid);

		lcaPosting.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lcaPosting;
	}

	/**
	 * Removes the lca posting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting that was removed
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	@Override
	public LcaPosting remove(long lcaPostingId)
		throws NoSuchLcaPostingException {

		return remove((Serializable)lcaPostingId);
	}

	/**
	 * Removes the lca posting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lca posting
	 * @return the lca posting that was removed
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	@Override
	public LcaPosting remove(Serializable primaryKey)
		throws NoSuchLcaPostingException {

		Session session = null;

		try {
			session = openSession();

			LcaPosting lcaPosting = (LcaPosting)session.get(
				LcaPostingImpl.class, primaryKey);

			if (lcaPosting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLcaPostingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lcaPosting);
		}
		catch (NoSuchLcaPostingException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LcaPosting removeImpl(LcaPosting lcaPosting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lcaPosting)) {
				lcaPosting = (LcaPosting)session.get(
					LcaPostingImpl.class, lcaPosting.getPrimaryKeyObj());
			}

			if (lcaPosting != null) {
				session.delete(lcaPosting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lcaPosting != null) {
			clearCache(lcaPosting);
		}

		return lcaPosting;
	}

	@Override
	public LcaPosting updateImpl(LcaPosting lcaPosting) {
		boolean isNew = lcaPosting.isNew();

		if (!(lcaPosting instanceof LcaPostingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lcaPosting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lcaPosting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lcaPosting proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LcaPosting implementation " +
					lcaPosting.getClass());
		}

		LcaPostingModelImpl lcaPostingModelImpl =
			(LcaPostingModelImpl)lcaPosting;

		if (Validator.isNull(lcaPosting.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			lcaPosting.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (lcaPosting.getCreateDate() == null)) {
			if (serviceContext == null) {
				lcaPosting.setCreateDate(date);
			}
			else {
				lcaPosting.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!lcaPostingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lcaPosting.setModifiedDate(date);
			}
			else {
				lcaPosting.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lcaPosting);
			}
			else {
				lcaPosting = (LcaPosting)session.merge(lcaPosting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LcaPostingImpl.class, lcaPostingModelImpl, false, true);

		cacheUniqueFindersCache(lcaPostingModelImpl);

		if (isNew) {
			lcaPosting.setNew(false);
		}

		lcaPosting.resetOriginalValues();

		return lcaPosting;
	}

	/**
	 * Returns the lca posting with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lca posting
	 * @return the lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	@Override
	public LcaPosting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLcaPostingException {

		LcaPosting lcaPosting = fetchByPrimaryKey(primaryKey);

		if (lcaPosting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLcaPostingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lcaPosting;
	}

	/**
	 * Returns the lca posting with the primary key or throws a <code>NoSuchLcaPostingException</code> if it could not be found.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting
	 * @throws NoSuchLcaPostingException if a lca posting with the primary key could not be found
	 */
	@Override
	public LcaPosting findByPrimaryKey(long lcaPostingId)
		throws NoSuchLcaPostingException {

		return findByPrimaryKey((Serializable)lcaPostingId);
	}

	/**
	 * Returns the lca posting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lcaPostingId the primary key of the lca posting
	 * @return the lca posting, or <code>null</code> if a lca posting with the primary key could not be found
	 */
	@Override
	public LcaPosting fetchByPrimaryKey(long lcaPostingId) {
		return fetchByPrimaryKey((Serializable)lcaPostingId);
	}

	/**
	 * Returns all the lca postings.
	 *
	 * @return the lca postings
	 */
	@Override
	public List<LcaPosting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LcaPosting> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LcaPosting> findAll(
		int start, int end, OrderByComparator<LcaPosting> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LcaPosting> findAll(
		int start, int end, OrderByComparator<LcaPosting> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<LcaPosting> list = null;

		if (useFinderCache) {
			list = (List<LcaPosting>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LCAPOSTING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LCAPOSTING;

				sql = sql.concat(LcaPostingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LcaPosting>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the lca postings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LcaPosting lcaPosting : findAll()) {
			remove(lcaPosting);
		}
	}

	/**
	 * Returns the number of lca postings.
	 *
	 * @return the number of lca postings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LCAPOSTING);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "lcaPostingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LCAPOSTING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LcaPostingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lca posting persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBydesignation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydesignation",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designation"}, true);

		_finderPathWithoutPaginationFindBydesignation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydesignation",
			new String[] {String.class.getName()}, new String[] {"designation"},
			true);

		_finderPathCountBydesignation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydesignation",
			new String[] {String.class.getName()}, new String[] {"designation"},
			false);

		_finderPathWithPaginationFindBydesignationAndLocation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydesignationAndLocation",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"designation", "location"}, true);

		_finderPathWithoutPaginationFindBydesignationAndLocation =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydesignationAndLocation",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"designation", "location"}, true);

		_finderPathCountBydesignationAndLocation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydesignationAndLocation",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"designation", "location"}, false);

		LcaPostingUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LcaPostingUtil.setPersistence(null);

		entityCache.removeCache(LcaPostingImpl.class.getName());
	}

	@Override
	@Reference(
		target = sysPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = sysPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = sysPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LCAPOSTING =
		"SELECT lcaPosting FROM LcaPosting lcaPosting";

	private static final String _SQL_SELECT_LCAPOSTING_WHERE =
		"SELECT lcaPosting FROM LcaPosting lcaPosting WHERE ";

	private static final String _SQL_COUNT_LCAPOSTING =
		"SELECT COUNT(lcaPosting) FROM LcaPosting lcaPosting";

	private static final String _SQL_COUNT_LCAPOSTING_WHERE =
		"SELECT COUNT(lcaPosting) FROM LcaPosting lcaPosting WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lcaPosting.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LcaPosting exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LcaPosting exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LcaPostingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}