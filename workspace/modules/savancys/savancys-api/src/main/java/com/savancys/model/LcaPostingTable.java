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
 * The table class for the &quot;LCA_Posting&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LcaPosting
 * @generated
 */
public class LcaPostingTable extends BaseTable<LcaPostingTable> {

	public static final LcaPostingTable INSTANCE = new LcaPostingTable();

	public final Column<LcaPostingTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, Long> lcaPostingId = createColumn(
		"lcaPostingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LcaPostingTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, String> designation = createColumn(
		"designation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, String> oNetCode = createColumn(
		"oNetCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LcaPostingTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LcaPostingTable() {
		super("LCA_Posting", LcaPostingTable::new);
	}

}