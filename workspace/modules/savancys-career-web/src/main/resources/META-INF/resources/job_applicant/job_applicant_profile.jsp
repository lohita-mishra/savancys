<%@ include file="../init.jsp"%>
<style>
</style>
<div class="container p-2">
	<div class="profile border data-card">
		<div class="header">
			<h5 >${jobApplicant.getFirstName()} ${jobApplicant.getLastName()}</h5>
		</div>


		<div class="row">
			<div class="col-md-6">
				<table>
					<tr>
						<th>Applied For :</th>
						<td>${jobPostName}</td>
					</tr>
					<tr>
						<th>Mobile :</th>
						<td>${jobApplicant.getPhoneNumber()}</td>
					</tr>

					<tr>
						<th>Message :</th>
						<td><a href="#" data-toggle="modal"
							data-target="#coverLetterModal">Show</a></td>
					</tr>
				</table>

			</div>
			<div class="col-md-6">
				<table>
					<tr>
						<th>Email :</th>
						<td>${jobApplicant.getEmail()}</td>
					</tr>


					<tr>
						<th>State :</th>
						<td>${jobApplicant.getState()}</td>
					</tr>
											<tr>
						<th>Resume :</th>
						<td><a href="${fileUrl}" target="_blank"> <i
								class="fa fa-download"></i>
						</a></td>
					</tr>
				</table>
			</div>
			<div class="col-md-12">
				<table class="border-top">
				<tr>
						<th>Web Authorization :</th>
						<td>${jobApplicant.getWebAuthorization()}</td>
					</tr>
				<c:if test="${jobApplicant.getSkill()}">
					<tr>
						<th style="width: 17%;">Skills :</th>
						<td><c:forEach var="skill" items="${jobApplicant.getSkill()}">
								<clay:label displayType="secondary" label="${skill}" />
							</c:forEach></td>
					</tr>
					</c:if>
				</table>
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