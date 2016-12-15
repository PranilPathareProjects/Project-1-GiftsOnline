<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="commonHeader.jsp"></jsp:include>
<script>
	var carts = ${cartlist};
</script>
<div class="container" style="padding-bottom: 10px">
	<c:choose>
	<c:when test="${UserCartEmpty==true}">
		<h4 class="text-center">Your cart is Empty!</h4>
		<a href="home" class="btn btn-primary pull-right">Continue Shopping</a>
	</c:when>
	<c:otherwise>
	<div class="table-responsive">
		<table class="table table-bordered" ng-controller="cartDisplayController">
			<thead>
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Remove from Cart</th>
				</tr>			
			</thead>
			<tbody dir-paginate="cart in carts | orderBy: 'cart_id' | itemsPerPage: 5">
				<tr>
					<td>{{cart.cart_id}}</td>
					<td>{{cart.product_name}}</td>
					<td><i class="fa fa-inr" style="color:black"></i> {{cart.price}}</td>
					<td><input type="number" min="1" value="{{cart.quantity}}" ng-model="cart.quantity" />&nbsp;<a data-placement="top" data-toggle="tooltip" title="Update" class="btn btn-success btn-xs" href="updatequantity?quantity={{cart.quantity}}&id={{cart.cart_id}}"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a data-placement="top" data-toggle="tooltip" title="Remove" class="btn btn-danger btn-xs" href="removeproduct?id={{cart.cart_id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<p><strong>Total</strong>: <i class="fa fa-inr" style="color:black"></i> ${total_price}</p>
	<center><dir-pagination-controls></dir-pagination-controls></center><br>
	<a href="home" class="btn btn-primary">Continue Shopping</a>
	<a class="btn btn-primary pull-right" href="checkout">Checkout</a>
	</c:otherwise>
	</c:choose>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>