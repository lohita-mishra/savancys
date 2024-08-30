/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.savancys.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchContactUsException extends NoSuchModelException {

	public NoSuchContactUsException() {
	}

	public NoSuchContactUsException(String msg) {
		super(msg);
	}

	public NoSuchContactUsException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchContactUsException(Throwable throwable) {
		super(throwable);
	}

}