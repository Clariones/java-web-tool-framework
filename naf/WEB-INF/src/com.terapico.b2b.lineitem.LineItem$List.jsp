
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">

	<table class="table table-striped">
		<thead><tr>
		<th>ID</th><th>SKU_ID</th><th>SKU_NAME</th><th>AMOUNT</th><th>QUANTITY</th>
		</tr></thead>
		<tbody>
			<c:if test="${not empty result.lineItemList}" >
			<c:forEach var="item" items="${result.lineItemList}">
				<tr><td>${item.id}</td><td>${item.skuId}</td><td>${item.skuName}</td><td>${item.amount}</td><td>${item.quantity}</td></tr>
			</c:forEach></c:if>
		
		</tbody>
	</table>		
</div>


