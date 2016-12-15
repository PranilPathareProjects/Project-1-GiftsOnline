<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Favicon -->
<link rel="icon" href="resources/images/favicon16.png" type="image/ico"></link>

<title>GiftsOnline</title>
	
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Custom CSS -->
<link rel="stylesheet" href="resources/css/CustomStyle.css">
	
<!-- Latest compiled and minified jQuery  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
<!-- Latest compiled and minified JavaScript --> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
	function cancelFlow() {
		document.getElementById('shippingaddressform').action = '${flowExecutionUrl}&_eventId=cancel';
		document.getElementById('shippingaddressform').submit();
	}
</script>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="text-center">Shipping Address</h3>
			<p>${cartDAO.productsincart}</p>
		</div>
		<div class="panel-body">	
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<form:form id="shippingaddressform" method="POST" commandName="shippingAddressModel">
					<div class="form-group">
						<form:label path="shippingaddress">Shipping Address: </form:label>
						<form:textarea path="shippingaddress" class="form-control"
							placeholder="Enter Shipping Address" rows="3" required="required"></form:textarea>
					</div>
					<div class="form-group">
						<form:label path="shippingaddress_city">City:</form:label>
						<form:input path="shippingaddress_city" class="form-control"
							placeholder="Enter City" required="required"></form:input>
					</div>
					<div class="form-group">
						<form:label path="shippingaddress_pincode">Pincode:</form:label>
						<form:input path="shippingaddress_pincode" class="form-control" placeholder="Enter Pincode" required="required"></form:input>
					</div>
					<div class="form-group">
						<form:label path="shippingaddress_state">State:</form:label>
						<form:input path="shippingaddress_state" class="form-control"
							placeholder="Enter State" required="required"></form:input>
					</div>
					<input class="btn btn-success pull-right" name="_eventId_submitShippingAddress" type="submit" value="Save & Continue" /><br>
					<div style="padding-top: 20px">
					<input class="btn btn-danger btn-block" type="button" onclick="cancelFlow()" value="Cancel" />
					</div>
				</form:form>
			</div>	
	</div>
	</div>
</div>
</div>