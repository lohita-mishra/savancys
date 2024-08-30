package com.savancys.web.util;

import java.util.Arrays;
import java.util.List;

public enum StatusUtil {
	PENDING(0), REVIEWED(1), REJECTED(2), SCHEDULED(3), RESCHEDULED(4), FEEDBACK(5), ONHOLD(8), SHORTLISTED(7),
	INTERVIEW_CANCELED(6), FEEDBACK_COMPLETED(9);

	private int status;

	StatusUtil(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;

	}

	public static String getStatusValue(int status) {
		for (StatusUtil statusEnum : StatusUtil.values()) {
			if (statusEnum.getStatus() == status) {
				return statusEnum.name();
			}
		}
		return null;
	}
	 public static List<StatusUtil> getAllStatus() {
	        return Arrays.asList(StatusUtil.values());
	    }
}
