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

import com.savancys.exception.NoSuchJobApplicantException;
import com.savancys.model.JobApplicant;
import com.savancys.model.JobApplicantTable;
import com.savancys.model.impl.JobApplicantImpl;
import com.savancys.model.impl.JobApplicantModelImpl;
import com.savancys.service.persistence.JobApplicantPersistence;
import com.savancys.service.persistence.JobApplicantUtil;
import com.savancys.service.persistence.impl.constants.sysPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the job applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = JobApplicantPersistence.class)
public class JobApplicantPersistenceImpl
	extends BasePersistenceImpl<JobApplicant>
	implements JobApplicantPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobApplicantUtil</code> to access the job applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobApplicantImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public JobApplicantPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JobApplicant.class);

		setModelImplClass(JobApplicantImpl.class);
		setModelPKClass(long.class);

		setTable(JobApplicantTable.INSTANCE);
	}

	/**
	 * Caches the job applicant in the entity cache if it is enabled.
	 *
	 * @param jobApplicant the job applicant
	 */
	@Override
	public void cacheResult(JobApplicant jobApplicant) {
		entityCache.putResult(
			JobApplicantImpl.class, jobApplicant.getPrimaryKey(), jobApplicant);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the job applicants in the entity cache if it is enabled.
	 *
	 * @param jobApplicants the job applicants
	 */
	@Override
	public void cacheResult(List<JobApplicant> jobApplicants) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (jobApplicants.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (JobApplicant jobApplicant : jobApplicants) {
			if (entityCache.getResult(
					JobApplicantImpl.class, jobApplicant.getPrimaryKey()) ==
						null) {

				cacheResult(jobApplicant);
			}
		}
	}

	/**
	 * Clears the cache for all job applicants.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobApplicantImpl.class);

		finderCache.clearCache(JobApplicantImpl.class);
	}

	/**
	 * Clears the cache for the job applicant.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobApplicant jobApplicant) {
		entityCache.removeResult(JobApplicantImpl.class, jobApplicant);
	}

	@Override
	public void clearCache(List<JobApplicant> jobApplicants) {
		for (JobApplicant jobApplicant : jobApplicants) {
			entityCache.removeResult(JobApplicantImpl.class, jobApplicant);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(JobApplicantImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JobApplicantImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new job applicant with the primary key. Does not add the job applicant to the database.
	 *
	 * @param jobApplicantID the primary key for the new job applicant
	 * @return the new job applicant
	 */
	@Override
	public JobApplicant create(long jobApplicantID) {
		JobApplicant jobApplicant = new JobApplicantImpl();

		jobApplicant.setNew(true);
		jobApplicant.setPrimaryKey(jobApplicantID);

		jobApplicant.setCompanyId(CompanyThreadLocal.getCompanyId());

		return jobApplicant;
	}

	/**
	 * Removes the job applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant that was removed
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	@Override
	public JobApplicant remove(long jobApplicantID)
		throws NoSuchJobApplicantException {

		return remove((Serializable)jobApplicantID);
	}

	/**
	 * Removes the job applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job applicant
	 * @return the job applicant that was removed
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	@Override
	public JobApplicant remove(Serializable primaryKey)
		throws NoSuchJobApplicantException {

		Session session = null;

		try {
			session = openSession();

			JobApplicant jobApplicant = (JobApplicant)session.get(
				JobApplicantImpl.class, primaryKey);

			if (jobApplicant == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobApplicantException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(jobApplicant);
		}
		catch (NoSuchJobApplicantException noSuchEntityException) {
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
	protected JobApplicant removeImpl(JobApplicant jobApplicant) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobApplicant)) {
				jobApplicant = (JobApplicant)session.get(
					JobApplicantImpl.class, jobApplicant.getPrimaryKeyObj());
			}

			if (jobApplicant != null) {
				session.delete(jobApplicant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (jobApplicant != null) {
			clearCache(jobApplicant);
		}

		return jobApplicant;
	}

	@Override
	public JobApplicant updateImpl(JobApplicant jobApplicant) {
		boolean isNew = jobApplicant.isNew();

		if (!(jobApplicant instanceof JobApplicantModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(jobApplicant.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					jobApplicant);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in jobApplicant proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JobApplicant implementation " +
					jobApplicant.getClass());
		}

		JobApplicantModelImpl jobApplicantModelImpl =
			(JobApplicantModelImpl)jobApplicant;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (jobApplicant.getCreateDate() == null)) {
			if (serviceContext == null) {
				jobApplicant.setCreateDate(date);
			}
			else {
				jobApplicant.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!jobApplicantModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				jobApplicant.setModifiedDate(date);
			}
			else {
				jobApplicant.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(jobApplicant);
			}
			else {
				jobApplicant = (JobApplicant)session.merge(jobApplicant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			JobApplicantImpl.class, jobApplicant, false, true);

		if (isNew) {
			jobApplicant.setNew(false);
		}

		jobApplicant.resetOriginalValues();

		return jobApplicant;
	}

	/**
	 * Returns the job applicant with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job applicant
	 * @return the job applicant
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	@Override
	public JobApplicant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobApplicantException {

		JobApplicant jobApplicant = fetchByPrimaryKey(primaryKey);

		if (jobApplicant == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobApplicantException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return jobApplicant;
	}

	/**
	 * Returns the job applicant with the primary key or throws a <code>NoSuchJobApplicantException</code> if it could not be found.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant
	 * @throws NoSuchJobApplicantException if a job applicant with the primary key could not be found
	 */
	@Override
	public JobApplicant findByPrimaryKey(long jobApplicantID)
		throws NoSuchJobApplicantException {

		return findByPrimaryKey((Serializable)jobApplicantID);
	}

	/**
	 * Returns the job applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobApplicantID the primary key of the job applicant
	 * @return the job applicant, or <code>null</code> if a job applicant with the primary key could not be found
	 */
	@Override
	public JobApplicant fetchByPrimaryKey(long jobApplicantID) {
		return fetchByPrimaryKey((Serializable)jobApplicantID);
	}

	/**
	 * Returns all the job applicants.
	 *
	 * @return the job applicants
	 */
	@Override
	public List<JobApplicant> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @return the range of job applicants
	 */
	@Override
	public List<JobApplicant> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job applicants
	 */
	@Override
	public List<JobApplicant> findAll(
		int start, int end, OrderByComparator<JobApplicant> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobApplicantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job applicants
	 * @param end the upper bound of the range of job applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job applicants
	 */
	@Override
	public List<JobApplicant> findAll(
		int start, int end, OrderByComparator<JobApplicant> orderByComparator,
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

		List<JobApplicant> list = null;

		if (useFinderCache) {
			list = (List<JobApplicant>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOBAPPLICANT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOBAPPLICANT;

				sql = sql.concat(JobApplicantModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JobApplicant>)QueryUtil.list(
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
	 * Removes all the job applicants from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobApplicant jobApplicant : findAll()) {
			remove(jobApplicant);
		}
	}

	/**
	 * Returns the number of job applicants.
	 *
	 * @return the number of job applicants
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOBAPPLICANT);

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
		return "jobApplicantID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOBAPPLICANT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobApplicantModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job applicant persistence.
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

		JobApplicantUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		JobApplicantUtil.setPersistence(null);

		entityCache.removeCache(JobApplicantImpl.class.getName());
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

	private static final String _SQL_SELECT_JOBAPPLICANT =
		"SELECT jobApplicant FROM JobApplicant jobApplicant";

	private static final String _SQL_COUNT_JOBAPPLICANT =
		"SELECT COUNT(jobApplicant) FROM JobApplicant jobApplicant";

	private static final String _ORDER_BY_ENTITY_ALIAS = "jobApplicant.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JobApplicant exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		JobApplicantPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}