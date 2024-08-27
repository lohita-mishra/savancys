<#include init />
<nav class="navbar navbar-expand-lg navbar-light px-0 d-flex justify-content-between">
	<#--<a class="navbar-brand" href="${site_default_url}">
		<img class="nav-img" src="${images_folder}/custom/savancys-logo.png" alt="savancys"> 
	</a>-->
	
	<a class="navbar-brand ${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
		<img class="nav-img" alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
	</a>
	
	
	<div class="flex-grow-1">
		<ul class="navbar-nav">			
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="top_left_nav"/>
		</ul>
	</div>
	
<#--<div class="pr-2">
		<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
		<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="top_right_nav"/>
	</div>-->
</nav>