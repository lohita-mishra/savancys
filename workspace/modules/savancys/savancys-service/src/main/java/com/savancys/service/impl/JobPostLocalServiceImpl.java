/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.savancys.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.model.JobPost;
import com.savancys.service.base.JobPostLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.savancys.model.JobPost",
	service = AopService.class
)
public class JobPostLocalServiceImpl extends JobPostLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(JobPostServiceImpl.class.getName());

	public JobPost saveOrUpdateJobPost(Long id, String jobPostName, String experience, String qualification,
			String location, String skills, String description, String salary, Boolean active) {
		log.info(id == null ? "Create job post" : "Update job post");

		JobPost jobPost;
		if (id == null) {
			long postId = CounterLocalServiceUtil.increment(JobPost.class.getName());
			jobPost = jobPostLocalService.createJobPost(postId);
		} else {
			jobPost = jobPostLocalService.fetchJobPost(id);
			if (jobPost == null) {
				log.error("Job post with id " + id + " not found.");
				return null; 
			}
		}

		try {
			jobPost.setJobPostName(jobPostName);
			jobPost.setExperience(experience);
			jobPost.setQualification(qualification);
			jobPost.setLocation(location);
			jobPost.setSkills(skills);
			jobPost.setDescription(description);
			jobPost.setSalary(salary);
			jobPost.setActive(active);

			if (id == null) {
				jobPost = jobPostLocalService.addJobPost(jobPost);
			} else {
				jobPost = jobPostLocalService.updateJobPost(jobPost);
			}
		} catch (Exception e) {
			log.error("Error populating job post: " + e.getMessage(), e);
		}

		return jobPost;
	}
	public List<JobPost> fetchActiveJobPosts() throws SystemException {
		DynamicQuery dynamicQuery = jobPostLocalService.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", true));
		try {
			return jobPostLocalService.dynamicQuery(dynamicQuery);
		} catch (Exception e) {
			log.error("Error fetching active job posts", e);
			throw new SystemException("Error fetching active job posts", e);
		}
	}
	public JobPost fetchJobPost(long jobPostId) {
		JobPost jobPost = null;
		if (Validator.isNotNull(jobPostId)) {
			try {
				jobPost = jobPostLocalService.getJobPost(jobPostId);
			} catch (PortalException e) {
				e.getMessage();
			}
		} else {
			log.info("JobPostId is null");
		}
		return jobPost;
	}
	public List<JobPost> fetchJobPosts(int start, int end) {
		return jobPostLocalService.getJobPosts(start, end);

	}

}