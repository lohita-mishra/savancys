package com.savancys.lca.posting.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.savancys.lca.posting.constants.LCAPostingPortletKeys;
import com.savancys.model.LcaPosting;
import com.savancys.service.LcaPostingLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component( 
		immediate = true, 
		property = { 
				"javax.portlet.name=" + LCAPostingPortletKeys.LCAPOSTING,
				"mvc.command.name=addLcaPost" 
		}, 
		service = MVCActionCommand.class
)
public class AddLcaPostingAction extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(AddLcaPostingAction.class);
	
	@Reference
	private LcaPostingLocalService lcaPostingLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
		String designation = ParamUtil.getString(actionRequest, "designation");
		String oNetCode = ParamUtil.getString(actionRequest, "oNetCode");
		String location = ParamUtil.getString(actionRequest, "location");
		String description = ParamUtil.getString(actionRequest, "description");
		log.info(designation);
		log.info(oNetCode);
		log.info(location);
		log.info(description);
		LcaPosting addLcaPosting = lcaPostingLocalService.addLcaPosting(groupId, designation, description, location, oNetCode);
		log.info(addLcaPosting);
	}

}
