package com.savancys.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.model.JobPost;
import com.savancys.service.JobPostLocalService;
import com.savancys.service.JobPostService;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSJOBPOSTADMINWEB,
"mvc.command.name=/viewJobPost" }, service = MVCRenderCommand.class)
public class JobPostDetailsRender implements MVCRenderCommand {
private static final Log log = LogFactoryUtil.getLog(JobPostDetailsRender.class.getName());

@Reference
JobPostLocalService _jobPostService;

@Override
public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
Long jobPostId = ParamUtil.getLong(renderRequest, "jobPostId");
if (Validator.isNotNull(jobPostId)) {
	JobPost jobPost = null;
	try {
		jobPost = _jobPostService.fetchJobPost(jobPostId);
	} catch (Exception e) {
		e.getMessage();
	}
	renderRequest.setAttribute("jobPost", jobPost);
}
return "/job_post/job_post_details.jsp";
}

}
