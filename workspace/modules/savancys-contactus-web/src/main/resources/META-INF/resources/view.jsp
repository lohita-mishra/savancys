<%@ include file="init.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/css/intlTelInput.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/intlTelInput.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%-- 
<portlet:actionURL name="addContactUs" var="actionURL" /> --%>

<portlet:resourceURL id="addContactUs" var="addContactUsURL" />


<style>
.submit-btn {
	background: #3185BA;
	border-radius: 32px;
	color: #FFFFFF;
	border: none;
	width: 12rem;
	margin-top: 1.5rem;
}

.submit-btn:hover {
	background: #3185BA;
}

.web-content {
	margin: -1px;
}

.portlet-header {
	display: none;
}

.container {
	padding: 0px;
}
</style>


<div class="container-fluid p-0">
	<div class="row m-0">
		<div class="col-md-6 web-content p-0">
			<liferay-portlet:runtime instanceId="contact_us"
				portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
		</div>

		<div class="col-md-5 contact-us-form ml-4">
			<div class="container mt-4">
				<aui:form action="#" method="post" name="contactUsForm">
					<div class="row">
						<div class="col-md-12">
							<aui:select name="inquiryType" label="Inquiry Type"
								id="inquiryType">
								<aui:option value="">Select</aui:option>
								<aui:option value="Gerenal Inquiry">Gerenal Inquiry</aui:option>
							</aui:select>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="firstName" label="First Name"
								id="firstName">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="lastName" label="Last Name"
								id="lastName">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="tel" name="phoneNumber" label="Phone Number"
								id="phoneNumber">
								<aui:validator name="required" />
								<aui:validator name="number" />
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="email" label="Email Id" id="email">
								<aui:validator name="required" />
								<aui:validator name="email" />
							</aui:input>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<aui:input type="text" name="companyName" label="Company Name"
								id="companyName">
								<aui:validator name="required"
									errorMessage="The Company Name field is required." />
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="country" label="Country"
								id="country">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<aui:input type="textarea" name="additionalInfo"
								label="Additional Information" id="additionalInfo">
								<aui:validator name="maxLength">500</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-12">
							<input type="checkbox" name="termsAndConditions"
								id="termsAndConditions" required="required"> <label>I
								agree to <span class="text-primary text-decoration-underline">Terms
									& Conditions</span> of Savancys.
							</label>

						</div>
					</div>
					<aui:button type="submit" cssClass="submit-btn"
						value="Request a callback" />
				</aui:form>
			</div>
		</div>
	</div>
</div>

<script>
	/* const phoneNumberField = document.querySelector("#<portlet:namespace/>phoneNumber");
	const phoneNumberInput = window.intlTelInput(
					phoneNumberField,
					{
						initialCountry : "us",
						separateDialCode : true,
						utilsScript : "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/utils.js",
					}); */
					
			window.intlTelInput(
					$("#<portlet:namespace/>phoneNumber"),
					{
						initialCountry : "en",
						separateDialCode : true,
						utilsScript : "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/utils.js",
					});

	$(".iti").addClass("w-100");
	
	function validateForm(contactUsForm){
		var liferayForm = Liferay.Form.get(contactUsForm);
			if(liferayForm){
			 var validator = liferayForm.formValidator;
			 validator.validate();
			 var hasErrors = validator.hasErrors();
			 if(hasErrors){
				 validator.focusInvalidField();
				 return false;
			 }
			}
			return true;
		}
	
	function submitSendFileForm(){
		if(validateForm('<portlet:namespace/>contactUsForm')){
		   	AUI().use('aui-io-request','aui-base','io', function(A){
			 var form = A.one("#<portlet:namespace/>contactUsForm");
			 
		        A.io.request('<%=addContactUsURL.toString()%>'), {
					method : 'post',
					form : {
						id : form
					},
					on : {
						success : function() {
							swal({
								text : this.get('responseData'),
							})
							setTimeout(pageReload, 1500);
						}
					}
		        }
			});

		} else {
			return false;
		}
	}
</script>