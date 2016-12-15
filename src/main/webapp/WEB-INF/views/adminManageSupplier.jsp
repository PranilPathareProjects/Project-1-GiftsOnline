<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var suplist = ${suplistkey};
	angular.module("repeatApp", ['angularUtils.directives.dirPagination']).controller("repeatController", function($scope) {$scope.suppliers = suplist;});
</script>
<div class="container">
	<c:choose>
	<c:when test="${userClickedUpdateSupplier==true}">
	<form:form class="jumbotron" action="adminUpdateSupplier" method="POST" commandName="supplier">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_id">ID: </form:label>
					<form:input path="supplier_id" class="form-control disabledfield" readonly="true" placeholder="Enter Supplier ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_name">Name: </form:label>
					<form:input path="supplier_name" class="form-control" placeholder="Enter Supplier Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_address">Address: </form:label>
					<form:textarea rows="2" path="supplier_address" class="form-control"
						placeholder="Enter Supplier Address" required="required"></form:textarea>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_state">State: </form:label>
					<form:input path="supplier_state" class="form-control" placeholder="Enter Supplier State" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_city">City: </form:label>
					<form:input path="supplier_city" class="form-control" placeholder="Enter Supplier City" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_pincode">Pincode: </form:label>
					<form:input path="supplier_pincode" class="form-control"
						placeholder="Enter Supplier Pincode" required="required" pattern="^[1-9][0-9]{5}$" title="Please enter a valid pincode"></form:input>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_contact">Contact Number: </form:label>
					<form:input path="supplier_contact" class="form-control" placeholder="Enter Supplier Contact Number" required="required" pattern="(^[1-8]\d{9}$)|(^[789]\d{9}$)" title="Please enter a valid contact number (including STD code for landlines) but excluding the zero at the start"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_payment">Payment Method: </form:label>
					<form:select multiple="true" path="supplier_payment" class="form-control" required="required">
						<form:option value="Cash On Delivery">Cash On Delivery</form:option>
						<form:option value="Online Payment">Online Payment</form:option>
						<form:option value="Card Payment">Card Payment</form:option>
					</form:select>
				</div>
			</div>
			</div>
			<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update Supplier" />
			</div>
			</div>	
	</form:form>
	</c:when>
	<c:otherwise>
	<form:form class="jumbotron" action="adminAddSupplier" method="POST" commandName="supplier">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_id">ID: </form:label>
					<form:input path="supplier_id" class="form-control disabledfield" readonly="true" placeholder="Enter Supplier ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_name">Name: </form:label>
					<form:input path="supplier_name" class="form-control" placeholder="Enter Supplier Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_address">Address: </form:label>
					<form:textarea rows="2" path="supplier_address" class="form-control"
						placeholder="Enter Supplier Address" required="required"></form:textarea>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_state">State: </form:label>
					<form:input path="supplier_state" class="form-control" placeholder="Enter Supplier State" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_city">City: </form:label>
					<form:input path="supplier_city" class="form-control" placeholder="Enter Supplier City" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_pincode">Pincode: </form:label>
					<form:input path="supplier_pincode" class="form-control"
						placeholder="Enter Supplier Pincode" required="required" pattern="^[1-9][0-9]{5}$" title="Please enter a valid pincode"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_contact">Contact Number: </form:label>
					<form:input path="supplier_contact" class="form-control" placeholder="Enter Supplier Contact Number" required="required" pattern="(^[1-8]\d{9}$)|(^[789]\d{9}$)" title="Please enter a valid contact number (including STD code for landlines) but excluding the zero at the start"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="supplier_payment">Payment Method: </form:label><br>
					<form:select multiple="true" path="supplier_payment" class="form-control" required="required">
						<form:option value="Cash On Delivery">Cash On Delivery</form:option>
						<form:option value="Online Payment">Online Payment</form:option>
						<form:option value="Card Payment">Card Payment</form:option>
					</form:select>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">	
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add Supplier" />
			</div>
		</div>
	</form:form>
	</c:otherwise>
	</c:choose>
	<div ng-app="repeatApp" class="table-responsive">
		<table class="table table-bordered" ng-controller="repeatController">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>State</th>
					<th>City</th>
					<th>Pincode</th>
					<th>Contact Number</th>
					<th>Payment Method</th>
					<th>Edit/Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="supplier in suppliers | orderBy: 'supplier_id' | itemsPerPage: 5">
					<td>{{supplier.supplier_id}}</td>
					<td>{{supplier.supplier_name}}</td>
					<td>{{supplier.supplier_address}}</td>
					<td>{{supplier.supplier_state}}</td>
					<td>{{supplier.supplier_city}}</td>
					<td>{{supplier.supplier_pincode}}</td>
					<td>{{supplier.supplier_contact}}</td>
					<td>{{supplier.supplier_payment}}</td>
					<td><a data-placement="top" data-toggle="tooltip" title="Edit" class="btn btn-success btn-xs" href="fetchsuppliertoupdate?supplier_id={{supplier.supplier_id}}"><span class="glyphicon glyphicon-pencil"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Delete" class="btn btn-danger btn-xs" href="deletesupplier?supplier_id={{supplier.supplier_id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			<tbody>
		</table>
		<dir-pagination-controls></dir-pagination-controls>
	</div>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>