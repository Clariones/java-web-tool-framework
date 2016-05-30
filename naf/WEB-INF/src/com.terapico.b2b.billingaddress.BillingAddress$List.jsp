
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">

	<table class="table table-striped">
		<thead><tr>
		<th>ID</th><th>LINE1</th><th>LINE2</th><th>CITY</th><th>STATE</th><th>COUNTRY</th>
		</tr></thead>
		<tbody>
			<c:if test="${not empty result.billingAddressList}" >
			<c:forEach var="item" items="${result.billingAddressList}">
				<tr><td>${item.id}</td><td>${item.line1}</td><td>${item.line2}</td><td>${item.city}</td><td>${item.state}</td><td>${item.country}</td></tr>
			</c:forEach></c:if>
		
		</tbody>
	</table>		
</div>


