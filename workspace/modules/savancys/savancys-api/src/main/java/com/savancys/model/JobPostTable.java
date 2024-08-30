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
 * The table class for the &quot;JobPost&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see JobPost
 * @generated
 */
public class JobPostTable extends BaseTable<JobPostTable> {

	public static final JobPostTable INSTANCE = new JobPostTable();

	public final Column<JobPostTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Long> jobPostId = createColumn(
		"jobPostId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<JobPostTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Boolean> delete = createColumn(
		"delete_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> jobPostName = createColumn(
		"jobPostName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> experience = createColumn(
		"experience", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> qualification = createColumn(
		"qualification", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> skills = createColumn(
		"skills", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, String> salary = createColumn(
		"salary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobPostTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private JobPostTable() {
		super("JobPost", JobPostTable::new);
	}

}