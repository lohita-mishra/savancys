package com.savancys.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.service.JobPostLocalService;
import com.savancys.service.JobPostLocalServiceUtil;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSJOBPOSTADMINWEB,
		"mvc.command.name=saveJobPost" }, service = MVCActionCommand.class)
public class JobPostSaveAction extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(JobPostSaveAction.class);

	@Reference
	JobPostLocalService _jobPostLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("Process Action method called!!");

		Long jobPostId = ParamUtil.getLong(actionRequest, "jobPostId");
		String jobPostName = ParamUtil.getString(actionRequest, "jobPostName").trim();
		String experience = ParamUtil.getString(actionRequest, "experience").trim();
		String qualification = ParamUtil.getString(actionRequest, "qualification").trim();
		String location = ParamUtil.getString(actionRequest, "location").trim();
		String skills = ParamUtil.getString(actionRequest, "skills").trim();
		String description = ParamUtil.getString(actionRequest, "description").trim();
		boolean active = ParamUtil.getBoolean(actionRequest, "activated");

		if (Validator.isNull(jobPostName) || Validator.isNull(experience) || Validator.isNull(qualification)
				|| Validator.isNull(location) || Validator.isNull(description) ) {
			SessionMessages.add(actionRequest, "error", "Required fields should not be null!");
			return;
		}

		try {
			if (jobPostId == null || jobPostId == 0) {
				_jobPostLocalService.saveOrUpdateJobPost(null, jobPostName, experience, qualification, location, skills,
						description, null, active);
				SessionMessages.add(actionRequest, "success", "Job Post created successfully!");
			} else {
				log.info("Updation called for JobPost ID: " + jobPostId);
				_jobPostLocalService.saveOrUpdateJobPost(jobPostId, jobPostName, experience, qualification, location,
						skills, description, null, active);
				SessionMessages.add(actionRequest, "success", "Job Post updated successfully!");
			}
		} catch (Exception e) {
			log.error("Error processing job post: " + e.getMessage(), e);
			SessionMessages.add(actionRequest, "error", "An error occurred while processing the Job Post.");
		}
	}

}
