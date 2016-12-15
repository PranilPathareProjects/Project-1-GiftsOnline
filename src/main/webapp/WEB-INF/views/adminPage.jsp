<jsp:include page="adminHeader.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<h4>Active Users in Percentage</h4>
			<div class="progress">
				<div class="progress-bar progress-bar-warning" style="width: ${percent}%"></div>
			</div>
			<!-- <h4>Completed Orders</h4>
			<div class="progress">
				<div class="progress-bar progress-bar-success" style="width:70%;">
				</div>
			</div>
			<h4>Pending Orders</h4>
			<div class="progress">
				<div class="progress-bar progress-bar-warning" style="width:30%;">
				</div>
			</div> -->
		</div>
		<div class="col-sm-6">
			<div class="well">
				<h3 class="text-info"><span class="label label-info pull-right">${totalusers}</span> Total Users</h3>
			</div>
			<div class="well">
				<h3 class="text-success"><span class="label label-success pull-right">${totalorders}</span> Total Orders</h3>
			</div>
		</div>
	</div>
</div>
<jsp:include page="adminFooter.jsp"></jsp:include>