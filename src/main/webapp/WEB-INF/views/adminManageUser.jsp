<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminHeader.jsp"></jsp:include>
<script src="resources/javascript/dirPagination.js"></script>
<script>
	var uclist = ${usercredlistkey};
	angular.module("repeatApp", ['angularUtils.directives.dirPagination']).controller("repeatController", function($scope) {
		$scope.usercreds = uclist;
	});
</script>
<div ng-app="repeatApp" class="container">
	<c:choose>
	<c:when test="${adminClickedEditUser==true}">
	<form:form class="jumbotron" action="adminUpdateUser" method="POST" commandName="adminuser">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="userName">User name: </form:label>
					<form:input path="userName" class="form-control" placeholder="Enter Username" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:input path="password" class="form-control" placeholder="Enter Password" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="role">Role: </form:label>
					<form:input path="role" class="form-control disabledfield"
						placeholder="Enter Role" required="required" readonly="true"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Update User" />
			</div>
		</div>
	</form:form>
	</c:when>
	<c:otherwise>
	<form:form class="jumbotron" action="adminAddUser" method="POST" commandName="adminuser">
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="userName">User name: </form:label>
					<form:input path="userName" class="form-control" placeholder="Enter Username" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:input path="password" class="form-control" placeholder="Enter Password" required="required"></form:input>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<form:label path="role">Role: </form:label>
					<form:input path="role" class="form-control disabledfield"
						placeholder="Enter Role" required="required" readonly="true"></form:input>
				</div>
			</div>
		</div>
		<div class="row" style="padding-bottom: 5px">
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-primary btn-block" value="Add User" />
			</div>
		</div>
	</form:form>
	</c:otherwise>
	</c:choose>
	<div class="table-responsive">
		<table class="table table-bordered" ng-controller="repeatController">
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Role</th>
					<th>Status</th>
					<th>Edit</th>
					<th>Enable/Disable</th>
				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="usercred in usercreds | itemsPerPage: 5">
					<td>{{usercred.userName}}</td>
					<td>{{usercred.password}}</td>
					<td>{{usercred.role}}</td>
					<td>{{usercred.enabled}}</td>
					<td><a data-placement="top" data-toggle="tooltip" title="Edit" class="btn btn-success btn-xs" href="fetchusercredentialtoupdate?username={{usercred.userName}}"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a data-placement="top" data-toggle="tooltip" title="Enable" class="btn btn-success btn-xs" href="enableuser?username={{usercred.userName}}"><span class="glyphicon glyphicon-check"></span></a>
					<a data-placement="top" data-toggle="tooltip" title="Disable" class="btn btn-danger btn-xs" href="disableuser?username={{usercred.userName}}"><span class="glyphicon glyphicon-unchecked"></span></a></td>
				</tr>
			<tbody>
		</table>
		<dir-pagination-controls></dir-pagination-controls>
	</div>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>