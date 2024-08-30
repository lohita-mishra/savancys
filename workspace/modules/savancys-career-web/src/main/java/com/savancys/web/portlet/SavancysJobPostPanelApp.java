package com.savancys.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.savancys.web.constants.SavancysCareerWebPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=0",
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION
	    },

	    service = PanelApp.class)
public class SavancysJobPostPanelApp extends BasePanelApp  {


	@Reference(
			target = "(javax.portlet.name=" + SavancysCareerWebPortletKeys.SAVANCYSJOBPOSTADMINWEB + ")",unbind = "-"
		)
	private Portlet _portlet;
		@Override
		public Portlet getPortlet() {
			return _portlet;
		}
	

	@Override
	public String getPortletId() {
		 return SavancysCareerWebPortletKeys.SAVANCYSJOBPOSTADMINWEB;
		 
	}

}
