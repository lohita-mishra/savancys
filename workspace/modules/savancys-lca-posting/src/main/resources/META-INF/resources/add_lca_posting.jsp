<%@ include file="init.jsp"%>

<portlet:actionURL name="addLcaPost" var="addLcaPostURL" />

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>

<div class="container border p-5 ">
	<div class="header mb-3">
		<h4>LCA Posting</h4>
	</div>
	<aui:form action="<%=addLcaPostURL%>" method="post" name="fm">
		<div class="row">
			<div class="col-md-6">
				<aui:input type="text" name="designation" label="Designation">
					<aui:validator name="required" />
				</aui:input>
			</div>
			<div class="col-md-6">
				<aui:input type="text" name="oNetCode" label="O-Net Code">
					<aui:validator name="required" />
				</aui:input>
			</div>
			<div class="col-md-12">
				<aui:input type="text" name="location" label="Location">
					<aui:validator name="required" />
				</aui:input>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<label for="description">Description</label>
					<liferay-ui:input-editor name="description" contents="">
					</liferay-ui:input-editor>
				</div>
			</div>
			<aui:button href="<%=backURL%>" name="back" value="Back"/>
			<aui:button type="submit" cssClass="ml-auto" name="submit"
				value="Submit" />
		</div>
	</aui:form>
</div>