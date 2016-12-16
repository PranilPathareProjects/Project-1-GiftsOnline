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
		{{selectedOrder.date_of_addition}}
		{{selectedOrder.date_processed}}
		{{selectedOrder.date_delivered}}
	</div>	
	</c:otherwise>
	</c:choose>
	<a href="home" class="btn btn-primary pull-right">Continue Shopping</a>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>