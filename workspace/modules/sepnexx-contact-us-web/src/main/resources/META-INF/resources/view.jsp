<%@ include file="/init.jsp"%>

<style>
        .error {
            color: red;
        }
    </style>


<liferay-ui:error key="invalid-name" message="Please enter a valid full name (letters and spaces only)."/>
<liferay-ui:error key="invalid-email" message="Please enter a valid email address."/>
<liferay-ui:error key="invalid-mobile" message="Please enter a valid phone number (between 10 and 15 digits)."/>
<liferay-ui:error key="invalid-company-name" message="Please enter a valid company name (letters and spaces only)."/>

<portlet:resourceURL var="varSaveSapnexx" id='SaveSepnexx'></portlet:resourceURL>

<aui:form id="sapnexxForm" name="sapnexxForm" autocomplete="off">
	<div class="row w-100 m-0">
		<div class="col-sm-12 col-md-6">
			<label class="d-flex flex-column" for="fullname"> Full Name <input
				type="text" name="<portlet:namespace />fullname" id="fullname">
			</label>
			<span id="fullnameError" class="error"></span>
		</div>
		<div class="col-sm-12 col-md-6">
			<label class="d-flex flex-column" for="email"> Email <input
				type="text" name="<portlet:namespace />email" id="email">
			</label>
			<span id="emailError" class="error"></span>
		</div>
		<div class="col-sm-12 col-md-6">
			<label class="d-flex flex-column" for="/>phoneNumber"> Phone <input
				type="text" name="<portlet:namespace />phoneNumber" id="phoneNumber">
			</label>
			<span id="phoneNumberError" class="error"></span>
		</div>
		<div class="col-sm-12 col-md-6">
			<label class="d-flex flex-column" for="companyName">
				Company(optional) <input type="text" name="<portlet:namespace />companyName" id="companyName">
			</label>
			 <span id="companyNameError" class="error"></span>
		</div>
		<div class="col-12">
			<label class="d-flex flex-column" for="additionalInfo"> Message <textarea
					name="<portlet:namespace />additionalInfo" id="additionalInfo"></textarea>
			</label>
		</div>
		<div class="col-12 mt-4">
			<input type="submit" value="Send Message" class="cursor-pointer" name="<portlet:namespace />submitBtn" id="submitBtn" >
			<!-- <aui:button class="cursor-pointer" type="button" name="submit" onclick="ajaxCall()" value="Send Message"></aui:button> -->
		</div>
	</div>
</aui:form>


<!-- <script>
function ajaxCall(){
    AUI().use('aui-base', 'io', 'aui-io-request', function(A) {        
        A.io.request('${varSaveSapnexx}', {
            method: 'post',             
            form: { id: '<portlet:namespace />sapnexxForm' },              
            on: {
                success: function(event, id) {
                    console.log("success :: " + id);
                    location.reload();
                },
                end: function(event, id) {
                    console.log("else part...");
                }
            }
        });
    });
}
</script> -->

   
    <script>
    function validateForm() {
    	console.log("validateForm");
    	 var fullname = document.getElementById('fullname').value.trim();
         var email = document.getElementById('email').value.trim();
         var phoneNumber = document.getElementById('phoneNumber').value.trim();
         var companyName = document.getElementById('companyName').value.trim();
         
         // Regular expressions for validation
         var fullnameRegex = /^[a-zA-Z\s]+$/;
         var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
         var phonenumberRegex = /^\d{10,15}$/;
         var companynameRegex = /^[a-zA-Z\s]+$/;

         // Clear previous errors
         clearErrors();

         // Validation messages
         var errors = [];

        
         if(fullname === ""){
        	 errors.push({ field: 'fullname', message: "This field is required" });
         }
         else if (!fullnameRegex.test(fullname)) {
             errors.push({ field: 'fullname', message: "Please enter a valid full name (letters and spaces only)." }); 
         }
         if(email === ""){
        	 errors.push({ field: 'email', message: "This field is required" });
         }
         else if (!emailRegex.test(email)) {
             errors.push({ field: 'email', message: "Please enter a valid email address." });
         }
         if(phoneNumber === ""){
        	 errors.push({ field: 'phoneNumber', message: "This field is required" });
         }
         else if (!phonenumberRegex.test(phoneNumber)) {
             errors.push({ field: 'phoneNumber', message: "Please enter a valid phone number (between 10 and 15 digits)." });
         }

         if (companyName !== "" && !companynameRegex.test(companyName)) {
             errors.push({ field: 'companyName', message: "Please enter a valid company name (letters and spaces only)." });
         }

         // Display errors if any
         if (errors.length > 0) {
             displayErrors(errors);
             return false;
         }

         return true;
     }

    function displayErrors(errors) {
    	 errors.forEach(function(error) {
             var errorElement = document.getElementById(error.field + 'Error');
             if (errorElement) {
                 errorElement.textContent = error.message;
             }
         });
    }

    function clearErrors() {
        var errorElements = document.querySelectorAll('.error');
        errorElements.forEach(function(errorElement) {
            errorElement.textContent = '';
        });
    }
    
    function handleInputChange(event) {
        var field = event.target.name;
        var splitField = field.split('_');
        var actualFieldName = splitField[splitField.length - 1];
        var errorElement = document.getElementById(actualFieldName + 'Error');
        if (errorElement) {
            errorElement.textContent = '';
        }
    }

    var inputFields = document.querySelectorAll('input[name], textarea[name]');
    inputFields.forEach(function(inputField) {
        inputField.addEventListener('input', handleInputChange);
    });

    function submitForm(event) {
        console.log("submit form");
        event.preventDefault();
        var submitBtn = document.querySelector('[name="<portlet:namespace />submitBtn"]');
        if (validateForm()) {
            submitBtn.disabled = true;
            ajaxCall();
        } else {
            console.log('Form validation failed.');
        }
        return false; // Prevent default form submission
    }

    function ajaxCall() {
        AUI().use('aui-base', 'io', 'aui-io-request', function(A) {
            A.io.request('${varSaveSapnexx}', {
                method: 'post',
                form: { id: '<portlet:namespace />sapnexxForm' },
                on: {
                    success: function(event, id) {
                    	 Swal.fire({
                             icon: 'success',
                             title: 'Success',
                             text: 'Your form has been successfully submitted!',
                         }).then(() => {
                             location.reload(); // Reload the page after the user closes the alert
                         });
                    },
                    end: function(event, id) {
                        document.querySelector('[name="<portlet:namespace />submitBtn"]').disabled = false;
                    },
                    failure: function(event, id) {
                        document.querySelector('[name="<portlet:namespace />submitBtn"]').disabled = false;
                    }
                }
            });
        });
    }

    // Attach submitForm as an event handler for the form submission
     document.getElementById('<portlet:namespace />sapnexxForm').addEventListener('submit', submitForm);
    /* document.getElementById('<portlet:namespace />sapnexxForm').addEventListener('submit', ajaxCall); */
    
    </script>
