<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="commonHeader.jsp" />
	<div class="container">
		<c:if test="${successMessage==true}">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Success!</strong> Registration successful
			</div>
		</c:if>
		<c:if test="${successMessage==false}">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Error!</strong> The Username is already in use
			</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${error}
			</div>
		</c:if>	
		<div id="mycarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#mycarousel" data-slide-to="0" class="active"></li>
				<li data-target="#mycarousel" data-slide-to="1"></li>
				<li data-target="#mycarousel" data-slide-to="2"></li>
				<li data-target="#mycarousel" data-slide-to="3"></li>
			</ol>
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="resources/images/1.jpg" alt="Gifts"/>
					<div class="carousel-caption">
						<h3>GiftsOnline</h3>
						<p>A complete store for all types of gifts</p>
					</div>
				</div>
				<div class="item">
					<img src="resources/images/2.jpg" alt="Flowers"/>
					<div class="carousel-caption">
						<h3>Flowers</h3>
						<p>We offer a wide range of flowers as gifts</p>
					</div>
				</div>
				<div class="item">
					<img src="resources/images/3.jpg" alt="Cakes"/>
					<div class="carousel-caption">
						<h3>Cakes</h3>
						<p>All types of cakes are available</p>
					</div>
				</div>
				<div class="item">
					<img src="resources/images/4.jpg" alt="Chocolate"/>
					<div class="carousel-caption">
						<h3>Gifts For Him/Her</h3>
						<p>Give gifts to your loved ones</p>
					</div>
				</div>
			</div>
			
			<a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			
			<a class="right carousel-control" href="#mycarousel" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
			
		</div>
	</div>	
		<p style="padding-top: 10px"></p>
<jsp:include page="commonFooter.jsp" />