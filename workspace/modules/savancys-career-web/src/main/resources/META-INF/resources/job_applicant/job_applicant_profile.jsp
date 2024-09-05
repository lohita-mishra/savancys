<%@ include file="../init.jsp"%>
<style>
.info-card {
  border-radius: 0;
  border: 1px solid #DCD9D9;
  box-shadow: 0px 1px 1px 0px rgba(0, 0, 0, 0.25);
}
.info-card .sub-h {
  font-size: 1rem;
  font-weight: 700;
  padding-left: 0.5rem;
}
.info-card .card-header:first-child {
  padding: 0.6rem 1.6rem;
  border-radius: 0;
  border: 1px solid #DCD9D9;
  background: #F2F0F0;
}
.info-card .card-header:first-child .h4 {
  color: var(--black);
  font-size: 1.5rem;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
}
.info-card .card-header:first-child i {
  border: 1px solid;
  display: inline-flex !important;
  justify-content: center;
  align-items: center;
  padding: 0.3rem;
  border-radius: 6rem;
  aspect-ratio: 1/1;
  color: #B9BBBD;
}
.info-card .card-header:first-child i[onclick] {
  cursor: pointer;
}
.info-card .profile-pic {
  display: flex;
  justify-content: center;
  align-items: center;
}
.info-card table.table {
  width: 100%;
}
.info-card table.table * {
  border: none;
}
.info-card table.table td,
.info-card table.table th {
  padding: 0.5rem;
}
.info-card table.table th {
  color: var(--black);
  font-size: 1rem;
  font-style: normal;
  font-weight: 400;
}
.info-card table.table td {
  color: #727070;
  font-size: 1rem;
  font-style: normal;
  font-weight: 400;
}
.info-card table.table td a {
  color: #357ABD;
  text-decoration-line: underline;
}
.info-card .edu-contianr,
.info-card .exp-contianr {
  padding-left: 1rem;
}
.info-card .edu-contianr .edu,
.info-card .edu-contianr .exp,
.info-card .exp-contianr .edu,
.info-card .exp-contianr .exp {
  position: relative;
  color: #6F6B6B;
}
.info-card .edu-contianr .edu *,
.info-card .edu-contianr .exp *,
.info-card .exp-contianr .edu *,
.info-card .exp-contianr .exp * {
  font-size: 1rem;
}
.info-card .edu-contianr .edu h5,
.info-card .edu-contianr .exp h5,
.info-card .exp-contianr .edu h5,
.info-card .exp-contianr .exp h5 {
  font-weight: 700;
  color: #000;
}
.info-card .edu-contianr .edu:after,
.info-card .edu-contianr .exp:after,
.info-card .exp-contianr .edu:after,
.info-card .exp-contianr .exp:after {
  content: "";
  position: absolute;
  left: 0;
  top: 12px;
  height: 100%;
  width: 3px;
  background: #D9D9D9;
}
.info-card .edu-contianr .edu:before,
.info-card .edu-contianr .exp:before,
.info-card .exp-contianr .edu:before,
.info-card .exp-contianr .exp:before {
  content: "";
  position: absolute;
  left: 0;
  top: 9px;
  height: 1rem;
  width: 1rem;
  background: #D9D9D9;
  border-radius: 5rem;
  transform: translate(-40%, -43%);
}
.info-card .edu-contianr .edu:last-child:after,
.info-card .edu-contianr .exp:last-child:after,
.info-card .exp-contianr .edu:last-child:after,
.info-card .exp-contianr .exp:last-child:after {
  height: calc(100% - 20px);
}

