<jsp:include page="commonHeader.jsp" />
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
				<h3>caption</h3>
				<p>caption text</p>
			</div>
		</div>
		<div class="item">
			<img src="resources/images/2.jpg" alt="Teddy"/>
			<div class="carousel-caption">
				<h3>caption</h3>
				<p>caption text</p>
			</div>
		</div>
		<div class="item">
			<img src="resources/images/3.jpg" alt="Teddys"/>
			<div class="carousel-caption">
				<h3>caption</h3>
				<p>caption text</p>
			</div>
		</div>
		<div class="item">
			<img src="resources/images/4.jpg" alt="Chocolate"/>
			<div class="carousel-caption">
				<h3>caption</h3>
				<p>caption text</p>
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
<p style="padding-top: 10px"></p>
<jsp:include page="commonFooter.jsp" />