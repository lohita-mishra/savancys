package com.savancys.web.portlet;

import com.savancys.model.JobPost;
import com.savancys.service.JobPostLocalService;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import java.io.IOException;
import java.util.List;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=savancys",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SavancysCareerWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/guests/posts_view.jsp",
		"javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSCAREERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SavancysCareerWebPortlet extends MVCPortlet {
	@Reference
	JobPostLocalService _jobPostService;
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<JobPost> allActiveJobPost = _jobPostService.fetchActiveJobPosts();
		renderRequest.setAttribute("allPosts", allActiveJobPost);
		super.doView(renderRequest, renderResponse);
	}
}