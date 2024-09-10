<%@ include file="init.jsp"%>

<style>
.requestDemoForm{
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

<portlet:resourceURL var="requestDemoFormURL" id='requestFormDemo'></portlet:resourceURL>

<aui:form cssClass="w-100 d-flex flex-column align-items-start justify-content-center requestDemoForm" name="requestDemoForm" id="requestDemoForm" autocomplete="off">
    <aui:input name="hidden" name="type" value="Demo"></aui:input>
    <div class="row m-0 w-100">
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="text" name="fullname" id="fullname" placeholder="Contact Name" label="">
            	<aui:validator name="required" errorMessage="Contact is required." />
				<aui:validator name="alpha"/>
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
            	<aui:validator name="alpha"/>
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-4 mb-4 p-0">
            <aui:input type="text" name="postcode" id="postcode" label="" placeholder="Postcode">
              <aui:validator name="required" errorMessage="Postcode is required." />
              <aui:validator name="digits"/>
            </aui:input>
        </div>
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="email" name="contactPhone" id="contactPhone" placeholder="Contact Number" label="">
             	<aui:validator name="required" errorMessage="Contact Number is required." />
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
            <aui:input type="textarea" label="" style="height:5rem;" name="additionalInfo" id="additionalInfo" placeholder="Let's talk about your idea">
            	<aui:validator name="maxLength">500</aui:validator>
            </aui:input>
        </div>
        <div class="col-12 p-0">
            <button class="theme-btn " type="button" onclick="ajaxCall()">SUBMIT</button>
        </div>
    </div>
</aui:form>

<script>

function validateForm(requestDemoForm) {
	var liferayForm = Liferay.Form.get(requestDemoForm);
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
	if (validateForm('<portlet:namespace/>requestDemoForm')) {
	    AUI().use('aui-base', 'io', 'aui-io-request', function(A) {
	        A.io.request('${requestDemoFormURL}', {
	            method: 'post',
	            form: { id: '<portlet:namespace />requestDemoForm' },
	            on: {
	                success: function(event, id) {
	                	console.log(submitted);
	                },
	                end: function(event, id) {
	                    console.log("else part...");
	                }
	            }
	        });
	    });
	} else {
		return false;
	} 
}
</script>
