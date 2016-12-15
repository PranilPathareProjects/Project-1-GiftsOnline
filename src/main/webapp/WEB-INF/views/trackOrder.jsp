<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="commonHeader.jsp"></jsp:include>
<script>
	
</script>
<div class="container" style="padding-bottom: 10px">
	<c:choose>
	<c:when test="${OrderNotPlaced==true}">
		<h4 class="text-center">You haven't ordered anything!</h4>
		<a href="home" class="btn btn-primary pull-right">Continue Shopping</a>
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
	</c:choose>
	<a href="home" class="btn btn-primary pull-right">Continue Shopping</a>
</div>
<jsp:include page="commonFooter.jsp"></jsp:include>