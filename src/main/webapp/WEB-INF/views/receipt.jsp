<!-- Favicon -->
<link rel="icon" href="resources/images/favicon16.png" type="image/ico"></link>
<title>GiftsOnline</title>
<!-- For Font Awesome -->
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Custom CSS -->
<link rel="stylesheet" href="resources/css/CustomStyle.css">
	
<!-- Latest compiled and minified jQuery  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
<!-- Latest compiled and minified JavaScript --> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!-- Local AngularJS script -->
<script src="resources/javascript/angular.js"></script>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var cartsforreceipt = ${cartsreceipt};
	angular.module("receiptApp", ['angularUtils.directives.dirPagination']).controller("receiptController", function($scope) {
		$scope.cartsforreceiptgenerate = cartsforreceipt;});
</script>
<div ng-app="receiptApp" class="container">
	<div class="panel panel-primary" ng-controller="receiptController">
		<div class="panel-heading">
			<h3 class="text-center">Receipt</h3>
		</div>
		<div class="panel-body">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Price</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<tr dir-paginate="cartforreceipt in cartsforreceiptgenerate | orderBy: 'cart_id' | itemsPerPage: 5">
						<td>{{cartforreceipt.product_name}}</td>
						<td>{{cartforreceipt.price}}</td>
						<td>{{cartforreceipt.quantity}}</td>
					</tr>
				<tbody>
			</table>
		</div>
		<dir-pagination-controls></dir-pagination-controls>
		{{cartsforreceipt.cart_order_id}}
		{{cartsforreceiptgenerate.cart_order_id}}
		<p class="pull-right"><strong>Total</strong>: <i class="fa fa-inr" style="color:black"></i> ${totalprice}</p>
	<a class="btn btn-primary pull-right" style="clear: both;" href="backtohome">Continue Shopping</a>
	</div>
	</div>
</div>