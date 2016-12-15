<jsp:include page="commonHeader.jsp"></jsp:include>
<script>
	var dispprodlist = ${displayprodlist};
</script>
<div ng-controller="productController" class="container">
	<div class="row" style="padding-bottom: 5px">
		<div class="col-sm-6">
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label>Search:</label>
				<input type="text" ng-model="search" class="form-control" placeholder="Type to search" />
			</div>
		</div>
		<div class="col-sm-3">		
			<div class="form-group">
				<label>Products per Page:</label>
				<input type="number" min="4" max="40" step="4" class="form-control" ng-model="itemsperpage" placeholder="Enter Products per Page" />
			</div>	
		</div>
	</div>
	<div class="row">
		<div dir-paginate="product in dispproducts | filter: search | itemsPerPage: itemsperpage" class="col-sm-3">
			<div class="panel panel-primary">
				<div class="panel-heading text-center">{{product.product_name}}</div>
				<div class="panel-body"><a href="selectedproduct?id={{product.product_id}}"><img ng-src="./resources/product_images/{{product.product_id}}.jpg" class="img-responsive"/></a></div>
				<div class="panel-footer text-center"><i class="fa fa-inr" style="color:black"></i> {{product.product_price}}</div>
			</div>
		</div>
	</div>
	<dir-pagination-controls></dir-pagination-controls>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>