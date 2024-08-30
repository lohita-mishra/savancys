<%@ include file="../init.jsp"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<portlet:renderURL var="filterByPostURL">
 <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<style>
#<portlet:namespace />fm {
	display: flex;
}
.calendar-icon-css {
	position: absolute;
	right: 26px;
	margin-top: 36px;
	z-index: 1;
}
</style>
<%
List<JobApplicantDTO> jobApplicantlist = (List<JobApplicantDTO>)request.getAttribute("jobApplicantlist");
%>


<div class="container job-applicants-pager">
    <div class="row">
        <div class="col-12">
            <h3 class="text">Job Applications</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-12 p-0">
            <aui:form id="filterForm" action="<%=filterByPostURL%>" method="post" class="form row">
                <div class="form-group col-md-3">
                    <aui:input type="text" label="Start Date" name="startDate" value="${startDate}"
                        placeholder="dd/mm/yyyy" autocomplete="off">
                        <aui:icon useDialog="true" markupView="lexicon" cssClass="calendar-icon calendar-icon-css"
                            image="calendar" />
                    </aui:input>
                </div>
                <div class="form-group col-md-3">
                    <aui:input type="text" label="End Date" name="endDate" value="${endDate}" placeholder="dd/mm/yyyy"
                        autocomplete="off">
                        <aui:icon useDialog="true" markupView="lexicon" cssClass="calendar-icon calendar-icon-css"
                            image="calendar" />
                        <aui:validator name="custom" errorMessage="End Date cannot be before Start Date.">
							 function(value, fieldNode, ruleValue) {
								    var endDateValue = A.one('[name="<portlet:namespace />endDate"]').val();
								    var startDateValue = A.one('[name="<portlet:namespace />startDate"]').val();
								    if (startDateValue && value) {
								        var startDateParts = startDateValue.split('/');
								        var endDateParts = value.split('/');
								        var startDate = new Date(startDateParts[2], startDateParts[1] - 1, startDateParts[0]);
								        var endDate = new Date(endDateParts[2], endDateParts[1] - 1, endDateParts[0]);
								
								        if (endDate.getFullYear() > startDate.getFullYear() ||
								            (endDate.getFullYear() === startDate.getFullYear() && endDate.getMonth() >
								                startDate.getMonth()) ||
								            (endDate.getFullYear() === startDate.getFullYear() && endDate.getMonth() ===
								                startDate.getMonth() && endDate.getDate() >= startDate.getDate())) {
								            return true;
								        } else {
								            return false;
								        }
								    }
								    return true;
								}
                        </aui:validator>
                    </aui:input>
                </div>
                <div class="form-group col-md-3">
					<aui:select class="form-control" name="postFilter"
						label="Job Post">
						<aui:option value="">Select Post</aui:option>
						<c:forEach items="${activeJobPosts}" var="activeJobPost">
							<aui:option value="${activeJobPost.jobPostId}">
          							  ${activeJobPost.jobPostName}
     					   </aui:option>
						</c:forEach>
					</aui:select>
				</div>
				
                    <div class="form-group col-md-3 mt-2 d-flex align-items-center justify-content-between">
                    <button type="submit" class="btn btn-primary mr-2 border-0">Filter</button>
                  
                </div>
            </aui:form>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-12 liferay-table">
			<liferay-ui:search-container var="searchContainer" delta="10"
				deltaConfigurable="true" iteratorURL="<%=iteratorURL%>"
				emptyResultsMessage="Oops. There Are No Job Application To Display"
				total="${String.valueOf(listSize)}">
				<liferay-ui:search-container-results
                        results="<%=ListUtil.subList(jobApplicantlist, searchContainer.getStart(), searchContainer.getEnd())%>" />
				<liferay-ui:search-container-row
					className="com.savancys.model.JobApplicant"
					keyProperty="id" modelVar="currentJobApplication">
					
					   <liferay-ui:search-container-column-text name="Name">
				        <% 
				            String applicantName = currentJobApplication.getFirstName() + " " + currentJobApplication.getLastName(); 
				        %>
				        <%= applicantName %>
				    </liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Phone Number" property="phoneNumber" />
					<liferay-ui:search-container-column-text name="Job Post">
					 <%
                        long jobPostId = currentJobApplication.getJobPostId();
					 JobPost jobPost = JobPostLocalServiceUtil.getJobPost(jobPostId);
                        String jobPostName = jobPost != null ? jobPost.getJobPostName() : "N/A";
                    %>
                    <%= jobPostName %>
					
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="Applied On">
					<fmt:formatDate value="${currentJobApplication.getCreateDate() }"
								pattern="dd/MM/yyyy" />
					
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Action">
						<portlet:renderURL var="jobApplicantViewURL">
							<portlet:param name="mvcRenderCommandName"
								value="/viewJobApplicantDetails" />
							<portlet:param name="jobApplicantId"
								value="${currentJobApplication.getJobApplicantID() }" />
						</portlet:renderURL>
						<a href="<%=jobApplicantViewURL%>"><i class="fa fa-eye"></i></a>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
			</liferay-ui:search-container>
		</div>
    </div>
</div>
<aui:script>
    AUI().use('aui-datepicker', function(A) {
        var datePicker = new A.DatePicker({
            trigger: '#<portlet:namespace />startDate',
            mask: '%d/%m/%Y',
            popover: {
                zIndex: 2
            },
            calendar: {
                selectionMode: 'single',
                dateFormat: '%d/%m/%Y'
            }
        });
    });
    
    AUI().use('aui-datepicker', function(A) {
        var datePicker = new A.DatePicker({
            trigger: '#<portlet:namespace />endDate',
            mask: '%d/%m/%Y',
            popover: {
                zIndex: 2
            },
            calendar: {
                selectionMode: 'single',
                dateFormat: '%d/%m/%Y'
            }
        });
    });
</aui:script>