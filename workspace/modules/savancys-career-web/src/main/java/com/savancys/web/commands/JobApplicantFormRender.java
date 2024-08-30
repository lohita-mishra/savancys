package com.savancys.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.model.JobPost;
import com.savancys.service.JobPostLocalService;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSCAREERWEB,
		"mvc.command.name=/jobApplicationForm" }, service = MVCRenderCommand.class)
public class JobApplicantFormRender implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(JobApplicantFormRender.class.getName());
	@Reference
	private JobPostLocalService _jobPostLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			long jobPostId = ParamUtil.getLong(renderRequest, "jobPostId");
			if(Validator.isNotNull(jobPostId)) {
				JobPost jobPost = _jobPostLocalService.fetchJobPost(jobPostId);
				String skills = jobPost.getSkills().trim();
				List<String> skillsList;

				if (skills.isEmpty()) {
				    skillsList = Collections.emptyList(); 
				} else {
				    skillsList = Arrays.asList(skills.split(","));
				}

				renderRequest.setAttribute("skillsList", skillsList);
				List<JobPost> activeJobPosts = _jobPostLocalService.fetchActiveJobPosts();
				renderRequest.setAttribute("activeJobPosts", activeJobPosts);
				renderRequest.setAttribute("jobPost", jobPost);
			}
		}catch (Exception e) {
			e.getMessage();
		}
		return "/guests/job_applicant_form.jsp";
	}

	
	
}
