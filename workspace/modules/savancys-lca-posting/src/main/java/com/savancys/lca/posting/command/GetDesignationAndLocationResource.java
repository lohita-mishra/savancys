package com.savancys.lca.posting.command;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.savancys.lca.posting.constants.LCAPostingPortletKeys;
import com.savancys.model.LcaPosting;
import com.savancys.service.LcaPostingLocalServiceUtil;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + LCAPostingPortletKeys.LCAPOSTING,
		"mvc.command.name=getDesignationAndLocation" }, service = MVCResourceCommand.class)
public class GetDesignationAndLocationResource extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ViewLcaPostingResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("filter");

		String getList = ParamUtil.getString(resourceRequest, "getList");
		log.info("getList: " + getList);

		List<LcaPosting> lcaPostingList = LcaPostingLocalServiceUtil.getLcaPostings(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		Writer writer = resourceResponse.getWriter();

		if ("designation".equalsIgnoreCase(getList)) {
			writeDesignationList(lcaPostingList, writer);
		} else if ("location".equalsIgnoreCase(getList)) {
			writeLocationList(lcaPostingList, resourceRequest, writer);
		}
	}

	private void writeDesignationList(List<LcaPosting> lcaPostingList, Writer writer) throws IOException {
		Set<String> designations = lcaPostingList.stream().map(LcaPosting::getDesignation).collect(Collectors.toSet());
		String designationList = JSONFactoryUtil.looseSerializeDeep(designations);
		writer.write(designationList);
	}

	private void writeLocationList(List<LcaPosting> lcaPostingList, ResourceRequest resourceRequest, Writer writer)
			throws IOException {
		String filterDesignation = ParamUtil.getString(resourceRequest, "filterDesignation");
		log.info("filterDesignation: " + filterDesignation);

		Set<String> locations = lcaPostingList.stream()
				.filter(lcaPosting -> filterDesignation.isEmpty()
						|| filterDesignation.equalsIgnoreCase(lcaPosting.getDesignation()))
				.map(LcaPosting::getLocation).collect(Collectors.toSet());

		String locationList = JSONFactoryUtil.looseSerializeDeep(locations);
		writer.write(locationList);
	}

}
