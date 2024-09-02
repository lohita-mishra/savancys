<footer class="site_footer">

	<div class="container">
		<div class="row m-0 mb-3">
			<div class="footer-widget intro d-flex flex-column">
				<@liferay_portlet["runtime"]
			        defaultPreferences="${journalArticlePreferences}"
			        portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
			        instanceId="43219" />  
	            <div class="social">
	                <#assign preferencesMap={"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
					<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="SocialMedia" />
	            </div>
			</div>
			<div class="flex-grow-1">
				<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
				<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="footer_main_nav"/>
			</div>
		</div>
	</div>
			
	<div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-12 col-sm-6 d-flex justify-content-start mb-3 mb-md-0">
                    <p class="copyright-text mb-0 text-white">&copy; 2024 Savancys. All Rights Reserved</p>
                </div>
                <div class="col-12 col-sm-6 d-flex justify-content-md-end justify-content-start">
	            	<#assign preferencesMap={"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
	    			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="footer_right_nav" />
                </div>
            </div>
        </div>
	</div>
		
</footer>