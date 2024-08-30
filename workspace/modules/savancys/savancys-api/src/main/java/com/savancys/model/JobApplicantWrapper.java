/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JobApplicant}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicant
 * @generated
 */
public class JobApplicantWrapper
	extends BaseModelWrapper<JobApplicant>
	implements JobApplicant, ModelWrapper<JobApplicant> {

	public JobApplicantWrapper(JobApplicant jobApplicant) {
		super(jobApplicant);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobApplicantID", getJobApplicantID());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("email", getEmail());
		attributes.put("jobType", getJobType());
		attributes.put("state", getState());
		attributes.put("message", getMessage());
		attributes.put("fileId", getFileId());
		attributes.put("jobPostId", getJobPostId());
		attributes.put("skill", getSkill());
		attributes.put("webAuthorization", getWebAuthorization());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobApplicantID = (Long)attributes.get("jobApplicantID");

		if (jobApplicantID != null) {
			setJobApplicantID(jobApplicantID);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Long jobPostId = (Long)attributes.get("jobPostId");

		if (jobPostId != null) {
			setJobPostId(jobPostId);
		}

		String skill = (String)attributes.get("skill");

		if (skill != null) {
			setSkill(skill);
		}

		String webAuthorization = (String)attributes.get("webAuthorization");

		if (webAuthorization != null) {
			setWebAuthorization(webAuthorization);
		}
	}

	@Override
	public JobApplicant cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this job applicant.
	 *
	 * @return the company ID of this job applicant
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this job applicant.
	 *
	 * @return the create date of this job applicant
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this job applicant.
	 *
	 * @return the email of this job applicant
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the file ID of this job applicant.
	 *
	 * @return the file ID of this job applicant
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the first name of this job applicant.
	 *
	 * @return the first name of this job applicant
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this job applicant.
	 *
	 * @return the group ID of this job applicant
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job applicant ID of this job applicant.
	 *
	 * @return the job applicant ID of this job applicant
	 */
	@Override
	public long getJobApplicantID() {
		return model.getJobApplicantID();
	}

	/**
	 * Returns the job post ID of this job applicant.
	 *
	 * @return the job post ID of this job applicant
	 */
	@Override
	public long getJobPostId() {
		return model.getJobPostId();
	}

	/**
	 * Returns the job type of this job applicant.
	 *
	 * @return the job type of this job applicant
	 */
	@Override
	public String getJobType() {
		return model.getJobType();
	}

	/**
	 * Returns the last name of this job applicant.
	 *
	 * @return the last name of this job applicant
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the message of this job applicant.
	 *
	 * @return the message of this job applicant
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the modified date of this job applicant.
	 *
	 * @return the modified date of this job applicant
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this job applicant.
	 *
	 * @return the phone number of this job applicant
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this job applicant.
	 *
	 * @return the primary key of this job applicant
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the skill of this job applicant.
	 *
	 * @return the skill of this job applicant
	 */
	@Override
	public String getSkill() {
		return model.getSkill();
	}

	/**
	 * Returns the state of this job applicant.
	 *
	 * @return the state of this job applicant
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this job applicant.
	 *
	 * @return the user ID of this job applicant
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this job applicant.
	 *
	 * @return the user name of this job applicant
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this job applicant.
	 *
	 * @return the user uuid of this job applicant
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the web authorization of this job applicant.
	 *
	 * @return the web authorization of this job applicant
	 */
	@Override
	public String getWebAuthorization() {
		return model.getWebAuthorization();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this job applicant.
	 *
	 * @param companyId the company ID of this job applicant
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this job applicant.
	 *
	 * @param createDate the create date of this job applicant
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this job applicant.
	 *
	 * @param email the email of this job applicant
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the file ID of this job applicant.
	 *
	 * @param fileId the file ID of this job applicant
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the first name of this job applicant.
	 *
	 * @param firstName the first name of this job applicant
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this job applicant.
	 *
	 * @param groupId the group ID of this job applicant
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job applicant ID of this job applicant.
	 *
	 * @param jobApplicantID the job applicant ID of this job applicant
	 */
	@Override
	public void setJobApplicantID(long jobApplicantID) {
		model.setJobApplicantID(jobApplicantID);
	}

	/**
	 * Sets the job post ID of this job applicant.
	 *
	 * @param jobPostId the job post ID of this job applicant
	 */
	@Override
	public void setJobPostId(long jobPostId) {
		model.setJobPostId(jobPostId);
	}

	/**
	 * Sets the job type of this job applicant.
	 *
	 * @param jobType the job type of this job applicant
	 */
	@Override
	public void setJobType(String jobType) {
		model.setJobType(jobType);
	}

	/**
	 * Sets the last name of this job applicant.
	 *
	 * @param lastName the last name of this job applicant
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the message of this job applicant.
	 *
	 * @param message the message of this job applicant
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the modified date of this job applicant.
	 *
	 * @param modifiedDate the modified date of this job applicant
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this job applicant.
	 *
	 * @param phoneNumber the phone number of this job applicant
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this job applicant.
	 *
	 * @param primaryKey the primary key of this job applicant
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the skill of this job applicant.
	 *
	 * @param skill the skill of this job applicant
	 */
	@Override
	public void setSkill(String skill) {
		model.setSkill(skill);
	}

	/**
	 * Sets the state of this job applicant.
	 *
	 * @param state the state of this job applicant
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this job applicant.
	 *
	 * @param userId the user ID of this job applicant
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this job applicant.
	 *
	 * @param userName the user name of this job applicant
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this job applicant.
	 *
	 * @param userUuid the user uuid of this job applicant
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the web authorization of this job applicant.
	 *
	 * @param webAuthorization the web authorization of this job applicant
	 */
	@Override
	public void setWebAuthorization(String webAuthorization) {
		model.setWebAuthorization(webAuthorization);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected JobApplicantWrapper wrap(JobApplicant jobApplicant) {
		return new JobApplicantWrapper(jobApplicant);
	}

}