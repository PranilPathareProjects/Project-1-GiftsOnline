<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var catlist = ${catlistkey};
	angular.module("repeatApp", ['angularUtils.directives.dirPagination']).controller("repeatController", function($scope) {$scope.categories = catlist;});
</script>
<div class="container">
	<c:choose>
	<c:when test="${userClickedUpdateCategory==true}">
	<form:form class="jumbotron" action="adminUpdateCategory" method="POST" commandName="category">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_id">ID: </form:label>
					<form:input path="category_id" class="form-control disabledfield" readonly="true" placeholder="Enter Category ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_name">Name: </form:label>
					<form:input path="category_name" class="form-control" placeholder="Enter Category Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_description">Description: </form:label>
					<form:input path="category_description" class="form-control"
						placeholder="Enter Category Description" required="required"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update Category" />
			</div>
		</div>	
	</form:form>
	</c:when>
	<c:otherwise>
	<form:form class="jumbotron" action="adminAddCategory" method="POST" commandName="category">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_id">ID: </form:label>
					<form:input path="category_id" class="form-control disabledfield" readonly="true" placeholder="Enter Category ID" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_name">Name: </form:label>
					<form:input path="category_name" class="form-control" placeholder="Enter Category Name" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="category_description">Description: </form:label>
					<form:input path="category_description" class="form-control"
						placeholder="Enter Category Description" required="required"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add Category" />
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
					<th>Description</th>
					<th>Status</th>
					<th>Edit/Delete</th>
					<th>Enable/Disable</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="category in categories | orderBy: 'category_id' | itemsPerPage: 5">
					<td>{{category.category_id}}</td>
					<td>{{category.category_name}}</td>
					<td>{{category.category_description}}</td>
					<td>{{category.category_status}}</td>
					<td><a data-placement="top" data-toggle="tooltip" title="Edit" class="btn btn-success btn-xs" href="fetchcategorytoupdate?category_id={{category.category_id}}"><span class="glyphicon glyphicon-pencil"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Delete" class="btn btn-danger btn-xs" href="deletecategory?category_id={{category.category_id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
					<td><a data-placement="top" data-toggle="tooltip" title="Enable" class="btn btn-success btn-xs" href="enablecategory?category_id={{category.category_id}}"><span class="glyphicon glyphicon-check"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Disable" class="btn btn-danger btn-xs" href="disablecategory?category_id={{category.category_id}}"><span class="glyphicon glyphicon-unchecked"></span></a></td>
				</tr>
			<tbody>
		</table>
		<dir-pagination-controls></dir-pagination-controls>
	</div>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>