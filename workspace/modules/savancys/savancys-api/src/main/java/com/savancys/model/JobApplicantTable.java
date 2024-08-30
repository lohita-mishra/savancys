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
 * The table class for the &quot;JobApplicant&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see JobApplicant
 * @generated
 */
public class JobApplicantTable extends BaseTable<JobApplicantTable> {

	public static final JobApplicantTable INSTANCE = new JobApplicantTable();

	public final Column<JobApplicantTable, Long> jobApplicantID = createColumn(
		"jobApplicantID", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<JobApplicantTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> phoneNumber = createColumn(
		"phoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> jobType = createColumn(
		"jobType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> message = createColumn(
		"message", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, Long> jobPostId = createColumn(
		"jobPostId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> skill = createColumn(
		"skill", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobApplicantTable, String> webAuthorization =
		createColumn(
			"webAuthorization", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private JobApplicantTable() {
		super("JobApplicant", JobApplicantTable::new);
	}

}