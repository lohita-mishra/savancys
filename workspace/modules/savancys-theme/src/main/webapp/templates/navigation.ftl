<header class="site_heder py-2">
	<div class="container position-relative">
        <div class="row justify-content-between align-items-center">
        
            <a class="logo-container ${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<img class="nav-img" alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
			</a>
			
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id=""/>
            
	        <#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="top_right_nav"/>
            
            <div class="trigger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
        </div>
	</div>
</header>