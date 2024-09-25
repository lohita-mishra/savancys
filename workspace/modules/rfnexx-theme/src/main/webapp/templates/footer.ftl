<div class="container">
	<div class="row">
	
		<div class="col-sm-12 col-md-6 col-lg-4 mb-5 mb-lg-0">
			<@liferay_portlet["runtime"]
			        defaultPreferences="${journalArticlePreferences}"
			        portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
			        instanceId="44469" /> 
			<#assign preferencesMap={"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="socialmedia_nav" />
                
        </div>
        <div class="col-sm-12 col-md-6 col-lg-4 mb-5 mb-lg-0">
    		<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="footer_main_nav"/>
		</div>
        
        <div class="col-sm-12 col-md-6 col-lg-4 mb-5 mb-lg-0">
        	<@liferay_portlet["runtime"]
                defaultPreferences="${journalArticlePreferences}"
                portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
                instanceId="44486" />
        </div>
        
	</div>
</div>

<div class="copyright">
	<div class="container">
		<div class="row">
            <div class="col-12 col-md-6 d-flex justify-content-center justify-content-md-start align-items-center">
                <@liferay_portlet["runtime"]
	                defaultPreferences="${journalArticlePreferences}"
	                portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
	                instanceId="44499" />
            </div>
            <div class="col-12 col-md-6 d-flex justify-content-center justify-content-md-end align-items-center">
                <#assign preferencesMap={"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
				<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="terms_privacy" />
            </div>
        </div>
	</div>
</div> 