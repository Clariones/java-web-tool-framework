
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">

	<table class="table table-striped">
		<thead><tr>
		<th>ID</th><th>BUYER</th><th>SELLER</th><th>TITLE</th><th>TOTAL_AMOUNT</th><th>TYPE</th>
		</tr></thead>
		<tbody>
			<c:forEach var="item" items="${result.lineItemList}">

				<tr><td>${item.id}</td><td>${item.buyer}</td><td>${item.seller}</td><td>${item.title}</td><td>${item.totalAmount}</td><td>${item.type}</td></tr>

			</c:forEach>
		
		</tbody>
	</table>		
</div>


