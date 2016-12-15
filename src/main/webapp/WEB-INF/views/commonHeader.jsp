<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<title>GiftsOnline</title>
	<!-- Favicon -->
	<link rel="icon" href="resources/images/favicon16.png" type="image/ico"></link>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- For Font Awesome -->
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	
	<!-- Local minified CSS and Font Awesome 
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/font-awesome.min.css"> --> 
	
	<!-- Custom CSS -->
	<link rel="stylesheet" href="resources/css/CustomStyle.css">
	
	<!-- Optional theme -->
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">  -->
	
	<!-- Latest compiled and minified jQuery  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript --> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<!-- AngularJS CDN -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> -->
	<script src="resources/javascript/angular.js"></script>
	
	<!-- Custom JavaScript -->
	<script src="resources/javascript/CustomJS.js"></script>
	<!-- Local minified jQuery and minified JavaScript -->
	<!--  <script src="resources/javascript/jquery.min.js"></script> --> 
	<!-- <script src="resources/javascript/bootstrap.min.js"></script> --> 
	<script src="resources/javascript/dirPagination.js"></script>
	<script>
		var catlist = ${catlistkey};
		var repeatapp = angular.module("repeatApp", ['angularUtils.directives.dirPagination']);
		
		repeatapp.controller("categoryController", function($scope) {
			$scope.categories = catlist;
		});
		
		repeatapp.controller("productController", function($scope) {
			$scope.dispproducts = dispprodlist;
			$scope.itemsperpage = 4;
		});
		
		repeatapp.controller("selectedProductController", function($scope) {
			$scope.selectproduct = selectedproductlist;
		});
		
		repeatapp.controller("cartDisplayController", function($scope) {
			$scope.carts = carts;
		});
	</script>
