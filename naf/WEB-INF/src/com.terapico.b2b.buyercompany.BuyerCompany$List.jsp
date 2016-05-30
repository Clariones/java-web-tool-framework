
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">

	<table class="table table-striped">
		<thead><tr>
		<th>ID</th><th>NAME</th><th>PRICE_LIST</th>
		</tr></thead>
		<tbody>
			<c:if test="${not empty result.buyerCompanyList}" >
			<c:forEach var="item" items="${result.buyerCompanyList}">
				<tr><td>${item.id}</td><td>${item.name}</td><td>${item.priceList}</td></tr>
			</c:forEach></c:if>
		
		</tbody>
	</table>		
</div>