.custom-common-modal .modal-content {
  border-radius: 0;
  border: none;
}
.custom-common-modal .modal-header {
  border: none;
  position: relative;
  padding-left: 2rem;
  padding-right: 2rem;
  align-items: center;
}
.custom-common-modal .modal-header:after {
  content: "";
  position: absolute;
  left: 50%;
  bottom: 0;
  width: calc(100% - 4rem);
  height: 1px;
  transform: translateX(-50%);
  background: #ACA8A8;
}
.custom-common-modal .modal-header .modal-title {
  margin-bottom: 0;
  color: #787676;
  font-size: 1.5rem;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
}
.custom-common-modal .modal-header button.btn-close {
  border: none;
  background: none;
}
.custom-common-modal button.btn.btn-secondary {
  padding: 0.4rem 1.5rem 0.5rem 1.5rem;
  border-radius: 4rem;
  font-size: 1rem;
}
.custom-common-modal button.btn.btn-primary {
  padding: 0.4rem 1.5rem 0.5rem 1.5rem;
  border-radius: 4rem;
  font-size: 1rem;
}
.custom-common-modal .modal-footer {
  border-top: 0px;
  padding-top: 0;
}/*# sourceMappingURL=style.css.map */
</style>
<div class="container p-2">

<div class="card mb-4 info-card">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h4 class="h4 mb-0">Profile Information</h4>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-12 col-md-6 border-right">
                        <div class="row">

                            <!-- Profile Picture Column -->
                            <div class="col-md-4 d-flex flex-column align-items-center justify-content-center mb-4 mb-md-0 ">
                                <div class="profile-pic">
                                  <img alt="user-photo" id="profilePhoto" height="110" width="110" src="https://conferenceoeh.com/wp-content/uploads/profile-pic-dummy.png" style="border-radius : 50%;">
								
                                </div>
                                <div>	<h6 class="mt-3">${jobApplicant.getFirstName()} ${jobApplicant.getLastName()}</h6></div>
                            </div>

                            <!-- Profile Details Column 1 -->
                            <div class="col-md-8 pl-4">
                                <table class="table">
                                    <tbody>
                                       
                                       <tr>
								<th>Applied For:</th>
								<td>${jobPostName}</td>
							</tr>
							<tr>
								<th>Mobile:</th>
								<td>${jobApplicant.getPhoneNumber()}</td>
							</tr>
							<tr>
								<th>Email:</th>
								<td>${jobApplicant.getEmail()}</td>
							</tr>
							<tr>
										<th>Message :</th>
						<td><a href="#" data-toggle="modal"
							data-target="#coverLetterModal">Show</a></td>

							</tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 pl-4">
                        <!-- Profile Details Column 2 -->

                        <table class="table">
                            <tbody>
                               <tr>
								<th>State :</th>
						<td>${jobApplicant.getState()}</td>
							</tr>
							<tr>
								<th>Web Authorization :</th>
						<td>${jobApplicant.getWebAuthorization()}</td>
							</tr>
							<tr>
								<th>Resume :</th>
						<td><a href="${fileUrl}" target="_blank"> <i
								class="fa fa-download"></i>
						</a></td>
							</tr>
							<tr>
							<th>Applied On :</th>
						<td><fmt:formatDate value="${jobApplicant.getCreateDate() }"
								pattern="dd/MM/yyyy" /></td></tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12">
						<table class="border-top">
							<tbody><c:if test="${not empty jobApplicant.getSkill()}">
					<tr>
						<th style="width: 17%;">Skills :</th>
						<td><c:forEach var="skill" items="${jobApplicant.getSkill()}">
								<clay:label displayType="secondary" label="${skill}" />
							</c:forEach></td>
					</tr>
					</c:if>
						</tbody></table>
					</div>
                </div>
            </div>
        </div>

</div>



<div class="modal fade" id="coverLetterModal" tabindex="-1"
	role="dialog" aria-labelledby="coverLetterModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-scrollable">
		<div class="modal-content" style="height: 27rem;">
			<div class="modal-header">
				<h5 class="modal-title" id="coverLetterModalLabel">Cover Letter</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" style="font-size: x-large;">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>

			<div class="modal-body">
				<div class="container">
					<p>${jobApplicant.getMessage()}</p>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function openStatusModal() {
		$('#statusModal').modal('show');
	}
</script>