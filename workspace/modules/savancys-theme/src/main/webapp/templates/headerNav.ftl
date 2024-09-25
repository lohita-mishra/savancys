<#include init />
<header class="site_heder py-2">
    <div class="container">
        <div class="row align-items-center">
            <a class="logo-container" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<img alt="${logo_description}" height="45" src="${site_logo}" width="100" />
			</a>
            <nav>
                <#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
				<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap) instance_id="top_left_nav"/>
            </nav> 
        </div>
    </div>
</header>