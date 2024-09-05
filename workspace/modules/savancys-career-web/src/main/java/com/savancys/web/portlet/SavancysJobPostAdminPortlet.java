package com.savancys.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.savancys.model.JobPost;
import com.savancys.service.JobPostLocalService;
import com.savancys.service.JobPostLocalServiceUtil;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=savancys",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=SavancysJobPostAdmin",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/job_post/job_posts_view.jsp",
			"javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSJOBPOSTADMINWEB,
			"javax.portlet.resource-bundle=content.Language",
			"com.liferay.portlet.add-default-resource=true",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class SavancysJobPostAdminPortlet extends MVCPortlet {

	@Reference
	JobPostLocalService _jobPostService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		int postCount = 0;
		List<JobPost> allPosts = new ArrayList<>();
		try {
			allPosts = JobPostLocalServiceUtil.getJobPosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			postCount = allPosts.size();
		} catch (Exception e) {
			e.getMessage();
		}

		renderRequest.setAttribute("jobPost", allPosts);
		renderRequest.setAttribute("postCounts", postCount);

		super.render(renderRequest, renderResponse);
	}

}
