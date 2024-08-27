<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<@liferay_util["include"] page=top_head_include />
	
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Covered+By+Your+Grace&family=Manrope:wght@200..800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.css" />
	
	<@liferay.css file_name="${css_folder}/custom/stylesheet.css" />
	<@liferay.css file_name="${css_folder}/custom/global.css" />
	<@liferay.css file_name="${css_folder}/custom/style.css" />
	<@liferay.css file_name="${css_folder}/custom/responsive.css" />

</head>

<body class="${css_class}">

	<@liferay_ui["quick-access"] contentId="#main-content" />
	<@liferay_util["include"] page=body_top_include />

<div class="d-flex flex-column flex-fill min-vh-100" id="wrapper">
	<#if is_signed_in>
		<@liferay.control_menu />	
	</#if>

	<#--<div class="d-flex flex-column flex-fill position-relative" >-->
		<header class="site_header">	
			<#include "${full_templates_path}/navMenu.ftl">	
		</header>
	
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
	
		<footer class="site_footer">
			<#include "${full_templates_path}/footer.ftl" />
		</footer>
	
	<#--</div>-->
</div>

	<@liferay_util["include"] page=body_bottom_include />
	<@liferay_util["include"] page=bottom_include />
		
		<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	    <#--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>-->
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
	
		<script src="${javascript_folder}/custom_script.js"></script>
		<script src="${javascript_folder}/script.js"></script>
		
</body>
</html>