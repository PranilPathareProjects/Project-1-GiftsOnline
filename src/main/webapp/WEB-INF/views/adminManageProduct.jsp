<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var prodlist = ${prodlistkey};
	var catlist = ${categorylistkey};
	var supplist = ${supplierlistkey};
	angular.module("repeatApp", ['angularUtils.directives.dirPagination']).controller("repeatController", function($scope) {
		$scope.products = prodlist;
		$scope.categories = catlist;
		$scope.suppliers = supplist;});
</script>
<div ng-app="repeatApp" class="container">
	<c:choose>
	<c:when test="${userClickedUpdateProduct==true}">
	<form:form ng-controller="repeatController" class="jumbotron" action="adminUpdateProduct" method="POST" commandName="product" enctype="multipart/form-data">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_id">ID: </form:label>
					<form:input path="product_id" class="form-control disabledfield" readonly="true" placeholder="Enter Product ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_name">Name: </form:label>
					<form:input path="product_name" class="form-control" placeholder="Enter Product Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_description">Description: </form:label>
					<form:input path="product_description" class="form-control"
						placeholder="Enter Product Description" required="required"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_price">Price:</form:label>
					<form:input path="product_price" class="form-control"
						placeholder="Enter Product Price" required="required" pattern="^[1-9]([0-9]+)$" title="Please specify the price in numbers and it should not be zero"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_quantity">Quantity:</form:label>
					<form:input path="product_quantity" class="form-control"
						placeholder="Enter Quantity" required="required" pattern="^[1-9][0-9]{0,}$" title="Please specify the quantity in numbers and it should not be zero"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_id">Category:</form:label><br>
					<form:select path="category_id" class="form-control">
						<form:option ng-repeat="category in categories" value="{{category.category_id}}">{{category.category_name}}</form:option>
					</form:select>
				</div>
			</div>
		</div>	
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_id">Supplier:</form:label><br>
					<form:select path="supplier_id" class="form-control">
						<form:option ng-repeat="supplier in suppliers" value="{{supplier.supplier_id}}">{{supplier.supplier_name}}</form:option>
					</form:select>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_image">Product Image:</form:label>
					<form:input path="product_image" class="form-control" type="file" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
				<!-- <label>For additional product details click this:</label>
					<button type="button" data-toggle="modal" data-target="#productdetail" class="btn btn-primary btn-block">Product Details</button> -->
				</div>	
			</div>
		</div>
		<div class="row optionaljumbotron" style="padding-bottom: 5px">
			<h4 class="text-center"><strong>Optional Product Information</strong></h4>
			<hr>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="productdetail_color">Color: </form:label>
					<form:input path="productdetail_color" class="form-control" placeholder="Enter Product Color"></form:input>
				</div>
			</div>	
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="productdetail_weight">Weight: </form:label>
					<form:input path="productdetail_weight" class="form-control"
						placeholder="Enter Product Weight in grams"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="productdetail_size">Size: </form:label>
					<form:input path="productdetail_size" class="form-control"
						placeholder="Enter Product Size"></form:input>
				</div>
			</div>
		</div>	
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update Product" />
			</div>
		</div>
	</form:form>
	</c:when>
	<c:otherwise>
	<form:form ng-controller="repeatController" class="jumbotron" action="adminAddProduct" method="POST" commandName="product" enctype="multipart/form-data">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_id">ID: </form:label>
					<form:input path="product_id" class="form-control disabledfield" readonly="true" placeholder="Enter Product ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_name">Name: </form:label>
					<form:input path="product_name" class="form-control" placeholder="Enter Product Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_description">Description: </form:label>
					<form:input path="product_description" class="form-control"
						placeholder="Enter Product Description" required="required"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_price">Price:</form:label>
					<form:input path="product_price" class="form-control"
						placeholder="Enter Product Price" required="required" pattern="^[1-9]([0-9]+)$" title="Please specify the price in numbers and it should not be zero"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_quantity">Quantity:</form:label>
					<form:input path="product_quantity" class="form-control"
						placeholder="Enter Quantity" required="required" pattern="^[1-9][0-9]{0,}$" title="Please specify the quantity in numbers and it should not be zero"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_id">Category:</form:label>
					<form:select path="category_id" class="form-control">
						<form:option ng-repeat="category in categories" value="{{category.category_id}}">{{category.category_name}}</form:option>
					</form:select>
				</div>
			</div>
		</div>	
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_id">Supplier:</form:label><br>
					<form:select path="supplier_id" class="form-control">
						<form:option ng-repeat="supplier in suppliers" value="{{supplier.supplier_id}}">{{supplier.supplier_name}}</form:option>
					</form:select>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="product_image">Product Image:</form:label>
					<form:input path="product_image" class="form-control" type="file" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">	
			</div>
		</div>
		<div class="row optionaljumbotron" style="padding-bottom: 5px">
			<h4 class="text-center"><strong>Optional Product Information</strong></h4>
			<hr>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="productdetail_color">Color: </form:label>
					<form:input path="productdetail_color" class="form-control" placeholder="Enter Product Color"></form:input>
				</div>
			</div>	
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="productdetail_weight">Weight: </form:label>
					<form:input path="productdetail_weight" class="form-control"
						placeholder="Enter Product Weight in grams"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="productdetail_size">Size: </form:label>
					<form:input path="productdetail_size" class="form-control"
						placeholder="Enter Product Size"></form:input>
				</div>
			</div>
		</div>	
		<div class="row" style="padding-bottom: 5px">	
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add Product" />
			</div>
		</div>
	</form:form>
	</c:otherwise>
	</c:choose>
	<%-- <c:set var="imagefolder" value="E:\\Pranil Pathare\\Project1\\Images\\resources\\product_images\\" /> --%>
	<div class="table-responsive">
		<table class="table table-bordered" ng-controller="repeatController">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Image</th>
					<th>Size</th>
					<th>Weight</th>
					<th>Color</th>
					<th>Category ID</th>
					<th>Supplier ID</th>
					<th>Status</th>
					<th>Edit/Delete</th>
					<th>Enable/Disable</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="product in products | orderBy: 'product_id' | itemsPerPage: 5">
					<td>{{product.product_id}}</td>
					<td>{{product.product_name}}</td>
					<td>{{product.product_description}}</td>
					<td>{{product.product_price}}</td>
					<td>{{product.product_quantity}}</td>
					<td><img ng-src="./resources/product_images/{{product.product_id}}.jpg" height="50px" width="50px" /></td>
					<td>{{product.productdetail_size}}</td>
					<td>{{product.productdetail_weight}}</td>
					<td>{{product.productdetail_color}}</td>
					<td>{{product.category_id}}</td>
					<td>{{product.supplier_id}}</td>
					<td>{{product.product_status}}</td>
					<td><a data-placement="top" data-toggle="tooltip" title="Edit" class="btn btn-success btn-xs" href="fetchproducttoupdate?product_id={{product.product_id}}"><span class="glyphicon glyphicon-pencil"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Delete" class="btn btn-danger btn-xs" href="deleteproduct?product_id={{product.product_id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
					<td><a data-placement="top" data-toggle="tooltip" title="Enable" class="btn btn-success btn-xs" href="enableproduct?product_id={{product.product_id}}"><span class="glyphicon glyphicon-check"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Disable" class="btn btn-danger btn-xs" href="disableproduct?product_id={{product.product_id}}"><span class="glyphicon glyphicon-unchecked"></span></a></td>
				</tr>
			<tbody>
		</table>
	</div>
	<!-- <div class="table-responsive">
		<table class="table table-bordered" ng-controller="repeatController">
			<thead>
				<tr>
					<th>ID</th>
					<th>Color</th>
					<th>Weight</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="productdetail in productdetails | orderBy: 'productdetail_id' | itemsPerPage: 1">
					<td>{{productdetail.productdetail_id}}</td>
					<td>{{productdetail.productdetail_color}}</td>
					<td>{{productdetail.productdetail_weight}}</td>
					<td>{{productdetail.productdetail_size}}</td>
				</tr>
			<tbody>
		</table>
	</div> -->
	<dir-pagination-controls></dir-pagination-controls>
	<%-- <div id="productdetail" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3>Additional Details</h3>
				</div>
				<div class="modal-body">
					<form:form action="productdetails" method="POST" commandName="product">
						<div class="form-group">
							<form:label path="productdetail_id">ID: </form:label>
							<form:input path="productdetail_id" class="form-control" placeholder="Enter Product Detail ID" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="productdetail_color">Color: </form:label>
							<form:input path="productdetail_color" class="form-control" placeholder="Enter Color" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="productdetail_weight">Weight: </form:label>
							<form:input path="productdetail_weight" class="form-control"
								placeholder="Enter Weight" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="productdetail_size">Size: </form:label>
							<form:input path="productdetail_size" class="form-control"
								placeholder="Enter Weight" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="product_id">Product: </form:label>
							<form:input path="product_id" class="form-control"
								placeholder="Enter Product ID" required="required"></form:input>
						</div>
						<input type="submit" class="btn btn-primary btn-block" value="Submit" />
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Close</button>
				</div>
			</div>
		</div>
	</div> --%>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>