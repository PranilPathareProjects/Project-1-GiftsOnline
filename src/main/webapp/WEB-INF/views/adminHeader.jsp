<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	<!-- AngularJS CDN 
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script> -->
	
	<script src="resources/javascript/angular.js"></script>
	
	<!-- Local minified jQuery and minified JavaScript -->
	<!--  <script src="resources/javascript/jquery.min.js"></script> --> 
	<!-- <script src="resources/javascript/bootstrap.min.js"></script> -->
</head>
<body>
	<body>
	<!-- logo and Header-->
	<header class="head">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">			
					<img class="headlogo" src="resources/images/GiftsOnlineLogo.png"/>
				</div>
				<div class="col-xs-6">
					<div class="pull-right">
					<ul class="nav navbar-nav">
						<li><a href="perform_logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
					</div>
					<div class="pull-right"  style="clear: right;">
					<c:if test="${not empty loggedinuser}">
					<p style="padding-top: 20px; color: #D80000">Welcome! ${loggedinuser}</p>	
					</c:if>
					</div>	
				</div>
			</div>	
		</div>
	</header>
	<!-- logo and header end -->
	<!-- Navigation bar -->
	<nav class="navbar navbar-inverse">
  		<div class="container">
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar">
      				<span class="icon-bar"></span>
      				<span class="icon-bar"></span>
      				<span class="icon-bar"></span>
      			</button>
    		</div>
	    	<div class="collapse navbar-collapse" id="mynavbar">	
	    		<ul class="nav navbar-nav">
	      			<li><a href="admin"><span class="fa fa-dashboard"></span> Dashboard</a></li>
	      			<li class="dropdown">
	      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Products
	      			<span class="caret"></span></a>
	      				<ul class="dropdown-menu">
	      					<li><a href="manageproduct">Manage Product</a></li>
	      					<li><a href="outofstock">Out of Stock Products</a></li>
	      				</ul> 
	      			</li>
	      			<li><a href="managecategory">Manage Category</a></li>
	      			<li><a href="managesubcategory">Manage Subcategory</a></li>
	      			<li><a href="managesupplier">Manage Supplier</a></li>
	      			<li class="dropdown">
	      			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Orders
	      			<span class="caret"></span></a>
	      				<ul class="dropdown-menu">
	      					<li><a href="manageorders">Manage Order</a></li>
	      					<li><a href="salesreport">Sales Report</a></li>
	      				</ul>
	      			</li>
	      			<li><a href="manageuser">Manage User</a></li>	
	    		</ul>
	    	</div>
  		</div>
	</nav>