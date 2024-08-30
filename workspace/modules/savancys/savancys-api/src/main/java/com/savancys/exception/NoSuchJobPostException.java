/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.savancys.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchJobPostException extends NoSuchModelException {

	public NoSuchJobPostException() {
	}

	public NoSuchJobPostException(String msg) {
		super(msg);
	}

	public NoSuchJobPostException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchJobPostException(Throwable throwable) {
		super(throwable);
	}

}