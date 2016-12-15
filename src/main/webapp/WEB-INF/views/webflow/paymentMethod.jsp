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

<!-- For Font Awesome -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

<!-- Latest compiled and minified jQuery  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<!-- Local AngularJS script -->
<script src="resources/javascript/angular.js"></script>
<script>
	function submitform() {
		document.getElementById('paymentmethodform').action = '${flowExecutionUrl}&_eventId=submitPaymentMethod';
		document.getElementById('paymentmethodform').submit();
	}

	function back() {
		document.getElementById('paymentmethodform').action = '${flowExecutionUrl}&_eventId=backtoBillingAddress';
		document.getElementById('paymentmethodform').submit();
	}

	function cancelFlow() {
		document.getElementById('paymentmethodform').action = '${flowExecutionUrl}&_eventId=cancel';
		document.getElementById('paymentmethodform').submit();
	}
</script>
<div class="container" ng-app="">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="text-center">Payment Method</h3>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<form:form id="paymentmethodform" method="POST"
						commandName="paymentMethodModel">
						<div class="form-group">
							<form:label path="paymentmethod">Select Payment Method:</form:label>
							<br> Cash on Delivery&nbsp;
							<form:radiobutton path="paymentmethod" ng-model="cardform"
								value="cash on delivery" />
							&nbsp; Online Payment&nbsp;
							<form:radiobutton path="paymentmethod" ng-model="cardform"
								value="online payment" />
						</div>
					</form:form>
					<div ng-show="cardform == 'cash on delivery'"></div>
					<div ng-show="cardform == 'online payment'">
						<form method="POST">
							<div class="form-group">
								<label for="cardNumber">Card Number</label>
								<div class="input-group">
									<input type="text" class="form-control" name="cardNumber"
										placeholder="Enter Valid Card Number" required="required" />
									<span class="input-group-addon"><i
										class="fa fa-credit-card"></i></span>
								</div>
							</div>
							<div class="form-group">
								<label for="cardExpiry">Expiration Date</label> <input
									type="text" class="form-control" name="cardExpiry"
									placeholder="MM / YY" required="required" />
							</div>
							<div class="form-group">
								<label for="cardCVC">CVV Code</label> <input type="text"
									class="form-control" name="cardCVC"
									placeholder="Enter CVV Code" required="required" />
							</div>
						</form>
					</div>
					<div>
					<input class="btn btn-primary" type="button"
						onclick="back()" value="Back" /> <input
						class="btn btn-success pull-right" style="clear: right;" type="button"
						onclick="submitform()" value="Save & Continue" />
					</div>	
					<div style="padding-top: 5px">
						<input class="btn btn-danger btn-block" type="button"
							onclick="cancelFlow()" value="Cancel" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>