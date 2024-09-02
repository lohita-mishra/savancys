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
 * This class is a wrapper for {@link ContactUs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactUs
 * @generated
 */
public class ContactUsWrapper
	extends BaseModelWrapper<ContactUs>
	implements ContactUs, ModelWrapper<ContactUs> {

	public ContactUsWrapper(ContactUs contactUs) {
		super(contactUs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("contactId", getContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("inquiryType", getInquiryType());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("email", getEmail());
		attributes.put("companyName", getCompanyName());
		attributes.put("country", getCountry());
		attributes.put("additionalInfo", getAdditionalInfo());
		attributes.put("fullname", getFullname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
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

		String inquiryType = (String)attributes.get("inquiryType");

		if (inquiryType != null) {
			setInquiryType(inquiryType);
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

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}

		String fullname = (String)attributes.get("fullname");

		if (fullname != null) {
			setFullname(fullname);
		}
	}

	@Override
	public ContactUs cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the additional info of this contact us.
	 *
	 * @return the additional info of this contact us
	 */
	@Override
	public String getAdditionalInfo() {
		return model.getAdditionalInfo();
	}

	/**
	 * Returns the company ID of this contact us.
	 *
	 * @return the company ID of this contact us
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the company name of this contact us.
	 *
	 * @return the company name of this contact us
	 */
	@Override
	public String getCompanyName() {
		return model.getCompanyName();
	}

	/**
	 * Returns the contact ID of this contact us.
	 *
	 * @return the contact ID of this contact us
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the country of this contact us.
	 *
	 * @return the country of this contact us
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this contact us.
	 *
	 * @return the create date of this contact us
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this contact us.
	 *
	 * @return the email of this contact us
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this contact us.
	 *
	 * @return the first name of this contact us
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the fullname of this contact us.
	 *
	 * @return the fullname of this contact us
	 */
	@Override
	public String getFullname() {
		return model.getFullname();
	}

	/**
	 * Returns the group ID of this contact us.
	 *
	 * @return the group ID of this contact us
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the inquiry type of this contact us.
	 *
	 * @return the inquiry type of this contact us
	 */
	@Override
	public String getInquiryType() {
		return model.getInquiryType();
	}

	/**
	 * Returns the last name of this contact us.
	 *
	 * @return the last name of this contact us
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this contact us.
	 *
	 * @return the modified date of this contact us
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this contact us.
	 *
	 * @return the phone number of this contact us
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this contact us.
	 *
	 * @return the primary key of this contact us
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this contact us.
	 *
	 * @return the user ID of this contact us
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this contact us.
	 *
	 * @return the user name of this contact us
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this contact us.
	 *
	 * @return the user uuid of this contact us
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this contact us.
	 *
	 * @return the uuid of this contact us
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
	 * Sets the additional info of this contact us.
	 *
	 * @param additionalInfo the additional info of this contact us
	 */
	@Override
	public void setAdditionalInfo(String additionalInfo) {
		model.setAdditionalInfo(additionalInfo);
	}

	/**
	 * Sets the company ID of this contact us.
	 *
	 * @param companyId the company ID of this contact us
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the company name of this contact us.
	 *
	 * @param companyName the company name of this contact us
	 */
	@Override
	public void setCompanyName(String companyName) {
		model.setCompanyName(companyName);
	}

	/**
	 * Sets the contact ID of this contact us.
	 *
	 * @param contactId the contact ID of this contact us
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the country of this contact us.
	 *
	 * @param country the country of this contact us
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this contact us.
	 *
	 * @param createDate the create date of this contact us
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this contact us.
	 *
	 * @param email the email of this contact us
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this contact us.
	 *
	 * @param firstName the first name of this contact us
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the fullname of this contact us.
	 *
	 * @param fullname the fullname of this contact us
	 */
	@Override
	public void setFullname(String fullname) {
		model.setFullname(fullname);
	}

	/**
	 * Sets the group ID of this contact us.
	 *
	 * @param groupId the group ID of this contact us
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the inquiry type of this contact us.
	 *
	 * @param inquiryType the inquiry type of this contact us
	 */
	@Override
	public void setInquiryType(String inquiryType) {
		model.setInquiryType(inquiryType);
	}

	/**
	 * Sets the last name of this contact us.
	 *
	 * @param lastName the last name of this contact us
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this contact us.
	 *
	 * @param modifiedDate the modified date of this contact us
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this contact us.
	 *
	 * @param phoneNumber the phone number of this contact us
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this contact us.
	 *
	 * @param primaryKey the primary key of this contact us
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this contact us.
	 *
	 * @param userId the user ID of this contact us
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this contact us.
	 *
	 * @param userName the user name of this contact us
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this contact us.
	 *
	 * @param userUuid the user uuid of this contact us
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this contact us.
	 *
	 * @param uuid the uuid of this contact us
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
	protected ContactUsWrapper wrap(ContactUs contactUs) {
		return new ContactUsWrapper(contactUs);
	}

}