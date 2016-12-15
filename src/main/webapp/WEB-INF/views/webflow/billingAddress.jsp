<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Favicon -->
<link rel="icon" href="resources/images/favicon16.png" type="image/ico"></link>

<title>GiftsOnline</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
<!-- Custom CSS -->
<link rel="stylesheet" href="resources/css/CustomStyle.css">	

<!-- Latest compiled and minified jQuery  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script>
	function back() {
		document.getElementById('billingaddressform').action = '${flowExecutionUrl}&_eventId=backtoShippingAddress';
		document.getElementById('billingaddressform').submit();
	}

	function cancelFlow() {
		document.getElementById('billingaddressform').action = '${flowExecutionUrl}&_eventId=cancel';
		document.getElementById('billingaddressform').submit();
	}
</script>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="text-center">Billing Address</h3>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<form:form id="billingaddressform" method="POST"
						commandName="billingAddressModel">
						<div class="form-group">
							<form:label path="billingaddress">Billing Address: </form:label>
							<form:textarea path="billingaddress" class="form-control"
								placeholder="Enter Billing Address" rows="3" required="required"></form:textarea>
						</div>
						<div class="form-group">
							<form:label path="billingaddress_city">City:</form:label>
							<form:input path="billingaddress_city" class="form-control"
								placeholder="Enter City" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="billingaddress_pincode">Pincode:</form:label>
							<form:input path="billingaddress_pincode" class="form-control"
								placeholder="Enter Pincode" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="billingaddress_state">State:</form:label>
							<form:input path="billingaddress_state" class="form-control"
								placeholder="Enter State" required="required"></form:input>
						</div>
						<input class="btn btn-primary" type="button" onclick="back()"
							value="Back" />
						<input class="btn btn-success pull-right"
							name="_eventId_submitBillingAddress" type="submit"
							value="Save & Continue" />
						<div style="padding-top: 5px">
							<input class="btn btn-danger btn-block" type="button"
								onclick="cancelFlow()" value="Cancel" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
