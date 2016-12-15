<jsp:include page="commonHeader.jsp"></jsp:include>
<script>
	var selectedproductlist = ${selectedproduct};
	
	function checklogin()
	{
		var userlogin = ${userloggedin};
		if(userlogin==false)
		{
			alert("Please login and then add this product to cart again");
		}		
	}
</script>
<div class="container" ng-controller="selectedProductController" style="padding-bottom: 10px">
	<div class="row">
		<div class="col-sm-4">
			<img ng-src="./resources/product_images/{{selectproduct.product_id}}.jpg" class="img-responsive-selected" />
		</div>
		<div class="col-sm-8">
			<h3>{{selectproduct.product_name}}</h3>
			<hr style="border: 1px solid black;">
			<p><strong>Description</strong>: {{selectproduct.product_description}}</p>
			<p><strong>Price</strong>: <i class="fa fa-inr" style="color:black"></i> {{selectproduct.product_price}}</p>
			<p><strong>Size</strong>: {{selectproduct.productdetail_size}}<br>
			<strong>Weight in grams</strong>: {{selectproduct.productdetail_weight}}<br>
			<strong>Color</strong>: {{selectproduct.productdetail_color}}<br></p>
			<a class="btn btn-primary" onclick="checklogin()" href="addtocart?id={{selectproduct.product_id}}">Add to Cart</a>
			<a class="btn btn-primary pull-right" onclick="checklogin()" href="addtocart?id={{selectproduct.product_id}}">Buy Now</a>
		</div>	
	</div>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>