package com.savancys.web.commands;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.savancys.model.JobApplicant;
import com.savancys.model.JobPost;
import com.savancys.service.JobApplicantLocalService;
import com.savancys.service.JobPostLocalService;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSJOBAPPLICANTSWEB,
		"mvc.command.name=/viewJobApplicantDetails" }, service = MVCRenderCommand.class)
public class JobAppicantProfileRender implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(JobAppicantProfileRender.class.getName());

	@Reference
	private JobApplicantLocalService _jobApplicantService;

	@Reference
	private JobPostLocalService _jobPostService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long jobApplicantId = ParamUtil.getLong(renderRequest, "jobApplicantId");
		JobApplicant jobApplicant = _jobApplicantService.fetchJobApplicant(jobApplicantId);
		JobPost jobPost = _jobPostService.fetchJobPost(jobApplicant.getJobPostId());
		String jobPostName = (jobPost != null) ? jobPost.getJobPostName() : "";
		List<String> skillsList = Arrays.asList(jobApplicant.getSkill().trim().split(","));
		String fileUrl = getFileUrl(jobApplicant.getFileId());
		setAttributes(renderRequest, jobApplicant, jobPostName, fileUrl, skillsList);

		return "/job_applicant/job_applicant_profile.jsp";
	}

	private String getFileUrl(long fileEntryId) {
		try {
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
			return "/documents/" + fileEntry.getRepositoryId() + "/" + fileEntry.getFolderId() + "/"
					+ fileEntry.getFileName() + "/" + fileEntry.getUuid();
		} catch (PortalException e) {
			log.error("Error retrieving file entry: " + e.getMessage(), e);
			return "";
		}
	}

	private void setAttributes(RenderRequest renderRequest, JobApplicant jobApplicant, String jobPostName,
			String fileUrl, List<String> skillsList) {
		renderRequest.setAttribute("jobApplicant", jobApplicant);
		renderRequest.setAttribute("jobPostName", jobPostName);
		renderRequest.setAttribute("fileUrl", fileUrl);
		renderRequest.setAttribute("skillsList", skillsList);
	}

}
