<%@page import="com.savancys.model.ContactUs"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="init.jsp"%>

<style>
.tooltip-title {
	max-width: 350px;
	margin-bottom: 0px;
}
</style>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<%
	List<ContactUs> contactUsList = (List<ContactUs>) renderRequest.getAttribute("contactUsList");
%>

<div class="container">
	<div class="row">
	 	<div class="col-12">
		 	<h3>Contact Us</h3>
	 	</div>
		<div class="col-12">
			<liferay-ui:search-container var="searchContainer" delta="10"
				deltaConfigurable="true" iteratorURL="<%= iteratorURL %>"
				emptyResultsMessage="Oops. There Are No POST To Display"
				total="<%=contactUsList.size()%>">
				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(contactUsList, searchContainer.getStart(), searchContainer.getEnd())%>" />
				<liferay-ui:search-container-row
					className=" com.savancys.model.ContactUs" keyProperty="id"
					modelVar="contactUs">
					<liferay-ui:search-container-column-text name="Type"
						property="inquiryType" orderable="false" />
					<liferay-ui:search-container-column-text name="Contact Name"
						orderable="false" property="fullname" />
					<liferay-ui:search-container-column-text name="Street"
						orderable="false" >
						 <p class="tooltip-title">
			                <span class="tooltip-text cus-tooltip" title="${contactUs.street}" >${contactUs.street}</span>
			            </p>
					</liferay-ui:search-container-column-text>	
					<liferay-ui:search-container-column-text name="City"
						property="city" orderable="false" />
						<liferay-ui:search-container-column-text name="Postcode"
						property="postcode" orderable="false" />
					<liferay-ui:search-container-column-text name="Contact Number"
						property="phoneNumber" orderable="false" />
					<liferay-ui:search-container-column-text name="Email"
						property="email" orderable="false" />
					<liferay-ui:search-container-column-text name="Remarks"
						orderable="false">
						 <p class="tooltip-title">
			                <span class="tooltip-text cus-tooltip" title="${contactUs.additionalInfo}" >${contactUs.additionalInfo}</span>
			            </p>
					</liferay-ui:search-container-column-text>	
			
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
			</liferay-ui:search-container>
		</div>
	</div>
</div>

<script>
$( function() {
	$(".cus-tooltip").tooltip();
});
</script>