
<%@ include file="../init.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>
<portlet:renderURL var="jobPostFormURL">
	<portlet:param name="mvcRenderCommandName" value="/saveUpdateJobPost" />
</portlet:renderURL>
<%
	List<JobPost> activePosts = (List<JobPost>) request.getAttribute("jobPost");
%>
<div class="container job-applicants-pager">
	<div class="row justify-content-end">
		<div class="col-auto">
			<a href="<%=jobPostFormURL%>" class="btn btn-primary" style="background:#3693C0; border:#3693C0"> Create Job
				Post </a> 
		</div>
	</div>
	<div class="row mt-4">
		<div class="col-12">
			<div class="data-card">
				<div class="header">
					<h5>JOB POST</h5>
				</div>
				<liferay-ui:search-container var="searchContainer" delta="10"
					deltaConfigurable="true" iteratorURL="<%= iteratorURL %>"
					emptyResultsMessage="Oops. There Are No POST To Display"
					total="${ postCounts }">
					<liferay-ui:search-container-results results="<%=ListUtil.subList( activePosts, searchContainer.getStart(), searchContainer.getEnd())%>" />
					<liferay-ui:search-container-row
						className="com.savancys.model.JobPost" keyProperty="jobPostId"
						modelVar="currentPost">
						<liferay-ui:search-container-column-text name="Job Post Name"
							property="jobPostName" orderable="false" />
						<liferay-ui:search-container-column-text name="Published Date"
							orderable="false">
							<fmt:formatDate value="${currentPost.getCreateDate() }"
								pattern="dd/MM/yyyy" />
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Status">
							<span
								class="${ currentPost.isActive() ? 'text-success' : 'text-danger' }">${ currentPost.isActive() ? "Active" : "Inactive" }</span>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Action">
							<liferay-portlet:renderURL var="viewPostURL">
								<portlet:param name="mvcRenderCommandName" value="/viewJobPost" />
								<portlet:param name="jobPostId" value="${currentPost.getJobPostId()}" />
							</liferay-portlet:renderURL>
							<liferay-portlet:renderURL var="updatePostURL">
								<portlet:param name="jobPostId" value="${currentPost.getJobPostId()}" />
								<portlet:param name="mvcRenderCommandName"
									value="/saveUpdateJobPost" />
							</liferay-portlet:renderURL>
							<i class="bi bi-eye"></i>
				
							<a href="${viewPostURL}"><i class="fa fa-eye"></i></a>
							<a href="${updatePostURL}" class="ml-2"><i
								class="fa fa-pencil-alt"></i></a>

						</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator displayStyle="list"
						markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>
