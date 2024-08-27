<#include init />

<div class="container">
	<div class="row">
		<div class="logo-container">	
			<a class="logo" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<img class="nav-img" alt="${logo_description}" src="${site_logo}" />
			</a>
		</div>
		<nav class="d-flex align-items-center">		
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="navigation"/>
		</nav>
	</div>
</div>