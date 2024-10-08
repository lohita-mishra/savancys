package com.savancys.lca.posting.command;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.savancys.lca.posting.constants.LCAPostingPortletKeys;
import com.savancys.model.LcaPosting;
import com.savancys.service.LcaPostingLocalServiceUtil;

import java.io.Writer;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + LCAPostingPortletKeys.LCAPOSTING,
		"mvc.command.name=lcaPostings" }, service = MVCResourceCommand.class)
public class ViewLcaPostingResource extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewLcaPostingResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("serve resource");
		List<LcaPosting> lcaPostingList = LcaPostingLocalServiceUtil.getLcaPostings(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		Writer wtr = resourceResponse.getWriter();
		wtr.write(lcaPostingList.toString());

	}
}