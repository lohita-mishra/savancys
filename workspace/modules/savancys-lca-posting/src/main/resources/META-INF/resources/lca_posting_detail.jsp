<%@ include file="init.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.designation{
	font-size: xxx-large;
}	

</style>


<div class="container">
	<div>
		<h1 class="h1 designation">${lcaPosting.designation}</h1>
		<h6 class="h6 location mt-3">${lcaPosting.location}</h6>
	</div>
	<div class="row mt-3">
		<div class="col-md-8">
			<p class="description">${lcaPosting.getDescription()}</p>
		</div>
		<div class="col-md-4 border">
			<p>Posted Date: <fmt:formatDate type="both" pattern="MMMM dd, yyyy" timeZone="Asia/Calcutta"
	                value="${lcaPosting.createDate}" /></p>
			<p>Location: ${lcaPosting.location}</p>
			<p>O-Net Code: ${lcaPosting.getONetCode()}</p>
		</div>
	</div>


</div>