
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">

	<table class="table table-striped">
		<thead><tr>
		<th>ID</th><th>NAME</th><th>CARD_NUMBER</th>
		</tr></thead>
		<tbody>
			<c:if test="${not empty result.paymentGroupList}" >
			<c:forEach var="item" items="${result.paymentGroupList}">
				<tr><td>${item.id}</td><td>${item.name}</td><td>${item.cardNumber}</td></tr>
			</c:forEach></c:if>
		
		</tbody>
	</table>		
</div>


