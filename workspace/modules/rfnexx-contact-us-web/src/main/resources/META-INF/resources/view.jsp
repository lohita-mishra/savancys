<%@ include file="init.jsp"%>

<style>
.rfnexxForm{
    background-color: var(--bg-white) !important;
    padding:0px !important;
    input, textarea {
	    border-radius: 0 !important;
	    border-bottom: 0.09rem solid var(--dark) !important;
	}
	button {
	    width: 100% ;
	    display: flex;
	    justify-content: center;
	}
	.form-control:focus {
    box-shadow: none !important;
	}
}

</style>

<portlet:resourceURL var="varSaveRfnexx" id='SaveRfnexx'></portlet:resourceURL>
<portlet:resourceURL id="captcha" var="captchaResourceURL"/>

<aui:form cssClass="w-100 rfnexxForm" name="rfnexxForm" id="rfnexxForm" autocomplete="off">
    <div class="row m-0 w-100">
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="text" name="fullname" id="fullname" placeholder="rfx-contactus-placeholder-name" label="">
            	<aui:validator name="required" errorMessage="rfx-contactus-error-name-required" />
				<aui:validator name="custom" errorMessage="Invalid name">
					function(val) {
						var regex = /^[a-zA-Z\s]*$/; 
						return regex.test(val);  
					}
				</aui:validator>
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="text" name="street" id="street" placeholder="Street" label="">
           		<aui:validator name="required" errorMessage="Street is required." />
				<aui:validator name="maxLength">200</aui:validator>
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-8 col-lg-8 mb-4 p-0 pr-4">
            <aui:input type="text" name="city" id="city" placeholder="City" label="">
            	<aui:validator name="required" errorMessage="City is required." />
            	<aui:validator name="custom" errorMessage="Invalid city">
					function(val) {
						var regex = /^[a-zA-Z\s]*$/; 
						return regex.test(val);  
					}
				</aui:validator>
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-4 mb-4 p-0">
            <aui:input type="text" name="postcode" id="postcode" label="" placeholder="Postcode">
              <aui:validator name="required" errorMessage="Postcode is required." />
              <aui:validator name="digits"/>
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="email" name="contactPhone" id="contactPhone" placeholder="rfx-contactus-placeholder-contact-number" label="">
             	<aui:validator name="required" errorMessage="rfx-contactus-error-contact-number-required" />
				<aui:validator name="digits"/>				
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="email" name="email" id="email" placeholder="Email" label="">
            	<aui:validator name="required" errorMessage="Email is required."/>
				<aui:validator name="email" />
            </aui:input>
        </div>
        <div class="col-12 mb-4 p-0">
            <aui:input type="textarea" label="" style="height:5rem;" name="additionalInfo" id="additionalInfo" placeholder="rfx-contactus-placeholder-additional-info">
            	<aui:validator name="maxLength">500</aui:validator>
            </aui:input>
        </div>
        <div class="col-md-12 p-0">
			<liferay-captcha:captcha url="<%=captchaResourceURL%>" />
			<p id="<portlet:namespace/>error-msg"
				class="alert alert-danger d-none"></p>
		</div>
        <div class="col-12 p-0">
            <button class="theme-btn " type="button" onclick="ajaxCall()"><liferay-ui:message key="rfx-submit-button"/></button>
        </div>
    </div>
</aui:form>

<script>

function validateForm(rfnexxForm) {
	var liferayForm = Liferay.Form.get(rfnexxForm);
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

function ajaxCall() {
	if (validateForm('<portlet:namespace/>rfnexxForm')) {
	    var formData = $("#<portlet:namespace/>rfnexxForm").serialize();

		  $.ajax({
	            url: '${varSaveRfnexx}',
	            method: 'POST',
	            data: formData,                
	            success: function(response) {
	                if (response.status=='error') {
	                	$("#<portlet:namespace/>error-msg").text(response.message).removeClass('d-none');  
	                } 
	                if(response.status=='success') {
	                	Swal.fire({
	                		  title:'<liferay-ui:message key="rfx-thank-you-title"/>',
	                		  text: '<liferay-ui:message key="rfx-thank-you-message"/>',
	                		  icon: "success",
	                		  showConfirmButton: false,
	                		  timer: 2500
	                		}).then(() => {
	                            window.location.reload();
	                        });
	                }
	            },
	            error: function() {
	                $("#<portlet:namespace/>error-msg").text('<liferay-ui:message key="common-submit-error"/>').removeClass('d-none');
	            }
	        });
	} else {
		return false;
	} 
}
</script>
