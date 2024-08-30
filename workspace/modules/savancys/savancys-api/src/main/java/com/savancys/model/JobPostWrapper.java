/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JobPost}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobPost
 * @generated
 */
public class JobPostWrapper
	extends BaseModelWrapper<JobPost>
	implements JobPost, ModelWrapper<JobPost> {

	public JobPostWrapper(JobPost jobPost) {
		super(jobPost);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jobPostId", getJobPostId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", isActive());
		attributes.put("delete", isDelete());
		attributes.put("jobPostName", getJobPostName());
		attributes.put("experience", getExperience());
		attributes.put("qualification", getQualification());
		attributes.put("location", getLocation());
		attributes.put("skills", getSkills());
		attributes.put("description", getDescription());
		attributes.put("salary", getSalary());
		attributes.put("status", isStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Boolean delete = (Boolean)attributes.get("delete");

		if (delete != null) {
			setDelete(delete);
		}

		String jobPostName = (String)attributes.get("jobPostName");

		if (jobPostName != null) {
			setJobPostName(jobPostName);
		}

		String experience = (String)attributes.get("experience");

		if (experience != null) {
			setExperience(experience);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String skills = (String)attributes.get("skills");

		if (skills != null) {
			setSkills(skills);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String salary = (String)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public JobPost cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this job post.
	 *
	 * @return the active of this job post
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this job post.
	 *
	 * @return the company ID of this job post
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this job post.
	 *
	 * @return the create date of this job post
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delete of this job post.
	 *
	 * @return the delete of this job post
	 */
	@Override
	public boolean getDelete() {
		return model.getDelete();
	}

	/**
	 * Returns the description of this job post.
	 *
	 * @return the description of this job post
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the experience of this job post.
	 *
	 * @return the experience of this job post
	 */
	@Override
	public String getExperience() {
		return model.getExperience();
	}

	/**
	 * Returns the group ID of this job post.
	 *
	 * @return the group ID of this job post
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job post ID of this job post.
	 *
	 * @return the job post ID of this job post
	 */
	@Override
	public long getJobPostId() {
		return model.getJobPostId();
	}

	/**
	 * Returns the job post name of this job post.
	 *
	 * @return the job post name of this job post
	 */
	@Override
	public String getJobPostName() {
		return model.getJobPostName();
	}

	/**
	 * Returns the location of this job post.
	 *
	 * @return the location of this job post
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this job post.
	 *
	 * @return the modified date of this job post
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this job post.
	 *
	 * @return the primary key of this job post
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the qualification of this job post.
	 *
	 * @return the qualification of this job post
	 */
	@Override
	public String getQualification() {
		return model.getQualification();
	}

	/**
	 * Returns the salary of this job post.
	 *
	 * @return the salary of this job post
	 */
	@Override
	public String getSalary() {
		return model.getSalary();
	}

	/**
	 * Returns the skills of this job post.
	 *
	 * @return the skills of this job post
	 */
	@Override
	public String getSkills() {
		return model.getSkills();
	}

	/**
	 * Returns the status of this job post.
	 *
	 * @return the status of this job post
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this job post.
	 *
	 * @return the user ID of this job post
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this job post.
	 *
	 * @return the user name of this job post
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this job post.
	 *
	 * @return the user uuid of this job post
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this job post.
	 *
	 * @return the uuid of this job post
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this job post is active.
	 *
	 * @return <code>true</code> if this job post is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this job post is delete.
	 *
	 * @return <code>true</code> if this job post is delete; <code>false</code> otherwise
	 */
	@Override
	public boolean isDelete() {
		return model.isDelete();
	}

	/**
	 * Returns <code>true</code> if this job post is status.
	 *
	 * @return <code>true</code> if this job post is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this job post is active.
	 *
	 * @param active the active of this job post
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this job post.
	 *
	 * @param companyId the company ID of this job post
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this job post.
	 *
	 * @param createDate the create date of this job post
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this job post is delete.
	 *
	 * @param delete the delete of this job post
	 */
	@Override
	public void setDelete(boolean delete) {
		model.setDelete(delete);
	}

	/**
	 * Sets the description of this job post.
	 *
	 * @param description the description of this job post
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the experience of this job post.
	 *
	 * @param experience the experience of this job post
	 */
	@Override
	public void setExperience(String experience) {
		model.setExperience(experience);
	}

	/**
	 * Sets the group ID of this job post.
	 *
	 * @param groupId the group ID of this job post
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job post ID of this job post.
	 *
	 * @param jobPostId the job post ID of this job post
	 */
	@Override
	public void setJobPostId(long jobPostId) {
		model.setJobPostId(jobPostId);
	}

	/**
	 * Sets the job post name of this job post.
	 *
	 * @param jobPostName the job post name of this job post
	 */
	@Override
	public void setJobPostName(String jobPostName) {
		model.setJobPostName(jobPostName);
	}

	/**
	 * Sets the location of this job post.
	 *
	 * @param location the location of this job post
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this job post.
	 *
	 * @param modifiedDate the modified date of this job post
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this job post.
	 *
	 * @param primaryKey the primary key of this job post
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qualification of this job post.
	 *
	 * @param qualification the qualification of this job post
	 */
	@Override
	public void setQualification(String qualification) {
		model.setQualification(qualification);
	}

	/**
	 * Sets the salary of this job post.
	 *
	 * @param salary the salary of this job post
	 */
	@Override
	public void setSalary(String salary) {
		model.setSalary(salary);
	}

	/**
	 * Sets the skills of this job post.
	 *
	 * @param skills the skills of this job post
	 */
	@Override
	public void setSkills(String skills) {
		model.setSkills(skills);
	}

	/**
	 * Sets whether this job post is status.
	 *
	 * @param status the status of this job post
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this job post.
	 *
	 * @param userId the user ID of this job post
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this job post.
	 *
	 * @param userName the user name of this job post
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this job post.
	 *
	 * @param userUuid the user uuid of this job post
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this job post.
	 *
	 * @param uuid the uuid of this job post
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected JobPostWrapper wrap(JobPost jobPost) {
		return new JobPostWrapper(jobPost);
	}

}