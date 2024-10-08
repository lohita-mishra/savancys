package com.savancys.lca.posting.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.savancys.lca.posting.constants.LCAPostingPortletKeys;
import com.savancys.model.LcaPosting;
import com.savancys.service.LcaPostingLocalServiceUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + LCAPostingPortletKeys.LCAPOSTING,
		"mvc.command.name=/lcaPostingDetail" }, service = MVCRenderCommand.class)
public class LcaPostingDetailRender implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(LcaPostingDetailRender.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("render method called");
		HttpServletRequest originalRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String id = originalRequest.getParameter("id");
		Long lcaPostingId = Long.valueOf(id);
		try {
			LcaPosting lcaPosting = LcaPostingLocalServiceUtil.getLcaPosting(lcaPostingId);
			renderRequest.setAttribute("lcaPosting", lcaPosting);
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		return "/lca_posting_detail.jsp";
	}

}
