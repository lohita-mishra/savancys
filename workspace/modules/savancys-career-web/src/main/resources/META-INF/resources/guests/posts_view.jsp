<%@ include file="../init.jsp"%>

<style>
.inactive-container {
	background-color: #f8f9fa;
}

.toggle.ios, .toggle-on.ios, .toggle-off.ios {
	border-radius: 20rem;
}

.toggle.ios .toggle-handle {
	border-radius: 20rem;
}
</style>
<div class="container box my-3 p-3">
	
 <c:if test="${empty allPosts}">
        <div >
            <h5 class="text-center mx-auto col-12 col-md-10 col-lg-9 " >"Our team is complete for now, but we are always growing. Be sure to revisit our careers page for future opportunities"</h5>
        </div>
    </c:if>
	<c:forEach items="${allPosts}" var="jobPost">
		<portlet:renderURL var="applyJobURL">
			<portlet:param name="jobPostId" value="${jobPost.getJobPostId()}" />
			<portlet:param name="mvcRenderCommandName" value="/jobApplicationForm" />
		</portlet:renderURL>

		<div class="row mb-4 p-2 pt-3 mb-3 "
			style="box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px; border-radius: 10px;">
			<div class="col-lg-4  border-right border-info p-2">

				<div class="inner pl-2">
					<h4 class="text-yellow-orange">${jobPost.getJobPostName()}</h4>
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
				
				</div>
			</div>
			<div class="col-lg-8 pt-3 ">
				<div class="d-flex flex-column justify-content-between p-2">
					<p class="mb-3 ">${jobPost.getDescription()}</p>

					<div class="d-flex justify-content-end align-items-center">

						<div class="mr-2">

							<a class="btn bg-yellow-orange btn-info mr-2"
								data-senna-off="true" href="<%=applyJobURL%>">Apply Now</a>

						</div>
					</div>
				</div>
			</div>


		</div>
	</c:forEach>
</div>