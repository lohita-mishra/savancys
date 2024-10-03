/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.savancys.model.LcaPosting;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LcaPosting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LcaPostingCacheModel
	implements CacheModel<LcaPosting>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LcaPostingCacheModel)) {
			return false;
		}

		LcaPostingCacheModel lcaPostingCacheModel =
			(LcaPostingCacheModel)object;

		if (lcaPostingId == lcaPostingCacheModel.lcaPostingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lcaPostingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", lcaPostingId=");
		sb.append(lcaPostingId);
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
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", location=");
		sb.append(location);
		sb.append(", oNetCode=");
		sb.append(oNetCode);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LcaPosting toEntityModel() {
		LcaPostingImpl lcaPostingImpl = new LcaPostingImpl();

		if (uuid == null) {
			lcaPostingImpl.setUuid("");
		}
		else {
			lcaPostingImpl.setUuid(uuid);
		}

		lcaPostingImpl.setLcaPostingId(lcaPostingId);
		lcaPostingImpl.setGroupId(groupId);
		lcaPostingImpl.setCompanyId(companyId);
		lcaPostingImpl.setUserId(userId);

		if (userName == null) {
			lcaPostingImpl.setUserName("");
		}
		else {
			lcaPostingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lcaPostingImpl.setCreateDate(null);
		}
		else {
			lcaPostingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lcaPostingImpl.setModifiedDate(null);
		}
		else {
			lcaPostingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (designation == null) {
			lcaPostingImpl.setDesignation("");
		}
		else {
			lcaPostingImpl.setDesignation(designation);
		}

		if (location == null) {
			lcaPostingImpl.setLocation("");
		}
		else {
			lcaPostingImpl.setLocation(location);
		}

		if (oNetCode == null) {
			lcaPostingImpl.setONetCode("");
		}
		else {
			lcaPostingImpl.setONetCode(oNetCode);
		}

		if (description == null) {
			lcaPostingImpl.setDescription("");
		}
		else {
			lcaPostingImpl.setDescription(description);
		}

		lcaPostingImpl.resetOriginalValues();

		return lcaPostingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		lcaPostingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		designation = objectInput.readUTF();
		location = objectInput.readUTF();
		oNetCode = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(lcaPostingId);

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

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (oNetCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oNetCode);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long lcaPostingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String designation;
	public String location;
	public String oNetCode;
	public String description;

}