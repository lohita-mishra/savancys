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

<aui:form cssClass="w-100 d-flex flex-column align-items-start justify-content-center rfnexxForm" name="rfnexxForm" id="rfnexxForm" autocomplete="off">
    <div class="row m-0 w-100">
        <div class="col-12 col-sm-6 col-md-12 col-lg-12 mb-4 p-0">
            <aui:input type="text" name="fullname" id="fullname" placeholder="Contact Name" label="">
            	<aui:validator name="required" errorMessage="Contact is required." />
				<aui:validator name="custom" errorMessage="Invalid Contact Name">
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
            	<aui:validator name="custom" errorMessage="Invalid City">
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
/* function validateAndSubmit() {
    const namePattern = /^[a-zA-Z\s]+$/;
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    const fullname = document.getElementById('fullname').value;
    const email = document.getElementById('email').value;

    if (!namePattern.test(fullname)) {
        Swal.fire({
            icon: 'error',
            title: 'Invalid Name',
            text: 'Please enter a valid name. Only letters and spaces are allowed.',
        });
        return;
    }

    if (!emailPattern.test(email)) {
        Swal.fire({
            icon: 'error',
            title: 'Invalid Email',
            text: 'Please enter a valid email address.',
        });
        return;
    }

    ajaxCall();
} */


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
	    AUI().use('aui-base', 'io', 'aui-io-request', function(A) {
	        A.io.request('${varSaveRfnexx}', {
	            method: 'post',
	            form: { id: '<portlet:namespace />rfnexxForm' },
	            on: {
	                success: function(event, id) {
	                	console.log("submitted");
	                    /* Swal.fire({
	                        icon: 'success',
	                        title: 'Success',
	                        text: 'Your form has been successfully submitted!',
	                    }).then(() => {
	                        location.reload(); 
	                    }); */
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
