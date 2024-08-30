<%@ include file="../init.jsp"%>

<style>
textarea {
	min-height: 12 rem;
}
</style>

<portlet:actionURL name="saveJobPost" var="saveJobPostURL">
</portlet:actionURL>

<portlet:renderURL var="backPageRender">
  <portlet:param name="mvcPath" value="/job_post/job_posts_view.jsp" />
</portlet:renderURL>

<div class="container">
	<div class=" border data-card">
		<div class="header">
			<h5>Job Post</h5>
		</div>
		<aui:form action="${saveJobPostURL}" method="post">
                <aui:input name="jobPostId" type="hidden" value="${jobPost.jobPostId}" />
			<div class="row m-2">
				<div class="col-md-6">
					<aui:input name="jobPostName" label="Post Name" value="${jobPost.jobPostName}">
						<aui:validator name="required" />
						<aui:validator name="custom" 
							errorMessage="Only alphabets are allowed.">
	                    function(val, fieldNode, ruleValue) {
	                        if (val.charAt(0) == ' ') {
	                            return false;
	                        }
	                        var regex = /^[a-zA-Z\s]+$/;
	                        return regex.test(val);
	                    }
	                </aui:validator>
					</aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="experience" label="Experience" value="${ jobPost.experience }">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="qualification" label="Qualification" value="${ jobPost.qualification }">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="skills" id="skillsInput" label="Skills" value="${ jobPost.skills }"
						placeholder="Java,Liferay,...">
					 	<aui:validator name="maxLength">250</aui:validator>
					 </aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="salary" label="Salary" value="${ jobPost.salary }">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="location" label="Location" value="${ jobPost.location }">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="col-md-12">
					<aui:input type="checkbox" name="activated" checked="${ jobPost.active}" label="Active/In-active"  />
				</div>
				<div class="col-12 mt-2 ">
					<aui:input name="description" label="Description" type="textarea" value="${ jobPost.description }"
						 class="description-textarea">
						<aui:validator errorMessage="Please, leave us a message." name="required" />
                        <aui:validator name="maxLength">4000</aui:validator>
					</aui:input>
				</div>
				<a href="<%=backPageRender.toString()%>"
					class="btn btn-primary float-right">Back</a>
				<button type="submit" class="btn btn-primary ml-auto mr-2">
                	${jobPost != null ? "Update" : "Submit"}
            	</button>
			</div>
		</aui:form>
	</div>
</div>