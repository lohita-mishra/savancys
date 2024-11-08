/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.savancys.model.JobPost;
import com.savancys.model.JobPostModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the JobPost service. Represents a row in the &quot;JobPost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>JobPostModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobPostImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobPostImpl
 * @generated
 */
@JSON(strict = true)
public class JobPostModelImpl
	extends BaseModelImpl<JobPost> implements JobPostModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a job post model instance should use the <code>JobPost</code> interface instead.
	 */
	public static final String TABLE_NAME = "JobPost";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"jobPostId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"active_", Types.BOOLEAN}, {"delete_", Types.BOOLEAN},
		{"jobPostName", Types.VARCHAR}, {"experience", Types.VARCHAR},
		{"qualification", Types.VARCHAR}, {"location", Types.VARCHAR},
		{"skills", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"salary", Types.VARCHAR}, {"status", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jobPostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("delete_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("jobPostName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("experience", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("qualification", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("location", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("skills", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("salary", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JobPost (uuid_ VARCHAR(75) null,jobPostId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,active_ BOOLEAN,delete_ BOOLEAN,jobPostName VARCHAR(75) null,experience VARCHAR(75) null,qualification VARCHAR(75) null,location VARCHAR(75) null,skills VARCHAR(75) null,description STRING null,salary VARCHAR(75) null,status BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table JobPost";

	public static final String ORDER_BY_JPQL =
		" ORDER BY jobPost.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JobPost.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long JOBPOSTNAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public JobPostModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jobPostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJobPostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobPostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JobPost.class;
	}

	@Override
	public String getModelClassName() {
		return JobPost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<JobPost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<JobPost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JobPost, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((JobPost)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<JobPost, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<JobPost, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(JobPost)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<JobPost, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<JobPost, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<JobPost, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<JobPost, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<JobPost, Object>>();

			attributeGetterFunctions.put("uuid", JobPost::getUuid);
			attributeGetterFunctions.put("jobPostId", JobPost::getJobPostId);
			attributeGetterFunctions.put("groupId", JobPost::getGroupId);
			attributeGetterFunctions.put("companyId", JobPost::getCompanyId);
			attributeGetterFunctions.put("userId", JobPost::getUserId);
			attributeGetterFunctions.put("userName", JobPost::getUserName);
			attributeGetterFunctions.put("createDate", JobPost::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", JobPost::getModifiedDate);
			attributeGetterFunctions.put("active", JobPost::getActive);
			attributeGetterFunctions.put("delete", JobPost::getDelete);
			attributeGetterFunctions.put(
				"jobPostName", JobPost::getJobPostName);
			attributeGetterFunctions.put("experience", JobPost::getExperience);
			attributeGetterFunctions.put(
				"qualification", JobPost::getQualification);
			attributeGetterFunctions.put("location", JobPost::getLocation);
			attributeGetterFunctions.put("skills", JobPost::getSkills);
			attributeGetterFunctions.put(
				"description", JobPost::getDescription);
			attributeGetterFunctions.put("salary", JobPost::getSalary);
			attributeGetterFunctions.put("status", JobPost::getStatus);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<JobPost, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<JobPost, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<JobPost, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<JobPost, String>)JobPost::setUuid);
			attributeSetterBiConsumers.put(
				"jobPostId", (BiConsumer<JobPost, Long>)JobPost::setJobPostId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<JobPost, Long>)JobPost::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId", (BiConsumer<JobPost, Long>)JobPost::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<JobPost, Long>)JobPost::setUserId);
			attributeSetterBiConsumers.put(
				"userName", (BiConsumer<JobPost, String>)JobPost::setUserName);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<JobPost, Date>)JobPost::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<JobPost, Date>)JobPost::setModifiedDate);
			attributeSetterBiConsumers.put(
				"active", (BiConsumer<JobPost, Boolean>)JobPost::setActive);
			attributeSetterBiConsumers.put(
				"delete", (BiConsumer<JobPost, Boolean>)JobPost::setDelete);
			attributeSetterBiConsumers.put(
				"jobPostName",
				(BiConsumer<JobPost, String>)JobPost::setJobPostName);
			attributeSetterBiConsumers.put(
				"experience",
				(BiConsumer<JobPost, String>)JobPost::setExperience);
			attributeSetterBiConsumers.put(
				"qualification",
				(BiConsumer<JobPost, String>)JobPost::setQualification);
			attributeSetterBiConsumers.put(
				"location", (BiConsumer<JobPost, String>)JobPost::setLocation);
			attributeSetterBiConsumers.put(
				"skills", (BiConsumer<JobPost, String>)JobPost::setSkills);
			attributeSetterBiConsumers.put(
				"description",
				(BiConsumer<JobPost, String>)JobPost::setDescription);
			attributeSetterBiConsumers.put(
				"salary", (BiConsumer<JobPost, String>)JobPost::setSalary);
			attributeSetterBiConsumers.put(
				"status", (BiConsumer<JobPost, Boolean>)JobPost::setStatus);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getJobPostId() {
		return _jobPostId;
	}

	@Override
	public void setJobPostId(long jobPostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jobPostId = jobPostId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_active = active;
	}

	@JSON
	@Override
	public boolean getDelete() {
		return _delete;
	}

	@JSON
	@Override
	public boolean isDelete() {
		return _delete;
	}

	@Override
	public void setDelete(boolean delete) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delete = delete;
	}

	@JSON
	@Override
	public String getJobPostName() {
		if (_jobPostName == null) {
			return "";
		}
		else {
			return _jobPostName;
		}
	}

	@Override
	public void setJobPostName(String jobPostName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jobPostName = jobPostName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalJobPostName() {
		return getColumnOriginalValue("jobPostName");
	}

	@JSON
	@Override
	public String getExperience() {
		if (_experience == null) {
			return "";
		}
		else {
			return _experience;
		}
	}

	@Override
	public void setExperience(String experience) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_experience = experience;
	}

	@JSON
	@Override
	public String getQualification() {
		if (_qualification == null) {
			return "";
		}
		else {
			return _qualification;
		}
	}

	@Override
	public void setQualification(String qualification) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_qualification = qualification;
	}

	@JSON
	@Override
	public String getLocation() {
		if (_location == null) {
			return "";
		}
		else {
			return _location;
		}
	}

	@Override
	public void setLocation(String location) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_location = location;
	}

	@JSON
	@Override
	public String getSkills() {
		if (_skills == null) {
			return "";
		}
		else {
			return _skills;
		}
	}

	@Override
	public void setSkills(String skills) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_skills = skills;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getSalary() {
		if (_salary == null) {
			return "";
		}
		else {
			return _salary;
		}
	}

	@Override
	public void setSalary(String salary) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_salary = salary;
	}

	@JSON
	@Override
	public boolean getStatus() {
		return _status;
	}

	@JSON
	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(JobPost.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), JobPost.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JobPost toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, JobPost>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JobPostImpl jobPostImpl = new JobPostImpl();

		jobPostImpl.setUuid(getUuid());
		jobPostImpl.setJobPostId(getJobPostId());
		jobPostImpl.setGroupId(getGroupId());
		jobPostImpl.setCompanyId(getCompanyId());
		jobPostImpl.setUserId(getUserId());
		jobPostImpl.setUserName(getUserName());
		jobPostImpl.setCreateDate(getCreateDate());
		jobPostImpl.setModifiedDate(getModifiedDate());
		jobPostImpl.setActive(isActive());
		jobPostImpl.setDelete(isDelete());
		jobPostImpl.setJobPostName(getJobPostName());
		jobPostImpl.setExperience(getExperience());
		jobPostImpl.setQualification(getQualification());
		jobPostImpl.setLocation(getLocation());
		jobPostImpl.setSkills(getSkills());
		jobPostImpl.setDescription(getDescription());
		jobPostImpl.setSalary(getSalary());
		jobPostImpl.setStatus(isStatus());

		jobPostImpl.resetOriginalValues();

		return jobPostImpl;
	}

	@Override
	public JobPost cloneWithOriginalValues() {
		JobPostImpl jobPostImpl = new JobPostImpl();

		jobPostImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		jobPostImpl.setJobPostId(
			this.<Long>getColumnOriginalValue("jobPostId"));
		jobPostImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		jobPostImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		jobPostImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		jobPostImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		jobPostImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		jobPostImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		jobPostImpl.setActive(this.<Boolean>getColumnOriginalValue("active_"));
		jobPostImpl.setDelete(this.<Boolean>getColumnOriginalValue("delete_"));
		jobPostImpl.setJobPostName(
			this.<String>getColumnOriginalValue("jobPostName"));
		jobPostImpl.setExperience(
			this.<String>getColumnOriginalValue("experience"));
		jobPostImpl.setQualification(
			this.<String>getColumnOriginalValue("qualification"));
		jobPostImpl.setLocation(
			this.<String>getColumnOriginalValue("location"));
		jobPostImpl.setSkills(this.<String>getColumnOriginalValue("skills"));
		jobPostImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		jobPostImpl.setSalary(this.<String>getColumnOriginalValue("salary"));
		jobPostImpl.setStatus(this.<Boolean>getColumnOriginalValue("status"));

		return jobPostImpl;
	}

	@Override
	public int compareTo(JobPost jobPost) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), jobPost.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobPost)) {
			return false;
		}

		JobPost jobPost = (JobPost)object;

		long primaryKey = jobPost.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<JobPost> toCacheModel() {
		JobPostCacheModel jobPostCacheModel = new JobPostCacheModel();

		jobPostCacheModel.uuid = getUuid();

		String uuid = jobPostCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			jobPostCacheModel.uuid = null;
		}

		jobPostCacheModel.jobPostId = getJobPostId();

		jobPostCacheModel.groupId = getGroupId();

		jobPostCacheModel.companyId = getCompanyId();

		jobPostCacheModel.userId = getUserId();

		jobPostCacheModel.userName = getUserName();

		String userName = jobPostCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			jobPostCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			jobPostCacheModel.createDate = createDate.getTime();
		}
		else {
			jobPostCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jobPostCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jobPostCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jobPostCacheModel.active = isActive();

		jobPostCacheModel.delete = isDelete();

		jobPostCacheModel.jobPostName = getJobPostName();

		String jobPostName = jobPostCacheModel.jobPostName;

		if ((jobPostName != null) && (jobPostName.length() == 0)) {
			jobPostCacheModel.jobPostName = null;
		}

		jobPostCacheModel.experience = getExperience();

		String experience = jobPostCacheModel.experience;

		if ((experience != null) && (experience.length() == 0)) {
			jobPostCacheModel.experience = null;
		}

		jobPostCacheModel.qualification = getQualification();

		String qualification = jobPostCacheModel.qualification;

		if ((qualification != null) && (qualification.length() == 0)) {
			jobPostCacheModel.qualification = null;
		}

		jobPostCacheModel.location = getLocation();

		String location = jobPostCacheModel.location;

		if ((location != null) && (location.length() == 0)) {
			jobPostCacheModel.location = null;
		}

		jobPostCacheModel.skills = getSkills();

		String skills = jobPostCacheModel.skills;

		if ((skills != null) && (skills.length() == 0)) {
			jobPostCacheModel.skills = null;
		}

		jobPostCacheModel.description = getDescription();

		String description = jobPostCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			jobPostCacheModel.description = null;
		}

		jobPostCacheModel.salary = getSalary();

		String salary = jobPostCacheModel.salary;

		if ((salary != null) && (salary.length() == 0)) {
			jobPostCacheModel.salary = null;
		}

		jobPostCacheModel.status = isStatus();

		return jobPostCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<JobPost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<JobPost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JobPost, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((JobPost)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, JobPost>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					JobPost.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _jobPostId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _active;
	private boolean _delete;
	private String _jobPostName;
	private String _experience;
	private String _qualification;
	private String _location;
	private String _skills;
	private String _description;
	private String _salary;
	private boolean _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<JobPost, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((JobPost)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("jobPostId", _jobPostId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("delete_", _delete);
		_columnOriginalValues.put("jobPostName", _jobPostName);
		_columnOriginalValues.put("experience", _experience);
		_columnOriginalValues.put("qualification", _qualification);
		_columnOriginalValues.put("location", _location);
		_columnOriginalValues.put("skills", _skills);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("salary", _salary);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("active_", "active");
		attributeNames.put("delete_", "delete");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("jobPostId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("active_", 256L);

		columnBitmasks.put("delete_", 512L);

		columnBitmasks.put("jobPostName", 1024L);

		columnBitmasks.put("experience", 2048L);

		columnBitmasks.put("qualification", 4096L);

		columnBitmasks.put("location", 8192L);

		columnBitmasks.put("skills", 16384L);

		columnBitmasks.put("description", 32768L);

		columnBitmasks.put("salary", 65536L);

		columnBitmasks.put("status", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private JobPost _escapedModel;

}