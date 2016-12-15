<jsp:include page="commonHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var prodlist = ${prodlistkey};
	angular.module("repeatApp", ['angularUtils.directives.dirPagination']).controller("repeatController", function($scope) {
		$scope.products = prodlist;
	});
</script>
<div ng-app="repeatApp" ng-controller="repeatController" class="container">
	<div class="row">
		<div ng-repeat="product in products" class="col-sm-3">
			<div class="panel panel-primary">
				<div class="panel-heading text-center">{{product.product_name}}</div>
				<div class="panel-body"><img ng-src="./resources/product_images/{{product.product_id}}.jpg" class="img-responsive"/></div>
				<div class="panel-footer text-center">{{product.product_price}}</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>