<jsp:include page="adminHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var orderslist = ${orders};
	angular.module("orderApp", ['angularUtils.directives.dirPagination']).controller("orderController", function($scope) {
		$scope.allorders = orderslist;
		
		$scope.updatethedate = function() {
			
		}
	
	});
</script>
<div ng-app="orderApp" class="container">
	<div ng-controller="orderController">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Date Ordered</th>
						<th>Date Processed</th>
						<th>Date Delivered</th>
						<th>Payment Method</th>
						<th>Price</th>
						<th>Username</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<tr dir-paginate="order in allorders | orderBy: 'order_id' | itemsPerPage: 5">
						<td>{{order.order_id}}</td>
						<td>{{order.date_of_addition}}</td>
						<td>{{order.date_processed}} <a href="setdate?id={{order.order_id}}&datefor=Processed" class="btn btn-xs btn-success">Set</a> <a href="resetdate?id={{order.order_id}}&datefor=Processed" class="btn btn-xs btn-danger">Reset</a></td>
						<td>{{order.date_delivered}} <a href="setdate?id={{order.order_id}}&datefor=Delivered" class="btn btn-xs btn-success">Set</a> <a href="resetdate?id={{order.order_id}}&datefor=Delivered" class="btn btn-xs btn-danger">Reset</a></td>
						<td>{{order.paymentmethodmodel.paymentmethod}}</td>
						<td>{{order.total_price}}</td>
						<td>{{order.username}}</td>
						<td>{{order.order_status}}</td>
					</tr>
				<tbody>
			</table>
		</div>
		<dir-pagination-controls></dir-pagination-controls>
	</div>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>