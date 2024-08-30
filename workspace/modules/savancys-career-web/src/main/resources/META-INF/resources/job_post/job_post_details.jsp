<%@ include file="../init.jsp"%>

<portlet:renderURL var="backPageRender">
	<portlet:param name="mvcPath" value="/job_post/job_posts_view.jsp" />
</portlet:renderURL>

<div class="container box my-3 p-2 ">
	<div class="row p-4 mt-4"
			style="box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px; border-radius: 10px;">
			<div class="col-lg-4  border-right border-info">
				<div class="inner pl-2">
					<h3 class="text-yellow-orange">${jobPost.getJobPostName()}</h3>
					<p>
						<span class="font-weight-bold icon"><i
							class="fa fa-briefcase mr-2"></i></span> <span
							class="static-field font-weight-bold">Experience:</span>
						${jobPost.getExperience()}
					</p>
					<p>
						<span class="font-weight-bold icon"><i
							class="fa fa-graduation-cap mr-2"></i></span> <span
							class="static-field font-weight-bold">Qualification:</span>
						${jobPost.getQualification()}
					</p>
					<p>
						<span class="font-weight-bold icon"><i
							class="fa fa-map-marker mr-2"></i></span> <span
							class="static-field font-weight-bold">Location:</span>
						${jobPost.getLocation()}
					</p>
					<c:if test="${not empty jobPost.getSkills()}">
					<p>
						<span class="font-weight-bold icon"><i
							class="fa fa-cogs mr-2"></i></span> <span
							class=" font-weight-bold static-field">Skills:</span>
						<span class="skills">${jobPost.getSkills()}</span>
					</p>
					</c:if>
					<p>
    					<span class="font-weight-bold icon">&#8377;</span>
    					<span class="static-field font-weight-bold">Salary:</span>
    					${jobPost.getSalary()}
					</p>
				</div>
			</div>
			<div class="col-lg-8 pt-3 ">
				<div class="d-flex flex-column justify-content-between p-3">
					<p class="mb-3 ">${jobPost.getDescription()}</p>
				</div>
			</div>
		</div>
	<a href="<%=backPageRender.toString()%>" class="btn btn-primary float-right mt-3 mb-3">Back</a>
</div>


