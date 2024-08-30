/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.savancys.model.JobPost;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobPost in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobPostCacheModel implements CacheModel<JobPost>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobPostCacheModel)) {
			return false;
		}

		JobPostCacheModel jobPostCacheModel = (JobPostCacheModel)object;

		if (jobPostId == jobPostCacheModel.jobPostId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobPostId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", jobPostId=");
		sb.append(jobPostId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", delete=");
		sb.append(delete);
		sb.append(", jobPostName=");
		sb.append(jobPostName);
		sb.append(", experience=");
		sb.append(experience);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", location=");
		sb.append(location);
		sb.append(", skills=");
		sb.append(skills);
		sb.append(", description=");
		sb.append(description);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobPost toEntityModel() {
		JobPostImpl jobPostImpl = new JobPostImpl();

		if (uuid == null) {
			jobPostImpl.setUuid("");
		}
		else {
			jobPostImpl.setUuid(uuid);
		}

		jobPostImpl.setJobPostId(jobPostId);
		jobPostImpl.setGroupId(groupId);
		jobPostImpl.setCompanyId(companyId);
		jobPostImpl.setUserId(userId);

		if (userName == null) {
			jobPostImpl.setUserName("");
		}
		else {
			jobPostImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			jobPostImpl.setCreateDate(null);
		}
		else {
			jobPostImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobPostImpl.setModifiedDate(null);
		}
		else {
			jobPostImpl.setModifiedDate(new Date(modifiedDate));
		}

		jobPostImpl.setActive(active);
		jobPostImpl.setDelete(delete);

		if (jobPostName == null) {
			jobPostImpl.setJobPostName("");
		}
		else {
			jobPostImpl.setJobPostName(jobPostName);
		}

		if (experience == null) {
			jobPostImpl.setExperience("");
		}
		else {
			jobPostImpl.setExperience(experience);
		}

		if (qualification == null) {
			jobPostImpl.setQualification("");
		}
		else {
			jobPostImpl.setQualification(qualification);
		}

		if (location == null) {
			jobPostImpl.setLocation("");
		}
		else {
			jobPostImpl.setLocation(location);
		}

		if (skills == null) {
			jobPostImpl.setSkills("");
		}
		else {
			jobPostImpl.setSkills(skills);
		}

		if (description == null) {
			jobPostImpl.setDescription("");
		}
		else {
			jobPostImpl.setDescription(description);
		}

		if (salary == null) {
			jobPostImpl.setSalary("");
		}
		else {
			jobPostImpl.setSalary(salary);
		}

		jobPostImpl.setStatus(status);

		jobPostImpl.resetOriginalValues();

		return jobPostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		jobPostId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		active = objectInput.readBoolean();

		delete = objectInput.readBoolean();
		jobPostName = objectInput.readUTF();
		experience = objectInput.readUTF();
		qualification = objectInput.readUTF();
		location = objectInput.readUTF();
		skills = objectInput.readUTF();
		description = objectInput.readUTF();
		salary = objectInput.readUTF();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(jobPostId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(active);

		objectOutput.writeBoolean(delete);

		if (jobPostName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobPostName);
		}

		if (experience == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(experience);
		}

		if (qualification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (skills == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skills);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (salary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salary);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long jobPostId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public boolean delete;
	public String jobPostName;
	public String experience;
	public String qualification;
	public String location;
	public String skills;
	public String description;
	public String salary;
	public boolean status;

}