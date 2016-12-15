<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="commonHeader.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="col-sm-6 col-sm-offset-3 jumbotron">
<h3 class="text-center">Login</h3>
<c:if test="${not empty error}">
	<div class="alert alert-danger alert-dismissible">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		${error}
	</div>
</c:if>
<form method="POST" action="perform_login">
	<div class="form-group">
		<label for="uname">User name:</label> <input type="text"
			name="username" id="uname" class="form-control"
			placeholder="Enter Registered User Name" required>
	</div>
	<div class="form-group">
		<label for="pass">Password:</label> <input type="password"
			name="password" id="pass" class="form-control"
			placeholder="Enter Password" required>
		<small style="padding-top: 5px; clear: left" class="pull-right">
			Forgot <a href="#">Password?</a>
		</small>
		<small class="pull-left" style="padding-top: 5px; clear: right;">Not a member? <a data-toggle="modal" data-target="#register">Register here</a></small>
	</div>
	<input type="submit" class="btn btn-primary btn-block" value="Submit">
</form>
</div>
</div>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>