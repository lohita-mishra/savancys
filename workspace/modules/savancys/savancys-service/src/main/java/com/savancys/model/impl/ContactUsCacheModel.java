/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.savancys.model.ContactUs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactUs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactUsCacheModel
	implements CacheModel<ContactUs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContactUsCacheModel)) {
			return false;
		}

		ContactUsCacheModel contactUsCacheModel = (ContactUsCacheModel)object;

		if (contactId == contactUsCacheModel.contactId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", contactId=");
		sb.append(contactId);
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
		sb.append(", inquiryType=");
		sb.append(inquiryType);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", country=");
		sb.append(country);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append(", fullname=");
		sb.append(fullname);
		sb.append(", street=");
		sb.append(street);
		sb.append(", city=");
		sb.append(city);
		sb.append(", postcode=");
		sb.append(postcode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactUs toEntityModel() {
		ContactUsImpl contactUsImpl = new ContactUsImpl();

		if (uuid == null) {
			contactUsImpl.setUuid("");
		}
		else {
			contactUsImpl.setUuid(uuid);
		}

		contactUsImpl.setContactId(contactId);
		contactUsImpl.setGroupId(groupId);
		contactUsImpl.setCompanyId(companyId);
		contactUsImpl.setUserId(userId);

		if (userName == null) {
			contactUsImpl.setUserName("");
		}
		else {
			contactUsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactUsImpl.setCreateDate(null);
		}
		else {
			contactUsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactUsImpl.setModifiedDate(null);
		}
		else {
			contactUsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (inquiryType == null) {
			contactUsImpl.setInquiryType("");
		}
		else {
			contactUsImpl.setInquiryType(inquiryType);
		}

		if (firstName == null) {
			contactUsImpl.setFirstName("");
		}
		else {
			contactUsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			contactUsImpl.setLastName("");
		}
		else {
			contactUsImpl.setLastName(lastName);
		}

		if (phoneNumber == null) {
			contactUsImpl.setPhoneNumber("");
		}
		else {
			contactUsImpl.setPhoneNumber(phoneNumber);
		}

		if (email == null) {
			contactUsImpl.setEmail("");
		}
		else {
			contactUsImpl.setEmail(email);
		}

		if (companyName == null) {
			contactUsImpl.setCompanyName("");
		}
		else {
			contactUsImpl.setCompanyName(companyName);
		}

		if (country == null) {
			contactUsImpl.setCountry("");
		}
		else {
			contactUsImpl.setCountry(country);
		}

		if (additionalInfo == null) {
			contactUsImpl.setAdditionalInfo("");
		}
		else {
			contactUsImpl.setAdditionalInfo(additionalInfo);
		}

		if (fullname == null) {
			contactUsImpl.setFullname("");
		}
		else {
			contactUsImpl.setFullname(fullname);
		}

		if (street == null) {
			contactUsImpl.setStreet("");
		}
		else {
			contactUsImpl.setStreet(street);
		}

		if (city == null) {
			contactUsImpl.setCity("");
		}
		else {
			contactUsImpl.setCity(city);
		}

		if (postcode == null) {
			contactUsImpl.setPostcode("");
		}
		else {
			contactUsImpl.setPostcode(postcode);
		}

		contactUsImpl.resetOriginalValues();

		return contactUsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		contactId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		inquiryType = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		companyName = objectInput.readUTF();
		country = objectInput.readUTF();
		additionalInfo = objectInput.readUTF();
		fullname = objectInput.readUTF();
		street = objectInput.readUTF();
		city = objectInput.readUTF();
		postcode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(contactId);

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

		if (inquiryType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inquiryType);
		}

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

		if (companyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (additionalInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}

		if (fullname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullname);
		}

		if (street == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(street);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (postcode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postcode);
		}
	}

	public String uuid;
	public long contactId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String inquiryType;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String email;
	public String companyName;
	public String country;
	public String additionalInfo;
	public String fullname;
	public String street;
	public String city;
	public String postcode;

}