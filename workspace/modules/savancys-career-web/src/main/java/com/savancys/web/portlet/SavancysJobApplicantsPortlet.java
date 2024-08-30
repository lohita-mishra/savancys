package com.savancys.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.savancys.model.JobApplicant;
import com.savancys.model.JobPost;
import com.savancys.service.JobApplicantLocalService;
import com.savancys.service.JobApplicantLocalServiceUtil;
import com.savancys.service.JobPostLocalService;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;
import com.savancys.web.util.StatusUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SavancysJobApplicantsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/job_applicant/job_applicants_details.jsp",
		"javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSJOBAPPLICANTSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SavancysJobApplicantsPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(SavancysJobApplicantsPortlet.class.getName());

	@Reference
	private JobApplicantLocalService _jobApplicantLocalService;

	@Reference
	private JobPostLocalService _jobPostLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		long postFilter = ParamUtil.getLong(renderRequest, "postFilter");
		String startDate = ParamUtil.getString(renderRequest, "startDate");
		String endDate = ParamUtil.getString(renderRequest, "endDate");

		Date formattedStartDate = getFormattedDate(startDate);
		Date formattedendDate = getFormattedDate(endDate);
		String backRedirectURL = "/";
		if (formattedendDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(formattedendDate);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			formattedendDate = calendar.getTime();
		}
		List<JobPost> activeJobPosts = _jobPostLocalService.fetchActiveJobPosts();
		List<JobApplicant> jobApplicantList = new ArrayList<>();
		int listSize = 0;
		try {
			jobApplicantList = JobApplicantLocalServiceUtil.getJobApplicantDetailsWithJobPostName(postFilter, formattedStartDate, formattedendDate);
			listSize = jobApplicantList.size();
		} catch (Exception e) {
			log.error("Error fetching job applicants: " + e.getMessage());
		}
		List<StatusUtil> allStatus = StatusUtil.getAllStatus();
		renderRequest.setAttribute("allStatus", allStatus);
		renderRequest.setAttribute("activeJobPosts", activeJobPosts);
		renderRequest.setAttribute("jobApplicantlist", jobApplicantList);
		renderRequest.setAttribute("listSize", listSize);
		renderRequest.setAttribute("postFilter", postFilter);
		renderRequest.setAttribute("startDate", startDate);
		renderRequest.setAttribute("endDate", endDate);
		renderRequest.setAttribute("backRedirectURL", backRedirectURL);
		super.render(renderRequest, renderResponse);
	}

	private Date getFormattedDate(String inputDateString) {
		try {
			SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			if (Validator.isNotNull(inputDateString)) {
				Date parsedDate = inputFormat.parse(inputDateString);
				String formattedDateString = outputFormat.format(parsedDate);
				Date formattedDate = outputFormat.parse(formattedDateString);
				return formattedDate;
			}
		} catch (ParseException e) {
			log.error("Error in passing date: " + e.getMessage());
		}
		return null;
	}
}
