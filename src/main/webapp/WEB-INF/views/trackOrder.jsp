<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="commonHeader.jsp"></jsp:include>
<script>
	var orderlist = ${orderlistbyuser};
</script>
<div class="container" style="padding-bottom: 10px">
	<c:choose>
	<c:when test="${OrderNotPlaced==true}">
		<h4 class="text-center">You haven't ordered anything!</h4>
	</c:when>
	<c:otherwise>
	<div ng-controller="orderDisplayController">
		<p>Please choose the order no.:</p>
		<select ng-options="order.order_id for order in orderlist" ng-model="selectedOrder">
		</select>
		<br>
		<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Date Ordered</th>
					<th>Date Processed</th>
					<th>Date Delivered</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td ng-init="selectedOrder.date_of_addition = Date" ng-bind="formatDate(selectedOrder.date_of_addition) | date: 'dd/MM/yyyy'"></td>
					<td ng-bind="formatDate(selectedOrder.date_processed) | date: 'dd/MM/yyyy'"></td>
					<td ng-bind="formatDate(selectedOrder.date_delivered) | date: 'dd/MM/yyyy'"></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>	
	</c:otherwise>
	</c:choose>
	<a href="home" class="btn btn-primary pull-right">Continue Shopping</a>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>