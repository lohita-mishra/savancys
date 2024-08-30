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

import com.savancys.exception.NoSuchJobPostException;
import com.savancys.model.JobPost;
import com.savancys.model.JobPostTable;
import com.savancys.model.impl.JobPostImpl;
import com.savancys.model.impl.JobPostModelImpl;
import com.savancys.service.persistence.JobPostPersistence;
import com.savancys.service.persistence.JobPostUtil;
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
 * The persistence implementation for the job post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = JobPostPersistence.class)
public class JobPostPersistenceImpl
	extends BasePersistenceImpl<JobPost> implements JobPostPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobPostUtil</code> to access the job post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobPostImpl.class.getName();

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
	 * Returns all the job posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job posts
	 */
	@Override
	public List<JobPost> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of matching job posts
	 */
	@Override
	public List<JobPost> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job posts
	 */
	@Override
	public List<JobPost> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job posts
	 */
	@Override
	public List<JobPost> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean useFinderCache) {

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

		List<JobPost> list = null;

		if (useFinderCache) {
			list = (List<JobPost>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JobPost jobPost : list) {
					if (!uuid.equals(jobPost.getUuid())) {
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

			sb.append(_SQL_SELECT_JOBPOST_WHERE);

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
				sb.append(JobPostModelImpl.ORDER_BY_JPQL);
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

				list = (List<JobPost>)QueryUtil.list(
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
	 * Returns the first job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByUuid_First(
			String uuid, OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByUuid_First(uuid, orderByComparator);

		if (jobPost != null) {
			return jobPost;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJobPostException(sb.toString());
	}

	/**
	 * Returns the first job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByUuid_First(
		String uuid, OrderByComparator<JobPost> orderByComparator) {

		List<JobPost> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByUuid_Last(
			String uuid, OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByUuid_Last(uuid, orderByComparator);

		if (jobPost != null) {
			return jobPost;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJobPostException(sb.toString());
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByUuid_Last(
		String uuid, OrderByComparator<JobPost> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<JobPost> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job posts before and after the current job post in the ordered set where uuid = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost[] findByUuid_PrevAndNext(
			long jobPostId, String uuid,
			OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		uuid = Objects.toString(uuid, "");

		JobPost jobPost = findByPrimaryKey(jobPostId);

		Session session = null;

		try {
			session = openSession();

			JobPost[] array = new JobPostImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, jobPost, uuid, orderByComparator, true);

			array[1] = jobPost;

			array[2] = getByUuid_PrevAndNext(
				session, jobPost, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPost getByUuid_PrevAndNext(
		Session session, JobPost jobPost, String uuid,
		OrderByComparator<JobPost> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOBPOST_WHERE);

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
			sb.append(JobPostModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(jobPost)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JobPost> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job posts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (JobPost jobPost :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(jobPost);
		}
	}

	/**
	 * Returns the number of job posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job posts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOBPOST_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "jobPost.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(jobPost.uuid IS NULL OR jobPost.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobPostException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByUUID_G(String uuid, long groupId)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByUUID_G(uuid, groupId);

		if (jobPost == null) {
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

			throw new NoSuchJobPostException(sb.toString());
		}

		return jobPost;
	}

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the job post where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByUUID_G(
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

		if (result instanceof JobPost) {
			JobPost jobPost = (JobPost)result;

			if (!Objects.equals(uuid, jobPost.getUuid()) ||
				(groupId != jobPost.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_JOBPOST_WHERE);

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

				List<JobPost> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					JobPost jobPost = list.get(0);

					result = jobPost;

					cacheResult(jobPost);
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
			return (JobPost)result;
		}
	}

	/**
	 * Removes the job post where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the job post that was removed
	 */
	@Override
	public JobPost removeByUUID_G(String uuid, long groupId)
		throws NoSuchJobPostException {

		JobPost jobPost = findByUUID_G(uuid, groupId);

		return remove(jobPost);
	}

	/**
	 * Returns the number of job posts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching job posts
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_JOBPOST_WHERE);

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
		"jobPost.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(jobPost.uuid IS NULL OR jobPost.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"jobPost.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching job posts
	 */
	@Override
	public List<JobPost> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of matching job posts
	 */
	@Override
	public List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job posts
	 */
	@Override
	public List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job posts
	 */
	@Override
	public List<JobPost> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean useFinderCache) {

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

		List<JobPost> list = null;

		if (useFinderCache) {
			list = (List<JobPost>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JobPost jobPost : list) {
					if (!uuid.equals(jobPost.getUuid()) ||
						(companyId != jobPost.getCompanyId())) {

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

			sb.append(_SQL_SELECT_JOBPOST_WHERE);

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
				sb.append(JobPostModelImpl.ORDER_BY_JPQL);
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

				list = (List<JobPost>)QueryUtil.list(
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
	 * Returns the first job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (jobPost != null) {
			return jobPost;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchJobPostException(sb.toString());
	}

	/**
	 * Returns the first job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<JobPost> orderByComparator) {

		List<JobPost> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (jobPost != null) {
			return jobPost;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchJobPostException(sb.toString());
	}

	/**
	 * Returns the last job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<JobPost> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<JobPost> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job posts before and after the current job post in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost[] findByUuid_C_PrevAndNext(
			long jobPostId, String uuid, long companyId,
			OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		uuid = Objects.toString(uuid, "");

		JobPost jobPost = findByPrimaryKey(jobPostId);

		Session session = null;

		try {
			session = openSession();

			JobPost[] array = new JobPostImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, jobPost, uuid, companyId, orderByComparator, true);

			array[1] = jobPost;

			array[2] = getByUuid_C_PrevAndNext(
				session, jobPost, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPost getByUuid_C_PrevAndNext(
		Session session, JobPost jobPost, String uuid, long companyId,
		OrderByComparator<JobPost> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_JOBPOST_WHERE);

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
			sb.append(JobPostModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(jobPost)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JobPost> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job posts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (JobPost jobPost :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(jobPost);
		}
	}

	/**
	 * Returns the number of job posts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching job posts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_JOBPOST_WHERE);

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
		"jobPost.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(jobPost.uuid IS NULL OR jobPost.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"jobPost.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByjobPostName;
	private FinderPath _finderPathWithoutPaginationFindByjobPostName;
	private FinderPath _finderPathCountByjobPostName;

	/**
	 * Returns all the job posts where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @return the matching job posts
	 */
	@Override
	public List<JobPost> findByjobPostName(String jobPostName) {
		return findByjobPostName(
			jobPostName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job posts where jobPostName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param jobPostName the job post name
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of matching job posts
	 */
	@Override
	public List<JobPost> findByjobPostName(
		String jobPostName, int start, int end) {

		return findByjobPostName(jobPostName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job posts where jobPostName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param jobPostName the job post name
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job posts
	 */
	@Override
	public List<JobPost> findByjobPostName(
		String jobPostName, int start, int end,
		OrderByComparator<JobPost> orderByComparator) {

		return findByjobPostName(
			jobPostName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job posts where jobPostName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param jobPostName the job post name
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job posts
	 */
	@Override
	public List<JobPost> findByjobPostName(
		String jobPostName, int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean useFinderCache) {

		jobPostName = Objects.toString(jobPostName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByjobPostName;
				finderArgs = new Object[] {jobPostName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByjobPostName;
			finderArgs = new Object[] {
				jobPostName, start, end, orderByComparator
			};
		}

		List<JobPost> list = null;

		if (useFinderCache) {
			list = (List<JobPost>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JobPost jobPost : list) {
					if (!jobPostName.equals(jobPost.getJobPostName())) {
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

			sb.append(_SQL_SELECT_JOBPOST_WHERE);

			boolean bindJobPostName = false;

			if (jobPostName.isEmpty()) {
				sb.append(_FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_3);
			}
			else {
				bindJobPostName = true;

				sb.append(_FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(JobPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindJobPostName) {
					queryPos.add(jobPostName);
				}

				list = (List<JobPost>)QueryUtil.list(
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
	 * Returns the first job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByjobPostName_First(
			String jobPostName, OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByjobPostName_First(
			jobPostName, orderByComparator);

		if (jobPost != null) {
			return jobPost;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("jobPostName=");
		sb.append(jobPostName);

		sb.append("}");

		throw new NoSuchJobPostException(sb.toString());
	}

	/**
	 * Returns the first job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByjobPostName_First(
		String jobPostName, OrderByComparator<JobPost> orderByComparator) {

		List<JobPost> list = findByjobPostName(
			jobPostName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post
	 * @throws NoSuchJobPostException if a matching job post could not be found
	 */
	@Override
	public JobPost findByjobPostName_Last(
			String jobPostName, OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByjobPostName_Last(
			jobPostName, orderByComparator);

		if (jobPost != null) {
			return jobPost;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("jobPostName=");
		sb.append(jobPostName);

		sb.append("}");

		throw new NoSuchJobPostException(sb.toString());
	}

	/**
	 * Returns the last job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job post, or <code>null</code> if a matching job post could not be found
	 */
	@Override
	public JobPost fetchByjobPostName_Last(
		String jobPostName, OrderByComparator<JobPost> orderByComparator) {

		int count = countByjobPostName(jobPostName);

		if (count == 0) {
			return null;
		}

		List<JobPost> list = findByjobPostName(
			jobPostName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job posts before and after the current job post in the ordered set where jobPostName = &#63;.
	 *
	 * @param jobPostId the primary key of the current job post
	 * @param jobPostName the job post name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost[] findByjobPostName_PrevAndNext(
			long jobPostId, String jobPostName,
			OrderByComparator<JobPost> orderByComparator)
		throws NoSuchJobPostException {

		jobPostName = Objects.toString(jobPostName, "");

		JobPost jobPost = findByPrimaryKey(jobPostId);

		Session session = null;

		try {
			session = openSession();

			JobPost[] array = new JobPostImpl[3];

			array[0] = getByjobPostName_PrevAndNext(
				session, jobPost, jobPostName, orderByComparator, true);

			array[1] = jobPost;

			array[2] = getByjobPostName_PrevAndNext(
				session, jobPost, jobPostName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPost getByjobPostName_PrevAndNext(
		Session session, JobPost jobPost, String jobPostName,
		OrderByComparator<JobPost> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOBPOST_WHERE);

		boolean bindJobPostName = false;

		if (jobPostName.isEmpty()) {
			sb.append(_FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_3);
		}
		else {
			bindJobPostName = true;

			sb.append(_FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_2);
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
			sb.append(JobPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindJobPostName) {
			queryPos.add(jobPostName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(jobPost)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JobPost> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job posts where jobPostName = &#63; from the database.
	 *
	 * @param jobPostName the job post name
	 */
	@Override
	public void removeByjobPostName(String jobPostName) {
		for (JobPost jobPost :
				findByjobPostName(
					jobPostName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(jobPost);
		}
	}

	/**
	 * Returns the number of job posts where jobPostName = &#63;.
	 *
	 * @param jobPostName the job post name
	 * @return the number of matching job posts
	 */
	@Override
	public int countByjobPostName(String jobPostName) {
		jobPostName = Objects.toString(jobPostName, "");

		FinderPath finderPath = _finderPathCountByjobPostName;

		Object[] finderArgs = new Object[] {jobPostName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOBPOST_WHERE);

			boolean bindJobPostName = false;

			if (jobPostName.isEmpty()) {
				sb.append(_FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_3);
			}
			else {
				bindJobPostName = true;

				sb.append(_FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindJobPostName) {
					queryPos.add(jobPostName);
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

	private static final String _FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_2 =
		"jobPost.jobPostName = ?";

	private static final String _FINDER_COLUMN_JOBPOSTNAME_JOBPOSTNAME_3 =
		"(jobPost.jobPostName IS NULL OR jobPost.jobPostName = '')";

	public JobPostPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");
		dbColumnNames.put("delete", "delete_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JobPost.class);

		setModelImplClass(JobPostImpl.class);
		setModelPKClass(long.class);

		setTable(JobPostTable.INSTANCE);
	}

	/**
	 * Caches the job post in the entity cache if it is enabled.
	 *
	 * @param jobPost the job post
	 */
	@Override
	public void cacheResult(JobPost jobPost) {
		entityCache.putResult(
			JobPostImpl.class, jobPost.getPrimaryKey(), jobPost);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {jobPost.getUuid(), jobPost.getGroupId()}, jobPost);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the job posts in the entity cache if it is enabled.
	 *
	 * @param jobPosts the job posts
	 */
	@Override
	public void cacheResult(List<JobPost> jobPosts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (jobPosts.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (JobPost jobPost : jobPosts) {
			if (entityCache.getResult(
					JobPostImpl.class, jobPost.getPrimaryKey()) == null) {

				cacheResult(jobPost);
			}
		}
	}

	/**
	 * Clears the cache for all job posts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobPostImpl.class);

		finderCache.clearCache(JobPostImpl.class);
	}

	/**
	 * Clears the cache for the job post.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobPost jobPost) {
		entityCache.removeResult(JobPostImpl.class, jobPost);
	}

	@Override
	public void clearCache(List<JobPost> jobPosts) {
		for (JobPost jobPost : jobPosts) {
			entityCache.removeResult(JobPostImpl.class, jobPost);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(JobPostImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JobPostImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(JobPostModelImpl jobPostModelImpl) {
		Object[] args = new Object[] {
			jobPostModelImpl.getUuid(), jobPostModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, jobPostModelImpl);
	}

	/**
	 * Creates a new job post with the primary key. Does not add the job post to the database.
	 *
	 * @param jobPostId the primary key for the new job post
	 * @return the new job post
	 */
	@Override
	public JobPost create(long jobPostId) {
		JobPost jobPost = new JobPostImpl();

		jobPost.setNew(true);
		jobPost.setPrimaryKey(jobPostId);

		String uuid = PortalUUIDUtil.generate();

		jobPost.setUuid(uuid);

		jobPost.setCompanyId(CompanyThreadLocal.getCompanyId());

		return jobPost;
	}

	/**
	 * Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post that was removed
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost remove(long jobPostId) throws NoSuchJobPostException {
		return remove((Serializable)jobPostId);
	}

	/**
	 * Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job post
	 * @return the job post that was removed
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost remove(Serializable primaryKey)
		throws NoSuchJobPostException {

		Session session = null;

		try {
			session = openSession();

			JobPost jobPost = (JobPost)session.get(
				JobPostImpl.class, primaryKey);

			if (jobPost == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobPostException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(jobPost);
		}
		catch (NoSuchJobPostException noSuchEntityException) {
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
	protected JobPost removeImpl(JobPost jobPost) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobPost)) {
				jobPost = (JobPost)session.get(
					JobPostImpl.class, jobPost.getPrimaryKeyObj());
			}

			if (jobPost != null) {
				session.delete(jobPost);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (jobPost != null) {
			clearCache(jobPost);
		}

		return jobPost;
	}

	@Override
	public JobPost updateImpl(JobPost jobPost) {
		boolean isNew = jobPost.isNew();

		if (!(jobPost instanceof JobPostModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(jobPost.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(jobPost);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in jobPost proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JobPost implementation " +
					jobPost.getClass());
		}

		JobPostModelImpl jobPostModelImpl = (JobPostModelImpl)jobPost;

		if (Validator.isNull(jobPost.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			jobPost.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (jobPost.getCreateDate() == null)) {
			if (serviceContext == null) {
				jobPost.setCreateDate(date);
			}
			else {
				jobPost.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!jobPostModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				jobPost.setModifiedDate(date);
			}
			else {
				jobPost.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(jobPost);
			}
			else {
				jobPost = (JobPost)session.merge(jobPost);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(JobPostImpl.class, jobPostModelImpl, false, true);

		cacheUniqueFindersCache(jobPostModelImpl);

		if (isNew) {
			jobPost.setNew(false);
		}

		jobPost.resetOriginalValues();

		return jobPost;
	}

	/**
	 * Returns the job post with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job post
	 * @return the job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobPostException {

		JobPost jobPost = fetchByPrimaryKey(primaryKey);

		if (jobPost == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobPostException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return jobPost;
	}

	/**
	 * Returns the job post with the primary key or throws a <code>NoSuchJobPostException</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost findByPrimaryKey(long jobPostId)
		throws NoSuchJobPostException {

		return findByPrimaryKey((Serializable)jobPostId);
	}

	/**
	 * Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post, or <code>null</code> if a job post with the primary key could not be found
	 */
	@Override
	public JobPost fetchByPrimaryKey(long jobPostId) {
		return fetchByPrimaryKey((Serializable)jobPostId);
	}

	/**
	 * Returns all the job posts.
	 *
	 * @return the job posts
	 */
	@Override
	public List<JobPost> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of job posts
	 */
	@Override
	public List<JobPost> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job posts
	 */
	@Override
	public List<JobPost> findAll(
		int start, int end, OrderByComparator<JobPost> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job posts
	 */
	@Override
	public List<JobPost> findAll(
		int start, int end, OrderByComparator<JobPost> orderByComparator,
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

		List<JobPost> list = null;

		if (useFinderCache) {
			list = (List<JobPost>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOBPOST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOBPOST;

				sql = sql.concat(JobPostModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JobPost>)QueryUtil.list(
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
	 * Removes all the job posts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobPost jobPost : findAll()) {
			remove(jobPost);
		}
	}

	/**
	 * Returns the number of job posts.
	 *
	 * @return the number of job posts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOBPOST);

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
		return "jobPostId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOBPOST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobPostModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job post persistence.
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

		_finderPathWithPaginationFindByjobPostName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByjobPostName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"jobPostName"}, true);

		_finderPathWithoutPaginationFindByjobPostName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByjobPostName",
			new String[] {String.class.getName()}, new String[] {"jobPostName"},
			true);

		_finderPathCountByjobPostName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByjobPostName",
			new String[] {String.class.getName()}, new String[] {"jobPostName"},
			false);

		JobPostUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		JobPostUtil.setPersistence(null);

		entityCache.removeCache(JobPostImpl.class.getName());
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

	private static final String _SQL_SELECT_JOBPOST =
		"SELECT jobPost FROM JobPost jobPost";

	private static final String _SQL_SELECT_JOBPOST_WHERE =
		"SELECT jobPost FROM JobPost jobPost WHERE ";

	private static final String _SQL_COUNT_JOBPOST =
		"SELECT COUNT(jobPost) FROM JobPost jobPost";

	private static final String _SQL_COUNT_JOBPOST_WHERE =
		"SELECT COUNT(jobPost) FROM JobPost jobPost WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "jobPost.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JobPost exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No JobPost exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JobPostPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active", "delete"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}