</head>
<body ng-app="repeatApp">
	<!-- logo and Header-->
	<header class="head">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">			
					<a href="home"><img class="headlogo" src="resources/images/GiftsOnlineLogo.png"/></a>
				</div>
				<div class="col-xs-6">			
					<ul class="nav navbar-nav pull-right">
						<c:choose>
							<c:when test="${userloggedin==true}">
								<li><a href="perform_logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							</c:when>
							<c:otherwise>						
								<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
								<li><a data-toggle="modal" data-target="#register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
							</c:otherwise>
						</c:choose>	
							<li><a href="trackorder"><span class="fa fa-truck fa-lg"></span> Track Order</a></li>
							<li><a href="cart"><span class="glyphicon glyphicon-shopping-cart"></span> My Cart (${total_quantity})</a></li>
					</ul>
					<c:if test="${not empty loggedinuser}">
					<p class="pull-right" style="padding-top: 20px; color: #D80000; clear: right;">Welcome! ${loggedinuser}</p>	
					</c:if>
				</div>
			</div>	
		</div>
	</header>
	<!-- logo and header end -->
	<!-- Navigation bar -->
	<nav class="navbar navbar-inverse">
  		<div class="container">
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mynavbar">
      				<span class="icon-bar"></span>
      				<span class="icon-bar"></span>
      				<span class="icon-bar"></span>
      			</button>
    		</div>
	    	<div ng-controller="categoryController" class="collapse navbar-collapse" id="mynavbar">	
	    		<ul class="nav navbar-nav">
	      			<li><a href="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	      			<!-- <li><a href="flowers">Flowers</a></li>
	      			<li><a href="cakes">Cakes</a></li> 
	      			<li class="dropdown">
	      				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Gifts
	      				<span class="caret"></span></a>
	      					<ul class="dropdown-menu">
	      						<li><a href="giftsformen">Gifts for Men</a></li>
	      						<li><a href="giftsforwomen">Gifts for Women</a></li>
	      					</ul> 
	      			</li> -->
	      			<li ng-repeat="category in categories"><a href="fetchproductsbycategory?category_id={{category.category_id}}">{{category.category_name}}</a></li>
	      			<li><a href="aboutus">About Us</a></li>
	      			<li><a href="contactus">Contact Us</a></li>
	      		</ul>
	      		<!-- <ul class="nav navbar-nav navbar-right">		
	      			<li><a href="admin">Admin Panel</a></li>	
	    		</ul> -->
	    	</div>
	    </div>
	</nav>
	<!-- Navigation bar end-->
	<!-- Modal form for registration -->
	<div id="register" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1>Register</h1>
				</div>
				<div class="modal-body">
						<form:form action="registeruser" commandName="user" method="POST">
						<div class="form-group">
							<form:label path="user_firstname">First Name: </form:label>
							<form:input path="user_firstname" class="form-control" placeholder="Enter First Name" required="required"></form:input>
						</div>	
						<div class="form-group">
							<form:label path="user_lastname">Last Name:</form:label>
							<form:input path="user_lastname" class="form-control" placeholder="Enter Last Name" required="required"></form:input>
						</div>	
						<div class="form-group">
							<form:label path="userName">User Name:</form:label>
							<form:input path="userName" class="form-control" placeholder="Enter User Name" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="user_emailid">E-mail:</form:label>
							<form:input path="user_emailid" class="form-control" type="email" placeholder="Enter Email ID" required="required" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Enter valid mail ID"></form:input>
						</div>
						<div class="form-group">
							<form:label path="user_password">Password:</form:label>
							<form:password path="user_password" id="password" class="form-control" placeholder="Enter Password" required="required" pattern="^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#~$%^&*_]).{8,}$" title="The password must contain at least one number and one uppercase and lowercase letter and one special character like !,@,#,~,$,%,^,&,*,_ only, and at least 8 or more characters"></form:password>
						</div>	
						<div class="form-group">
							<form:label path="user_confirmpassword">Confirm Password:</form:label>
							<form:password path="user_confirmpassword" id="confirmpassword" onkeyup="checkPass(); return false;" class="form-control" placeholder="Re-enter Password" required="required"></form:password>
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>
						<div class="form-group">
							<form:label path="user_contactno">Contact Number:</form:label>
							<form:input path="user_contactno" class="form-control" placeholder="Enter Contact Number" required="required" pattern="(^[1-8]\d{9}$)|(^[789]\d{9}$)" title="Please enter a valid contact number (including STD code for landlines) but excluding the zero at the start"></form:input>
						</div>
						<div class="form-group">
							<form:label path="user_address">Address:</form:label>
							<form:textarea path="user_address" rows="3" class="form-control" placeholder="Enter Address" required="required"></form:textarea>
						</div>
						<div class="form-group">
							<form:label path="user_city">City:</form:label>
							<form:input path="user_city" class="form-control" placeholder="Enter City" required="required"></form:input>
						</div>
						<div class="form-group">	
							<form:label path="user_pincode">Pincode:</form:label>
							<form:input path="user_pincode" class="form-control" placeholder="Enter Pincode" required="required" pattern="^[1-9][0-9]{5}$" title="Please enter a valid pincode"></form:input>
						</div>
						<div class="form-group">
							<form:label path="user_state">State:</form:label>
							<form:input path="user_state" class="form-control" placeholder="Enter State" required="required"></form:input>
						</div>
						<div style="margin-bottom: 9px;">
							<form:label path="user_gender">Gender:</form:label>
							<form:radiobutton path="user_gender" value="male" checked="checked" />Male&nbsp;<form:radiobutton path="user_gender" value="female" />Female
						</div>
						<div class="form-group">
							<form:label path="user_dob"></form:label>
							<form:input path="user_dob" class="form-control" type="date" required="required"></form:input>
						</div>
						<div class="form-group">
							<form:label path="user_acceptprivacy">Accept Privacy Policy</form:label>
							<form:checkbox path="user_acceptprivacy" value="accept" required="required" />
							<a data-target="#privacy" data-toggle="modal" data-dismiss="modal">Read Policy</a>
						</div>
						<input class="btn btn-primary btn-block" type="submit" value="Submit">
						</form:form>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal form for registration end-->
	<!-- Modal form for login -->
	<%-- <div id="login" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1>Login</h1>
				</div>
				<div class="modal-body">
					<form method="post" action="validate">
						<div class="form-group">
							<label for="uname">Email ID:</label>
							<input type="text" name="username" id="uname" class="form-control" placeholder="Enter Registered Email ID" required>
						</div>
						<div class="form-group">
							<label for="pass">Password:</label>
							<input type="password" name="password" id="pass" class="form-control" placeholder="Enter Password" required>
							<p style="padding-top: 5px" class="pull-right">Forgot <a href="#">Password?</a></p>
						</div>
						<input type="submit" class="btn btn-primary btn-block" value="Submit">
					</form>
				</div>
				<div class="modal-footer">
					<p class="pull-left">Not a member? <a data-toggle="modal" data-target="#register" data-dismiss="modal">Register here</a></p>
					<button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Close</button>
				</div>
			</div>
		</div>
	</div> --%>
	<!-- Modal form for login end-->
	<!-- Modal for Privacy policy-->
	<div id="privacy" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1>Privacy Policy</h1>
				</div>
				<div class="modal-body">
					<p>GiftsOnline is committed to safeguarding your privacy online. We recognize your need for reasonable control of personally identifiable information that you share with Giftsonline.</p> 
					<p>When you order, we need to know your name, e-mail address, mailing address, credit card number, and expiration date. This allows us to process and fulfill your order. This will used only for the service you have sought and would not be under any circumstances passed on fo any other commercial purpose. GiftsOnline will not disclose any of your personally identifiable information except when we have your permission or under special circumstances, such as when we believe in good faith that the law requires it.</p> 
					<p>Although we track the total number of visitors to each of sites in an aggregate form to allow us to update an improve our sites, personally identifiable information is not extracted in this process. Any cookie technology (where our servers deposit special codes on a visitor's computer) will only be used to track non-personal information such as type of browser,operating system, and domain names to improve our visitor's online experience. </p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#register" data-dismiss="modal">Back</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal for Privacy policy end-->