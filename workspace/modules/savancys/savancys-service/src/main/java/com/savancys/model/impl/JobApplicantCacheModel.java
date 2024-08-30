/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.savancys.model.JobApplicant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobApplicant in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobApplicantCacheModel
	implements CacheModel<JobApplicant>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobApplicantCacheModel)) {
			return false;
		}

		JobApplicantCacheModel jobApplicantCacheModel =
			(JobApplicantCacheModel)object;

		if (jobApplicantID == jobApplicantCacheModel.jobApplicantID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobApplicantID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{jobApplicantID=");
		sb.append(jobApplicantID);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", jobType=");
		sb.append(jobType);
		sb.append(", state=");
		sb.append(state);
		sb.append(", message=");
		sb.append(message);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", jobPostId=");
		sb.append(jobPostId);
		sb.append(", skill=");
		sb.append(skill);
		sb.append(", webAuthorization=");
		sb.append(webAuthorization);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobApplicant toEntityModel() {
		JobApplicantImpl jobApplicantImpl = new JobApplicantImpl();

		jobApplicantImpl.setJobApplicantID(jobApplicantID);
		jobApplicantImpl.setGroupId(groupId);
		jobApplicantImpl.setCompanyId(companyId);
		jobApplicantImpl.setUserId(userId);

		if (userName == null) {
			jobApplicantImpl.setUserName("");
		}
		else {
			jobApplicantImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			jobApplicantImpl.setCreateDate(null);
		}
		else {
			jobApplicantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobApplicantImpl.setModifiedDate(null);
		}
		else {
			jobApplicantImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			jobApplicantImpl.setFirstName("");
		}
		else {
			jobApplicantImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			jobApplicantImpl.setLastName("");
		}
		else {
			jobApplicantImpl.setLastName(lastName);
		}

		if (phoneNumber == null) {
			jobApplicantImpl.setPhoneNumber("");
		}
		else {
			jobApplicantImpl.setPhoneNumber(phoneNumber);
		}

		if (email == null) {
			jobApplicantImpl.setEmail("");
		}
		else {
			jobApplicantImpl.setEmail(email);
		}

		if (jobType == null) {
			jobApplicantImpl.setJobType("");
		}
		else {
			jobApplicantImpl.setJobType(jobType);
		}

		if (state == null) {
			jobApplicantImpl.setState("");
		}
		else {
			jobApplicantImpl.setState(state);
		}

		if (message == null) {
			jobApplicantImpl.setMessage("");
		}
		else {
			jobApplicantImpl.setMessage(message);
		}

		jobApplicantImpl.setFileId(fileId);
		jobApplicantImpl.setJobPostId(jobPostId);

		if (skill == null) {
			jobApplicantImpl.setSkill("");
		}
		else {
			jobApplicantImpl.setSkill(skill);
		}

		if (webAuthorization == null) {
			jobApplicantImpl.setWebAuthorization("");
		}
		else {
			jobApplicantImpl.setWebAuthorization(webAuthorization);
		}

		jobApplicantImpl.resetOriginalValues();

		return jobApplicantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobApplicantID = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		jobType = objectInput.readUTF();
		state = objectInput.readUTF();
		message = objectInput.readUTF();

		fileId = objectInput.readLong();

		jobPostId = objectInput.readLong();
		skill = objectInput.readUTF();
		webAuthorization = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(jobApplicantID);

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

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (jobType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobType);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeLong(fileId);

		objectOutput.writeLong(jobPostId);

		if (skill == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skill);
		}

		if (webAuthorization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(webAuthorization);
		}
	}

	public long jobApplicantID;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String email;
	public String jobType;
	public String state;
	public String message;
	public long fileId;
	public long jobPostId;
	public String skill;
	public String webAuthorization;

}