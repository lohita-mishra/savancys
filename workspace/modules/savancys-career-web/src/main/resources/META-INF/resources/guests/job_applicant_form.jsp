<%@ include file="../init.jsp"%>

<portlet:actionURL name="jobApplicationForm" var="jobApplicationFormURL" />
<portlet:resourceURL id="getJobPostSkill" var="getSkillsURL" />

<portlet:renderURL var="backPageRender">
	<portlet:param name="mvcRenderCommandName" value="${backRedirectURL}" />
	<portlet:param name="jobApplicantId"
		value="${jobApplicant.getJobApplicantId()}" />
</portlet:renderURL>

<style>
:root { -
	-theme-blue: dodgerblue;
}

.btn.btn-secondary {
	background: #333;
	border-color: #333;
}

#skillsContainer label {
	display: inline-block;
	margin-right: 1rem;
}

.custom-checkbox {
	margin-right: 15px;
	margin-bottom: 10px;
}

@media ( max-width : 576px) {
	.custom-checkbox {
		margin-right: 0;
		margin-bottom: 15px;
	}
}

label.custom-checkbox {
	align-items: flex-start;
	column-gap: 8px;
}

label.custom-checkbox .input-checkbox-wrapper {
	height: 22px;
}

textarea {
	min-height: 12rem;
}

.attachment-icon {
	font-size: 24px;
	cursor: pointer;
}

.checkbox-span {
	margin-left: 10px;
	margin-bottom: 10px;
	margin-top: -1.5px;
}

.heading-select .form-group {
	margin-bottom: 0px;
}

.heading-select select {
	background-color: rgba(255, 255, 255, 0.46);
	border: 1px solid rgba(255, 255, 255, 0.26);
	color: var(- -black);
	font-size: 1.5rem;
	font-weight: 700;
	padding: 0 0.5rem;
	margin-left: 0.5rem;
	width: 100%;
	text-transform: capitalize;
	box-shadow: 0px 1px 19px -6px rgba(6, 0, 60, 0.19);
}

.heading-select select option {
	font-size: 1rem !important;
}

.btn.btn-primary {
	border-radius: 3rem;
	padding-left: 1.2rem;
	padding-right: 1.2rem;
	background: var(- -theme-blue) important!;
	border-color: var(- -theme-blue) important!;
}

.d-none {
	display: none;
}

.attachment-icon {
	cursor: pointer;
}

.error {
	color: red;
	font-size: 0.9em;
}

