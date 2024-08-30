package com.savancys.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.savancys.model.JobApplicant;
import com.savancys.service.JobApplicantLocalService;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;
import com.savancys.web.util.UploadFileUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSCAREERWEB,
		"mvc.command.name=jobApplicationForm" }, service = MVCActionCommand.class)
public class JobApplicantFormSaveAction extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(JobApplicantFormSaveAction.class);

	@Reference
	private JobApplicantLocalService jobApplicantLocalService;

	@Reference
	private UploadFileUtil uploadFileUtil;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("doProcessAction");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String firstName = ParamUtil.getString(actionRequest, "firstName").trim();
		String lastName = ParamUtil.getString(actionRequest, "lastName").trim();
		String email = ParamUtil.getString(actionRequest, "email").trim();
		String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber").trim();
		String jobType = ParamUtil.getString(actionRequest, "jobType");
		String state = ParamUtil.getString(actionRequest, "state");
		String[] skillList = ParamUtil.getParameterValues(actionRequest, "skill");
		String skills = getSkillsString(skillList);
		String message = ParamUtil.getString(actionRequest, "message");
		String webAuthorization = ParamUtil.getString(actionRequest, "webAuthorization");
		
		long jobPostId = ParamUtil.getLong(actionRequest, "jobPostId");
		long fileId = handleFileUpload("file",firstName, themeDisplay, actionRequest);

		if (Validator.isNull(firstName) || Validator.isNull(firstName) || Validator.isNull(email)
				|| Validator.isNull(phoneNumber) || Validator.isNull(jobType) || Validator.isNull(state)
				|| Validator.isNull(fileId)) {
			SessionMessages.add(actionRequest, "error", "Required fields should not be null!");
			return;
		}
		try {
			jobApplicantLocalService.createJobApplicant(firstName, lastName, jobType, state, email, phoneNumber,
					jobPostId, message, skills, fileId,webAuthorization);
			SessionMessages.add(actionRequest, "Job-Application created Successfully!");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private String getSkillsString(String[] skillList) {
		StringBuilder skills = new StringBuilder();
		for (int i = 0; i < skillList.length; i++) {
			skills.append(skillList[i]);
			if (i < skillList.length - 1) {
				skills.append(",");
			}
		}
		return skills.toString();
	}

	private long handleFileUpload(String paramName, String firstName, ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName(paramName);
		long fileId = 0;
		if (Validator.isNotNull(fileName)) {
			File file = uploadPortletRequest.getFile(paramName);
			String mimeType = uploadPortletRequest.getContentType(paramName);
			fileId = uploadFileUtil.fileUpload(themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(),
					actionRequest, firstName, file, mimeType);
		} else {
			long jobAppId = ParamUtil.getLong(actionRequest, "jobAppId");
			if (Validator.isNotNull(jobAppId)) {
				JobApplicant jobApplicant;
				try {
					jobApplicant = jobApplicantLocalService.getJobApplicant(jobAppId);
					fileId = jobApplicant.getFileId();
				} catch (PortalException e) {
					log.error(e.getMessage());
				}
			}
		}
		return fileId;
	}
}
