
<%@ include file="/init.jsp"%>

<portlet:resourceURL var="varSaveRfnexx" id='SaveRfnexx'></portlet:resourceURL>

<form class="w-100 d-flex flex-column align-items-start justify-content-center" name="rfnexxForm" id="rfnexxForm" autocomplete="off">
    <div class="row m-0 w-100">
        <div class="col-12 ">
            <h4 class="h4 sub-h text-yellow cursive fw-400"><liferay-ui:message key="rfnexxcontactusweb.title" /></h4>
            <h2 class="h2 fw-800 mb-4"><liferay-ui:message key="rfnexxcontactusweb.subtitle" /> </h2>
        </div>
        <div class="col-12 col-sm-6 col-md-12 col-lg-6 mb-4">
            <input type="text" name="<portlet:namespace />fullname" id="fullname" placeholder="Name">
        </div>
        <div class="col-12 col-sm-6 col-md-12 col-lg-6 mb-4">
            <input type="email" name="<portlet:namespace />email" id="email" placeholder="Email">
        </div>
        <div class="col-12 mb-4">
            <textarea name="<portlet:namespace />additionalInfo" id="additionalInfo" placeholder="Write a Message"></textarea>
        </div>
        <div class="col-12">
            <button class="theme-btn green" type="button" onclick="validateAndSubmit()"><liferay-ui:message key="rfnexxcontactusweb.send" /></button>
        </div>
    </div>
</form>

<script>
function validateAndSubmit() {
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
}

function ajaxCall() {
    AUI().use('aui-base', 'io', 'aui-io-request', function(A) {
        A.io.request('${varSaveRfnexx}', {
            method: 'post',
            form: { id: '<portlet:namespace />rfnexxForm' },
            on: {
                success: function(event, id) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Success',
                        text: 'Your form has been successfully submitted!',
                    }).then(() => {
                        location.reload(); 
                    });
                },
                end: function(event, id) {
                    console.log("else part...");
                }
            }
        });
    });
}
</script>













<%-- <%@ include file="/init.jsp"%>


<portlet:resourceURL var="varSaveRfnexx" id='SaveRfnexx'></portlet:resourceURL>

<form class="w-100 d-flex flex-column align-items-start justify-content-center" name="rfnexxForm" id="rfnexxForm" autocomplete="off">
	<div class="row m-0 w-100">
		<div class="col-12 ">
			<h4 class="h4 sub-h text-yellow cursive fw-400"><liferay-ui:message key="rfnexxcontactusweb.title" /></h4>
			<h2 class="h2 fw-800 mb-4"><liferay-ui:message key="rfnexxcontactusweb.subtitle" /> </h2>
		</div>
		<div class="col-12 col-sm-6 col-md-12 col-lg-6 mb-4">
			<input type="text" name="<portlet:namespace />fullname" id="fullname" placeholder="Name">
		</div>
		<div class="col-12 col-sm-6 col-md-12 col-lg-6 mb-4">
			<input type="email" name="<portlet:namespace />email" id="email" placeholder="Email">
		</div>
		<div class="col-12 mb-4">
			<textarea name="<portlet:namespace />additionalInfo" id="additionalInfo" placeholder="Write a Message"></textarea>
		</div>
		<div class="col-12">
			<button class="theme-btn green" onclick="ajaxCall()"><liferay-ui:message key="rfnexxcontactusweb.send" /></button>
		</div>
	</div>
</form>

<script>
function ajaxCall(){
    AUI().use('aui-base', 'io', 'aui-io-request', function(A) {        
        A.io.request('${varSaveRfnexx}', {
            method: 'post',             
            form: { id: '<portlet:namespace />rfnexxForm' },              
            on: {
                success: function(event, id) {
                	Swal.fire({
                        icon: 'success',
                        title: 'Success',
                        text: 'Your form has been successfully submitted!',
                    }).then(() => {
                        location.reload(); 
                    });
                },
                end: function(event, id) {
                    console.log("else part...");
                }
            }
        });
    });
}
</script>  --%>