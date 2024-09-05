/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.model.JobApplicant;
import com.savancys.model.JobApplicantDTO;
import com.savancys.service.base.JobApplicantLocalServiceBaseImpl;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.savancys.model.JobApplicant", service = AopService.class)
public class JobApplicantLocalServiceImpl extends JobApplicantLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(JobApplicantLocalServiceImpl.class.getName());

	public JobApplicant createJobApplicant(String firstName, String lastName, String jobType, String state,
			String email, String phoneNumber, long jobPostId, String message, String skills, long fileEntryId,String webAuthorization) {
		log.info("Create Job Applicant Method");

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		if (serviceContext == null) {
			log.error("ServiceContext is not available.");
			return null;
		}
		long jobApplicantId = CounterLocalServiceUtil.increment(JobApplicant.class.getName());
		JobApplicant jobApplicant = jobApplicantLocalService.createJobApplicant(jobApplicantId);
		jobApplicant.setCompanyId(serviceContext.getCompanyId());
		jobApplicant.setUserId(serviceContext.getUserId());
		jobApplicant.setGroupId(serviceContext.getScopeGroupId());
		jobApplicant.setUserName(serviceContext.getThemeDisplay().getUser().getFullName());
		jobApplicant.setFirstName(firstName);
		jobApplicant.setLastName(lastName);
		jobApplicant.setJobType(jobType);
		jobApplicant.setState(state);
		jobApplicant.setEmail(email);
		jobApplicant.setPhoneNumber(phoneNumber);
		jobApplicant.setJobPostId(jobPostId);
		jobApplicant.setMessage(message);
		jobApplicant.setSkill(skills);
		jobApplicant.setFileId(fileEntryId);
		jobApplicant.setWebAuthorization(webAuthorization);
		jobApplicant = jobApplicantLocalService.addJobApplicant(jobApplicant);
		log.info("Created Job Applicant name :" + jobApplicant.getFirstName());
		return jobApplicant;

	}

	public List<JobApplicant> getJobApplicantDetailsWithJobPostName(Long jobPostId, Date startDate, Date endDate) {
		DynamicQuery dynamicQuery = jobApplicantLocalService.dynamicQuery();

		if (Validator.isNotNull(jobPostId) && jobPostId != 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("jobPostId", jobPostId));
		}

		if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate)) {
			dynamicQuery.add(RestrictionsFactoryUtil.between("createDate", startDate, endDate));
		} else if (Validator.isNotNull(startDate)) {
			dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", startDate));
		} else if (Validator.isNotNull(endDate)) {
			dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", endDate));
		}

		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		List<JobApplicant> jobApplicants = jobApplicantLocalService.dynamicQuery(dynamicQuery);
		log.info("jobApplicants List -" + jobApplicants.size());
		return jobApplicants;
	}

	public List<JobApplicantDTO> getAppicantsByFilter(long jobPostId, Date startDate, Date endDate) {
		List<JobApplicantDTO> jobApplicants = jobApplicantFinder.getJobApplicantDetailsWithJobPostName(jobPostId,
				startDate, endDate);
		log.info("jobApplicants" + jobApplicants);
		return jobApplicants;
	}
}