.required-indicator {
	color: #ffc107;
}
</style>
<div class="container mb-3">
	<aui:form action="<%=jobApplicationFormURL%>" method="post" name="fm"
		cssClass="">
		<div class="border data-card p-3 mb-3 mt-4">
			<div class="header error-size">
				<h4 class="d-flex mb-3 align-items-center heading-select">
					<liferay-ui:message key="sys-career-guest-job-app-title-application-for"/> ${jobPost.jobPostName}</h4>
			</div>
			<aui:input name="jobPostId" type="hidden"
				value="${jobPost.jobPostId}" />
			<div class="row">
				<div class="col-md-6">
					<aui:input label="sys-career-guest-job-app-label-first-name" name="firstName">
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-first-name-req" />
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

					<aui:input label="sys-career-guest-job-app-label-phone-number" name="phoneNumber"
						value="${jobApplicant.getPhoneNumber()}">
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-phone-number-req" />
						<aui:validator name="number" />
					</aui:input>

					<aui:select id="jobType" name="jobType" label="sys-career-guest-job-app-label-job-type">
						<aui:option><liferay-ui:message key="common-select"/></aui:option>
						<aui:option value="fullTime">Full Time</aui:option>
						<aui:option value="Part Time">Part Time</aui:option>
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-job-type-req" />
					</aui:select>
				</div>

				<div class="col-md-6">
					<aui:input label="sys-career-guest-job-app-label-last-name" name="lastName"
						value="${jobApplicant.getLastName()}">
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-last-name-req" />
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

					<aui:input label="sys-career-guest-job-app-label-email" name="email"
						value="${jobApplicant.getEmail()}">
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-email-req"/>
						<aui:validator name="email" />
					</aui:input>

					<aui:input label="sys-career-guest-job-app-label-state" name="state"
						value="${jobApplicant.getState()}">
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-state-req"/>
					</aui:input>
				</div>
			</div>
			<c:if test="${!skillsList.isEmpty()}">
				<div class="row ml-2">
					<label><liferay-ui:message key="sys-career-guest-job-app-label-skill"/></label>
				</div>

				<div class="row ml-2" id="skillsContainer">

					<c:forEach items="${skillsList}" var="skill">
						<div class="col-md-3 d-flex mt-2">
							<label
								class="custom-checkbox d-flex justify-content-space-between">
								<input type="checkbox" name="<portlet:namespace/>skill"
								id="<portlet:namespace/>skill" value="${skill}"
								<c:if test="${selectedSkillsList.contains(skill)}">
				                       checked
				                   </c:if>>
								<span class="checkbox-span">${skill}</span>
							</label>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<div class="row ">
				<div class="col-md-12 mt-2">
					<aui:input label="sys-career-guest-job-app-label-web-auth" name="webAuthorization">
						<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-web-auth-req"/>
					</aui:input>
				</div>

			</div>

			<div class="row mt-3">
				<div class="col-md-12">
					<div class="form-group">
						<aui:input type="textarea" name="message" label="sys-career-guest-job-app-label-your-message"
							id="coverLetter">
							<aui:validator name="maxLength">500</aui:validator>
						</aui:input>

					</div>
				</div>
			</div>

			<div class="row mt-3">
				<div class="col-md-12 d-flex align-items-center">
					<label for="<portlet:namespace/>file" class="attachment-icon mr-2"
						onclick="document.getElementById('<portlet:namespace/>resumeInput').click();">
						<liferay-ui:message key="sys-career-guest-job-app-label-upload-resume"/><i class="fas fa-paperclip"></i><span
						class="required-indicator">*</span>
					</label>
					<aui:input type="file" id="resumeInput" name="file"
						cssClass="d-none" label="" value="${resume.title}" accept=".pdf">
						<c:if test="${empty resume.title}">
							<aui:validator name="required" errorMessage="sys-career-guest-job-app-error-upload-file-req"/>
						</c:if>
					</aui:input>
					<p id="fileNameDisplay" class="mt-1 ml-2">${resume.title}</p>
					<p id="errorMessage" class="error d-none"><liferay-ui:message key="sys-career-guest-job-app-error-upload-file-req"/>/p>
				</div>
			</div>
		</div>

		<aui:button-row>
			<aui:button cssClass="float-left btn btn-primary mb-3 " style="background:#3693C0; border:#3693C0"
				href="<%=backPageRender.toString()%>" value="common-back-button"></aui:button>
			<aui:button type="submit" cssClass="d-block ml-auto" style="background:#3693C0; border:#3693C0" value="common-submit-button"></aui:button>
		</aui:button-row>
	</aui:form>
</div>


<script>
	$(document).ready(function() {
		$('#<portlet:namespace/>resumeInput').change(function() {
			$('#fileNameDisplay').empty();
			var fileName = $(this).val().split('\\').pop();
			$('#fileNameDisplay').text(fileName);
		});
			
	});
		
	<%-- $('#<portlet:namespace/>jobPost').change(function() {
		const jobPostId = $(this).val(); 				
		$.ajax({
			type : "GET",
			url : "<%=getSkillsURL.toString()%>&<portlet:namespace/>jobPostId=" + jobPostId,
			contentType : "application/json",
			success : function(skills) {
				$('#skillsContainer').empty();
				if(skills != ""){
					$(".skills").removeClass('d-none');
					const skillsContainer = $('#skillsContainer');
					$.each(JSON.parse(skills), function(index, skill) {
					 let skillContent = `<div class="col-md-3 d-flex mt-2">
						<label
							class="custom-checkbox d-flex justify-content-space-between">
							<input type="checkbox" name="<portlet:namespace/>skill"
							id="<portlet:namespace/>skill" value="`+skill+`"> <span
							class="checkbox-span">`+skill+`</span>
						</label>
					</div>`;
	
					skillsContainer.append(skillContent);
				});
				}else{
					$(".skills").addClass('d-none');
				}
			},
			error : function() {
				 console.error('Error retrieving skills.');
			}
		});
	}); --%>

</script>