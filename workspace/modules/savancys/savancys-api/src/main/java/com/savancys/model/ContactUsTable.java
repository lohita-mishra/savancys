/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ContactUs&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ContactUs
 * @generated
 */
public class ContactUsTable extends BaseTable<ContactUsTable> {

	public static final ContactUsTable INSTANCE = new ContactUsTable();

	public final Column<ContactUsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, Long> contactId = createColumn(
		"contactId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ContactUsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> inquiryType = createColumn(
		"inquiryType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> phoneNumber = createColumn(
		"phoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> companyName = createColumn(
		"companyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> country = createColumn(
		"country", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> additionalInfo = createColumn(
		"additionalInfo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ContactUsTable, String> fullname = createColumn(
		"fullname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ContactUsTable() {
		super("ContactUs", ContactUsTable::new);
	}

}