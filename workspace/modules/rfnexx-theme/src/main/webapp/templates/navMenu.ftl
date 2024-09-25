<#include init />

<div class="container position-relative z-index-1">
	<div class="row m-0">
	
		<div class="logo-container">	
			<a class="site_logo" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<img class="w-100" alt="${logo_description}" src="${site_logo}" />
			</a>
		</div>
		<nav class="d-flex align-items-center justify-content-center">		
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="top_navigation"/>
		</nav>
		
		<div class="social-media">
			<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="social_media"/>
		</div>
        <div class="trigger d-flex d-lg-none">
          <div class="trigger-menu">
            <i class="fa-solid fa-bars"></i>            
          </div>
        </div>
	</div>
</div>