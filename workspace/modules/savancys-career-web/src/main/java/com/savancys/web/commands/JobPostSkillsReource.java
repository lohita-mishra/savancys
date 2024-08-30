package com.savancys.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.savancys.model.JobPost;
import com.savancys.service.JobPostLocalServiceUtil;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSCAREERWEB,
		"mvc.command.name=getJobPostSkill" }, service = MVCResourceCommand.class)
public class JobPostSkillsReource implements MVCResourceCommand {
	private static final Log log = LogFactoryUtil.getLog(JobPostSkillsReource.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		long jobPostId = ParamUtil.getLong(resourceRequest, "jobPostId");
		JobPost jobPost;
		try {
			jobPost = JobPostLocalServiceUtil.getJobPost(jobPostId);
			List<String> skillsList = Arrays.asList(jobPost.getSkills().trim().split(","));
			log.info("skillsList"+skillsList);
			Writer writer = resourceResponse.getWriter();
			String request = JSONFactoryUtil.looseSerializeDeep(skillsList);
			writer.write(request);
		} catch (PortalException | IOException e) {
			log.error(e.getMessage());
		}
		return true;
	}
}
