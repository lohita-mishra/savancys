<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/css/intlTelInput.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/intlTelInput.min.js"></script>

<portlet:resourceURL id="addContactUs" var="addContactUsURL" />
<portlet:resourceURL id="captcha" var="captchaResourceURL"/>

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
   /*  min-height: 53rem; */
}
.portlet-header {
	display: none;
}

.container {
	padding: 0px;
}	

.has-error .iti__selected-flag{
	height: 52%;
}

.iti--allow-dropdown .iti__flag-container:hover {
    cursor: context-menu;
}

.iti__arrow, .iti__country-list{
	display:none;
} 

.termsAndConditions label{
	display:block !important;
}

.success-div{
  height:36rem;
  text-align: center;
  padding-top: 50px;
}
</style>


<div class="container-fluid p-0">
	<div class="row m-0">
		<div class="col-lg-6 web-content p-0">
			<liferay-portlet:runtime instanceId="contact_us"
				portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
		</div>

		<div class="col-lg-5 contact-us-form ml-4 d-flex align-items-stretch">
			<div class="container mt-4">
				<aui:form name="contactUsForm" id="contactUsForm" autocomplete="off">
					<div class="row">
						<div class="col-md-12">
							<aui:select name="inquiryType" label="sys-contactus-label-inquiry-type"
								id="inquiryType">
								<aui:option value=""><liferay-ui:message key="common-select"/></aui:option>
								<aui:option value='<liferay-ui:message key="sys-contactus-label-gerenal-inquiry"/>'>
									<liferay-ui:message key="sys-contactus-label-gerenal-inquiry"/>
								</aui:option>
							</aui:select>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="firstName" label="sys-contactus-label-first-name"
								id="firstName">
								<aui:validator name="required" errorMessage="sys-contactus-error-first-name-required" />
								<aui:validator name="custom" errorMessage="sys-contactus-error-first-name-invalid">
									function(val) {
									    var regex = /^[a-zA-Z\s]*$/; 
									    return regex.test(val);  
									}
								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="lastName" label="sys-contactus-label-last-name"
								id="lastName">
								<aui:validator name="required" errorMessage="sys-contactus-error-last-name-required" />
								<aui:validator name="alpha"/><aui:validator name="custom" errorMessage="sys-contactus-error-last-name-invalid">
									function(val) {
									    var regex = /^[a-zA-Z\s]*$/; 
									    return regex.test(val);  
									}
								</aui:validator>
								
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="tel" name="phoneNumber" label="sys-contactus-label-phone-number"
								id="phoneNumber">
								<aui:validator name="required" errorMessage="sys-contactus-error-phone-number-required" />
								<aui:validator name="custom" errorMessage="sys-contactus-error-phone-number-invalid">
									function(val) {
									    var regex = /^\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/; 
									    return regex.test(val);  
									}
								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="email" label="sys-contactus-label-email" id="email">
								<aui:validator name="required" errorMessage="sys-contactus-error-email-required"/>
								<aui:validator name="email" />
							</aui:input>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<aui:input type="text" name="companyName" label="sys-contactus-label-company-name"
								id="companyName">
								<aui:validator name="required" errorMessage="sys-contactus-error-company-name-required" />
							</aui:input>
						</div>
						<div class="col-md-12">
							<aui:input type="text" name="country" label="sys-contactus-label-country"
								id="country">
								<aui:validator name="required" errorMessage="sys-contactus-error-country-required" />
								<aui:validator name="custom" errorMessage="sys-contactus-error-country-invalid">
									function(val) {
									    var regex = /^[a-zA-Z\s]*$/; 
									    return regex.test(val);  
									}
								</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<aui:input type="textarea" name="additionalInfo"
								label="sys-contactus-label-additional-info" id="additionalInfo">
								<aui:validator name="maxLength">
									<liferay-ui:message key="sys-contactus-additional-info-max-length"/>
								</aui:validator>
							</aui:input>
						</div>
						<div class="col-md-12 termsAndConditions">
							<aui:input name="termsAndConditions" type="checkbox" label="I agree to <a href='/web/savancys/terms-and-conditions' target='_blank' class='text-primary text-decoration-underline'>Terms & Conditions</a> of Savancys.">
								<aui:validator name="required" errorMessage="sys-contactus-error-terms-and-conditions-required"></aui:validator>
							</aui:input>
						</div>
						<div class="col-md-12">
					<liferay-captcha:captcha url="<%=captchaResourceURL%>"/>
					<p id="<portlet:namespace/>error-msg" class="alert alert-danger d-none"></p>
					
					</div>
					</div>	
					<aui:button type="submit" cssClass="submit-btn" id="contactUsSubmitForm" 
						value="sys-contactus-submit" />
						
				</aui:form>
				<div class="d-none success-div" id="<portlet:namespace/>success-msg">
					<img alt="thankyou" style="width: 60px;" src="<%=request.getContextPath() + "/image/thank-you.png"%>" width="5">
					<h2 class="mt-2 font-weight-bold">
						<liferay-ui:message key="sys-contactus-thank-you-massage-title"/>
					</h2>
					<p>
						<liferay-ui:message key="sys-contactus-thank-you-massage-description"/>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

	var phoneNumberField = document.querySelector("#<portlet:namespace/>phoneNumber");
	var phoneNumberInput = window.intlTelInput(phoneNumberField,{
		initialCountry : "us",
		separateDialCode : true,
		onlyCountries: ["us"],
		utilsScript : "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.12/js/utils.js",
	});

	$(".iti").addClass("w-100");

	function validateForm(contactUsForm) {
		var liferayForm = Liferay.Form.get(contactUsForm);
		if (liferayForm) {
			var validator = liferayForm.formValidator;
			validator.validate();
			var hasErrors = validator.hasErrors();
			if (hasErrors) {
				validator.focusInvalidField();
				return false;
			}
		}
		return true;
	}

	//function submitContactUsForm(event) {
$('#<portlet:namespace/>contactUsSubmitForm').on('click', function(event) {
    event.preventDefault();
    
    if (validateForm('<portlet:namespace/>contactUsForm')) {
        var formData = $("#<portlet:namespace/>contactUsForm").serialize();

        $.ajax({
            url: '<%= addContactUsURL.toString() %>',
            method: 'POST',
            data: formData,                
            success: function(response) {
                console.log("dsdsd  ",response);

                if (response.status=='error') {
                   console.log("dsjdjs");
                	$("#<portlet:namespace/>error-msg").text(response.message).removeClass('d-none');  
                } 
                if(response.status=='success') {
                	console.log("succ");
                
                    $("#<portlet:namespace/>contactUsForm").addClass("d-none");
                    $("#<portlet:namespace/>success-msg").removeClass('d-none');
                }
            },
            error: function() {
                $("#<portlet:namespace/>error-msg").text('<liferay-ui:message key="common-submit-error"/>').removeClass('d-none');
            }
        });
    } else {
        return false;
    } 
});

</script>