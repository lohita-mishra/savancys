/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.savancys.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchJobApplicantException extends NoSuchModelException {

	public NoSuchJobApplicantException() {
	}

	public NoSuchJobApplicantException(String msg) {
		super(msg);
	}

	public NoSuchJobApplicantException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchJobApplicantException(Throwable throwable) {
		super(throwable);
	}

}