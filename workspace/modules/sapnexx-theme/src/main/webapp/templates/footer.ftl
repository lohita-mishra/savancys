<div class="container">
	<div class="row">
		<div class="col-3">
			<@liferay_portlet["runtime"]
			        defaultPreferences="${journalArticlePreferences}"
			        portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
			        instanceId="42821" /> 
        </div>
        <div class="col footer_nav">
        	<div class="widget-container">
        		<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
				<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="footer_main_nav"/>
			</div>
		</div>
        
        <div class="col-4">
        	<@liferay_portlet["runtime"]
                defaultPreferences="${journalArticlePreferences}"
                portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
                instanceId="42531" />
        </div>
	</div>
	
	<div class="row border-top-dashed mt-5">
        <div class="copyright-sec col-12 d-flex justify-content-center align-items-center">
            <p class="copyright-text mb-0 text-white">&copy; 2024 SAPNEXX. All rights reserved </p>
			
        	<#assign preferencesMap={"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="footer_right_nav" />
        </div>
	</div> 
		
</div>