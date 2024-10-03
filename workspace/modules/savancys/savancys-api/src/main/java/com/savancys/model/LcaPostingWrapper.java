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
 * This class is a wrapper for {@link LcaPosting}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LcaPosting
 * @generated
 */
public class LcaPostingWrapper
	extends BaseModelWrapper<LcaPosting>
	implements LcaPosting, ModelWrapper<LcaPosting> {

	public LcaPostingWrapper(LcaPosting lcaPosting) {
		super(lcaPosting);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("lcaPostingId", getLcaPostingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("designation", getDesignation());
		attributes.put("location", getLocation());
		attributes.put("oNetCode", getONetCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long lcaPostingId = (Long)attributes.get("lcaPostingId");

		if (lcaPostingId != null) {
			setLcaPostingId(lcaPostingId);
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

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String oNetCode = (String)attributes.get("oNetCode");

		if (oNetCode != null) {
			setONetCode(oNetCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public LcaPosting cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this lca posting.
	 *
	 * @return the company ID of this lca posting
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this lca posting.
	 *
	 * @return the create date of this lca posting
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this lca posting.
	 *
	 * @return the description of this lca posting
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the designation of this lca posting.
	 *
	 * @return the designation of this lca posting
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the group ID of this lca posting.
	 *
	 * @return the group ID of this lca posting
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lca posting ID of this lca posting.
	 *
	 * @return the lca posting ID of this lca posting
	 */
	@Override
	public long getLcaPostingId() {
		return model.getLcaPostingId();
	}

	/**
	 * Returns the location of this lca posting.
	 *
	 * @return the location of this lca posting
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this lca posting.
	 *
	 * @return the modified date of this lca posting
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the o net code of this lca posting.
	 *
	 * @return the o net code of this lca posting
	 */
	@Override
	public String getONetCode() {
		return model.getONetCode();
	}

	/**
	 * Returns the primary key of this lca posting.
	 *
	 * @return the primary key of this lca posting
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this lca posting.
	 *
	 * @return the user ID of this lca posting
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this lca posting.
	 *
	 * @return the user name of this lca posting
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this lca posting.
	 *
	 * @return the user uuid of this lca posting
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this lca posting.
	 *
	 * @return the uuid of this lca posting
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this lca posting.
	 *
	 * @param companyId the company ID of this lca posting
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lca posting.
	 *
	 * @param createDate the create date of this lca posting
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this lca posting.
	 *
	 * @param description the description of this lca posting
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the designation of this lca posting.
	 *
	 * @param designation the designation of this lca posting
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the group ID of this lca posting.
	 *
	 * @param groupId the group ID of this lca posting
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lca posting ID of this lca posting.
	 *
	 * @param lcaPostingId the lca posting ID of this lca posting
	 */
	@Override
	public void setLcaPostingId(long lcaPostingId) {
		model.setLcaPostingId(lcaPostingId);
	}

	/**
	 * Sets the location of this lca posting.
	 *
	 * @param location the location of this lca posting
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this lca posting.
	 *
	 * @param modifiedDate the modified date of this lca posting
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the o net code of this lca posting.
	 *
	 * @param oNetCode the o net code of this lca posting
	 */
	@Override
	public void setONetCode(String oNetCode) {
		model.setONetCode(oNetCode);
	}

	/**
	 * Sets the primary key of this lca posting.
	 *
	 * @param primaryKey the primary key of this lca posting
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this lca posting.
	 *
	 * @param userId the user ID of this lca posting
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this lca posting.
	 *
	 * @param userName the user name of this lca posting
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lca posting.
	 *
	 * @param userUuid the user uuid of this lca posting
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this lca posting.
	 *
	 * @param uuid the uuid of this lca posting
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
	protected LcaPostingWrapper wrap(LcaPosting lcaPosting) {
		return new LcaPostingWrapper(lcaPosting);
	}

}