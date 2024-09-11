<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<@liferay_util["include"] page=top_head_include />
	
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.css" >
	
	<@liferay.css file_name="${css_folder}/custom/stylesheet.css" />
	<@liferay.css file_name="${css_folder}/custom/global.css" />
	<@liferay.css file_name="${css_folder}/custom/style.css" />
	<@liferay.css file_name="${css_folder}/custom/responsive.css" />
	<@liferay.css file_name = "${css_folder}/custom/jquery-ui.css" /> 
 	
</head>

		<#assign roleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")/>
		<#assign userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")/>
		<#assign owner = roleLocalService.getRole(company_id, "Owner")/>
		<#assign site_owner = roleLocalService.getRole(company_id, "Site Owner")/>
		<#assign site_admin = roleLocalService.getRole(company_id, "Administrator")/>
		<#assign isAdmin = userLocalService.hasRoleUser(site_admin.getRoleId(), user_id)/>
		
<#if is_signed_in>
	<body class="${css_class} loggedIn">
<#else>
	<body class="${css_class}">
</#if>
	<@liferay_ui["quick-access"] contentId="#main-content" />
	<@liferay_util["include"] page=body_top_include />
		
	
<div id="wrapper">		
	<#if is_signed_in>
		<@liferay.control_menu />	
	</#if>
    <#include "${full_templates_path}/navigation.ftl">
	<div id="smooth-wrapper">
		<div id="smooth-content">
		<#--<@liferay_portlet["runtime"]
			        defaultPreferences="${journalArticlePreferences}"
			        portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
			        instanceId="4321911" />-->
			<section id="content">
				<#if selectable>
					<@liferay_util["include"] page=content_include />
				<#else>
					${portletDisplay.recycle()} 
					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>
				</#if>
			</section>
			<footer id="footer">
				<#include "${full_templates_path}/footer.ftl" />
			</footer>
		</div>
	 </div>
</div>

	<@liferay_util["include"] page=body_bottom_include />
	<@liferay_util["include"] page=bottom_include />
  	<@liferay.js file_name = "${javascript_folder}/jquery-ui.js" /> 	
	
		<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
	 <#--   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script> -->
	    
	<#--<script src='https://unpkg.com/three@0.138.3/build/three.min.js'></script>
	    <script src='https://unpkg.com/three@0.138.3/examples/js/controls/OrbitControls.js'></script>
	    <script src='https://unpkg.com/three@0.138.3/examples/js/loaders/GLTFLoader.js'></script>-->
	    
		<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.5/gsap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.5/ScrollTrigger.min.js"></script>
    	<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.20.3/TweenMax.min.js'></script>
    	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
	    
	    
	    <script src="${javascript_folder}/splitText3.js"></script>
	    <script src="${javascript_folder}/script.js"></script>
	    
	    <#--<script type="module" src="${javascript_folder}/threeModal.js"></script>
	    <script src="${javascript_folder}/scrollSmooth.js"></script>-->
    	<#--<script src="${javascript_folder}/custom_script.js"></script>-->
	    	
</body>
</html>