<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var subcatlist = ${subcatlistkey};
	var catlist = ${categorylistkey};
	angular.module("repeatApp", ['angularUtils.directives.dirPagination']).controller("repeatController", function($scope) {
		$scope.subcategories = subcatlist;
		$scope.categories = catlist;
	});
</script>
<div class="container" ng-app="repeatApp">
	<c:choose>
	<c:when test="${userClickedUpdateSubcategory==true}">
	<form:form ng-controller="repeatController" class="jumbotron" action="adminUpdateSubcategory" method="POST" commandName="subcategory">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="subcategory_id">ID: </form:label>
					<form:input path="subcategory_id" class="form-control disabledfield" readonly="true" placeholder="Enter Subcategory ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="subcategory_name">Name: </form:label>
					<form:input path="subcategory_name" class="form-control" placeholder="Enter Subcategory Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="subcategory_description">Description: </form:label>
					<form:input path="subcategory_description" class="form-control"
						placeholder="Enter Subcategory Description" required="required"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_id">Category: </form:label><br>
					<form:select path="category_id" class="form-control">
						<form:option ng-repeat="category in categories" value="{{category.category_id}}">{{category.category_name}}</form:option>
					</form:select>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update Subcategory" />
			</div>
		</div>	
	</form:form>
	</c:when>
	<c:otherwise>
	<form:form ng-controller="repeatController" class="jumbotron" action="adminAddSubcategory" method="POST" commandName="subcategory">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="subcategory_id">ID: </form:label>
					<form:input path="subcategory_id" class="form-control disabledfield" readonly="true" placeholder="Enter Subcategory ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="subcategory_name">Name: </form:label>
					<form:input path="subcategory_name" class="form-control" placeholder="Enter Subcategory Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="subcategory_description">Description: </form:label>
					<form:input path="subcategory_description" class="form-control"
						placeholder="Enter Subcategory Description" required="required"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_id">Category: </form:label><br>
					<form:select path="category_id" class="form-control">
						<form:option ng-repeat="category in categories" value="{{category.category_id}}">{{category.category_name}}</form:option>
					</form:select>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">	
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add Subcategory" />
			</div>
		</div>
	</form:form>
	</c:otherwise>
	</c:choose>
	<div class="table-responsive">
		<table class="table table-bordered" ng-controller="repeatController">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Category ID</th>
					<th>Status</th>
					<th>Edit/Delete</th>
					<th>Enable/Disable</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="subcategory in subcategories | orderBy: 'subcategory_id' | itemsPerPage: 5">
					<td>{{subcategory.subcategory_id}}</td>
					<td>{{subcategory.subcategory_name}}</td>
					<td>{{subcategory.subcategory_description}}</td>
					<td>{{subcategory.category_id}}</td>
					<td>{{subcategory.subcategory_status}}</td>
					<td><a data-placement="top" data-toggle="tooltip" title="Edit" class="btn btn-success btn-xs" href="fetchsubcategorytoupdate?subcategory_id={{subcategory.subcategory_id}}"><span class="glyphicon glyphicon-pencil"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Delete" class="btn btn-danger btn-xs" href="deletesubcategory?subcategory_id={{subcategory.subcategory_id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
					<td><a data-placement="top" data-toggle="tooltip" title="Enable" class="btn btn-success btn-xs" href="enablesubcategory?subcategory_id={{subcategory.subcategory_id}}"><span class="glyphicon glyphicon-check"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Disable" class="btn btn-danger btn-xs" href="disablesubcategory?subcategory_id={{subcategory.subcategory_id}}"><span class="glyphicon glyphicon-unchecked"></span></a></td>
				</tr>
			<tbody>
		</table>
		<dir-pagination-controls></dir-pagination-controls>
	</div>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>